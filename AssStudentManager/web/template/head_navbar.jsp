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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
    </head>
    <body>

        <div>
            <div id="header">
                <div class="header_center">
                    <a href="#">SMS</a>
                </div>

                <div class="header_out">   
                    <div>
                        <p>User : ${sessionScope.username}</p>
                    </div> 
                    <c:if test="${sessionScope.user != null}">
                        <a href="logout"> <i class="fa-solid fa-user"></i> Log Out</a> 
                    </c:if >

                    <c:if test="${sessionScope.user == null}">
                        <a href="login">Log In</a>
                    </c:if>



                </div>
            </div>
