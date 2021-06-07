<%-- 
    Document   : home
    Created on : May 20, 2021, 10:02:13 AM
    Author     : Do Duc Duong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <script src="js/RederPager.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div style="width: 887px; margin: auto;">
            <img id="preheder" src="images/preheader.jpg">
            <h2>My Digital News</h2>
            <p>News</p>
            <div id="body">
                <div id="left-side">
                    <c:if test="${listSearching != null}">
                        <c:if test="${listSearching.size() == 0}">
                            <h3>Not Found!</h3>
                        </c:if>
                        <c:if test="${listSearching != null}">
                            <c:forEach items="${listSearching}" var="l">
                                <h3 id="news-name">${l.name}</h3>
                                <img src="images/i1.jpg"> <br>
                                <textarea readonly id="news-content">${l.content}</textarea>
                                <hr>
                                <span id="writer"><img id="imgWriter" src="images/comment.gif"><img id="imgWriter" src="images/timeicon.gif"/>By ${l.writer} | ${l.date}</span>
                                </c:forEach>
                            <div id="pager"></div>
                        </c:if>

                    </c:if>
                    <c:if test="${listSearching == null}">
                        <h3 id="news-name">${requestScope.newsDisplay.name}</h3>
                        <img src="images/i1.jpg"> <br>
                        <textarea readonly id="news-content">${newsDisplay.content}</textarea>
                        <hr style="width: 90%;">
                        <span id="writer"><img id="imgWriter" src="images/comment.gif"><img id="imgWriter" src="images/timeicon.gif"/>By ${newsDisplay.writer} | ${newsDisplay.date}</span>
                    </c:if>

                </div>



                <div right-side>
                    <h3>Digital News</h3>
                    <textarea readonly id="content-top1">${newsTop1.content}</textarea>
                    <h3>Search</h3>
                    <form action="home" method="POST" id="form">
                        <input type="text" name="textSearch" id="inputText">
                        <input id="sumbitForm" type="submit" value="Go">
                    </form>
                    <h3>Last Articles</h3>
                    <div id="listNewsTop5">

                        <c:forEach items="${listNewsTop5}" var="l">
                            <a href="home?id=${l.id}">${l.name}</a>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <img id="footer" src="images/footer.jpg"> <br>
        </div>
    </body>
</html>
<script>
    RenderPager('pager', ${requestScope.pageIndex}, ${totalPage}, 2, '${requestScope.url}')
</script>