<%-- 
    Document   : login
    Created on : Feb 27, 2023, 12:21:25 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="margin: 0px; margin-top: -22px;">
        <div>
            <form action="login" method="POST">
                <div style="background: #bbcfe1; height: 800px;">
                    <div style="margin-left: 550px;">
                        <h1 style="padding-top: 170px; padding-left: 10px;" > <i class="fa-solid fa-graduation-cap"></i> Student Management System</h1>
                        <div style="border: 3px solid black; width: fit-content; padding: 10px; background: white">
                            <table style="height: 130px;">
                                <caption style="padding: 5px;" >You need to login to use</caption>
                                <tr>
                                    <td></td><td><input style="width: 400px; height: 35px;" type="text" value="${username}" name="username" placeholder="username" /></td>
                                </tr>
                                <tr>
                                    <td></td><td><input style="width: 400px; height: 35px;" type="password" value="${password}" name="password" placeholder="password"/></td>
                                </tr>
                                

                            </table> 
                            <table style="height: 80px;">
                                <tr>
                                <p style="color: red; margin: 0px;" >${mess}</p>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" name="remember" value="remember" />Remember</td><td><input style="margin-left: 205px; padding: 7px 23px; color: white; background: #4f4fee; font-size: 16px;" type="submit" value="Login"/></td>
                                </tr>
                                <tr >
                                    <td><a style="text-decoration: none" href="#">Forgot password?</a>
                                    </td>
                                    <td><a style="text-decoration: none; padding-left: 245px;" href="signup.jsp">Sign Up</a>
                                    </td>
                                </tr>

                            </table>

                        </div>
                    </div>

                </div>
            </form>
        </div>
    </body>
</html>
