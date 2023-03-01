<%-- 
    Document   : signup
    Created on : Feb 28, 2023, 9:36:46 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="margin: 0px; margin-top: -22px;">
        <div>
            <form action="signup" method="POST">
                <div style="background: #bbcfe1; height: 800px;">
                    <div style="margin-left: 550px;">
                        <h1 style="padding-top: 170px; padding-left: 25px;" >Student Management System</h1>
                        <div style="border: 3px solid black; width: fit-content; padding: 10px; background: white">
                            <table style="height: 200px;">
                                <caption style="padding: 5px;" >Create your own account</caption>
                                <tr>
                                    <td></td><td><input style="width: 400px; height: 35px;" type="text" name="username" placeholder="username" /></td>
                                </tr>
                                <tr>
                                    <td></td><td><input style="width: 400px; height: 35px;" type="password" name="password" placeholder="password"/></td>
                                </tr>
                                <tr>
                                    <td></td><td><input style="width: 400px; height: 35px;" type="password" name="re-password" placeholder="re-password"/></td>
                                </tr>


                            </table> 
                            <table style="height: 50px;">
                                <tr>
                                <p style="color: red; margin: 0px; padding-bottom: 5px; text-align: center; font-size: 17px;" >${mess}</p>
                                <p style="color: green; margin: 0px; padding-bottom: 5px; text-align: center; font-size: 17px;" >${mess_s}</p>
                                </tr>
                                <tr>
                                    <td><input style="margin-left: 2px; padding: 7px 150px; color: white; background: #4f4fee; font-size: 16px;" type="submit" value="Create Account"/></td>
                                </tr>
                                <tr>
                                    <td>
                                        <a style="text-decoration: none; color: #4f4fee;line-height: 2" href="login.jsp"> < Back to Login</a>
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
