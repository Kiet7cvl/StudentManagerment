<%-- 
    Document   : detail.jsp
    Created on : Feb 27, 2023, 1:16:40 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styleindex.css"/>
    </head>
    <body>

        <div>
            <div id="header">
                <div class="header_center">
                    <a href="#">SMS</a>
                </div>

                <div class="header_out">   
                    <div>
                        <p>User : ${username}</p>
                    </div> 
                        <c:if test="${sessionScope.user != null}">
                        <a href="logout">Log Out</a> 
                    </c:if >

                    <c:if test="${sessionScope.user == null}">
                        <a href="login">Log In</a>
                    </c:if>



                </div>
            </div>

            <div id="slider">
                <ul class="subnav">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Majors</a></li>
                    <li><a href="#">Classes</a></li>
                    <li><a href="#">Students manager</a></li>
                    <li><a href="#">Lecturers manager</a></li>
                    <li><a href="#">Subjects manager</a></li>
                    <li><a href="#">Attendance managert</a></li>
                </ul>

            </div>