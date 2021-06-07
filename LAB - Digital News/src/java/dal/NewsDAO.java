/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.ArrayList;
import model.News;

/**
 *
 * @author Do Duc Duong
 */
public class NewsDAO extends DBContext {

    public News getTop1RecentNews() {
        try {
            String sql = "SELECT TOP(1) * FROM NEWS \n"
                    + "ORDER BY DATE DESC";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                News n = new News();
                n.setId(resultSet.getInt("ID"));
                n.setContent(resultSet.getString("CONTENT"));
                n.setName(resultSet.getString("NAME"));
                n.setDate(resultSet.getString("DATE"));
                n.setWriter(resultSet.getString("WRITER"));
                return n;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<News> getTop5RecentNews(int id) {
        ArrayList<News> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP(5) * FROM NEWS\n"
                    + "WHERE ID != ?\n"
                    + "ORDER BY DATE DESC ";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                News n = new News();
                n.setId(resultSet.getInt("ID"));
                n.setContent(resultSet.getString("CONTENT"));
                n.setName(resultSet.getString("NAME"));
                n.setDate(resultSet.getString("DATE"));
                n.setWriter(resultSet.getString("WRITER"));
                list.add(n);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public News getNewsById(int newsDisplayId) {
        String sql = "select * from NEWS where ID = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, newsDisplayId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                News n = new News();
                n.setId(resultSet.getInt("ID"));
                n.setContent(resultSet.getString("CONTENT"));
                n.setName(resultSet.getString("NAME"));
                n.setDate(resultSet.getString("DATE"));
                n.setWriter(resultSet.getString("WRITER"));
                return n;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<News> getNewsSearching(String textSearch, int pageSize, int pageIndex) {
        ArrayList<News> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM\n"
                    + "(SELECT ROW_NUMBER() OVER (ORDER BY DATE DESC) AS ROW_ID, * FROM NEWS WHERE NAME LIKE ?) TBL\n"
                    + "WHERE ID >  (? - 1) * ?\n"
                    + "AND ROW_ID < ? * ? + 1";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + textSearch + "%");
            statement.setInt(2, pageIndex);
            statement.setInt(3, pageSize);
            statement.setInt(4, pageIndex);
            statement.setInt(5, pageSize);
            
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                News n = new News();
                n.setId(resultSet.getInt("ID"));
                n.setContent(resultSet.getString("CONTENT"));
                n.setName(resultSet.getString("NAME"));
                n.setDate(resultSet.getString("DATE"));
                n.setWriter(resultSet.getString("WRITER"));
                list.add(n);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getTotalPage(int pageSize, String textSearch) {
        try {
            String sql = "select * from news where NAME like ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + textSearch + "%");
            resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count += 1;
            }
            return (count % pageSize == 0) ? count / pageSize : count / pageSize + 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

}
