/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.NewsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.News;

/**
 *
 * @author Do Duc Duong
 */
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsDAO dbNews = new NewsDAO();
        News newsTop1 = dbNews.getTop1RecentNews();
        int newsDisplayId = newsTop1.getId();
        
        ArrayList<News> listNewsTop5 = dbNews.getTop5RecentNews(newsDisplayId);
        News newsDisplay = dbNews.getNewsById(newsDisplayId);
        request.setAttribute("listNewsTop5", listNewsTop5);
        request.setAttribute("newsDisplay", newsDisplay);
        if (request.getParameter("id") != null) {
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("textSearch")) {
                    cookies[i].setValue("");
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
            newsDisplayId = Integer.parseInt(request.getParameter("id"));
            listNewsTop5 = dbNews.getTop5RecentNews(newsDisplayId);
            newsDisplay = dbNews.getNewsById(newsDisplayId);
            request.setAttribute("listNewsTop5", listNewsTop5);
            request.setAttribute("newsDisplay", newsDisplay);
        } else {
            ArrayList<News> listSearching = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("textSearch")) {
                        String textSearch = cookies[i].getValue();

                        int pageSize = 1;
                        int totalPage = dbNews.getTotalPage(pageSize, textSearch);
                        int pageIndex = 1;
                        if (request.getParameter("page") != null) {
                            pageIndex = Integer.parseInt(request.getParameter("page"));
                        }
                        listSearching = dbNews.getNewsSearching(textSearch, pageSize, pageIndex);
                        listNewsTop5 = dbNews.getTop5RecentNews(-1);
                        request.setAttribute("listNewsTop5", listNewsTop5);
                        request.setAttribute("pageIndex", pageIndex);
                        request.setAttribute("totalPage", totalPage);
                        request.setAttribute("listSearching", listSearching);
                        break;
                    }
                }
            }
            
        }

        request.setAttribute("newsTop1", newsTop1);
        request.getRequestDispatcher("view/home.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String textSearch = request.getParameter("textSearch");
        if (textSearch.equals("")) {
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("textSearch")) {
                    cookies[i].setValue("");
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }

        } else {
            Cookie c = new Cookie("textSearch", textSearch);
            response.addCookie(c);

        }
        response.sendRedirect("home");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
