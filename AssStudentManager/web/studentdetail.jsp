<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/template/head_navbar.jsp"/>

<div id="slider">
    <ul class="subnav">
        <li><a href="home.jsp"><i style="margin-right: 10px;" class="fa-solid fa-house"></i>    Home</a></li>
        <li><a href="majorload"><i style="margin-right: 10px;" class="fa-solid fa-landmark"></i>Majors</a></li>
        <li><a href="classload"><i style="margin-right: 10px;" class="fa-solid fa-building"></i>Classes</a></li>
        <li><a href="subjectload"><i style="margin-right: 10px;" class="fa-sharp fa-solid fa-book"></i>Subjects</a></li>
        <li style="background-color: grey;"><a href="studentload"><div style="display: inline-block;"><i style="margin-right: 10px;" class="fa-solid fa-graduation-cap"></i>Students Manager</div></a></li>
        <li ><a href="studentload"><div style="display: inline-block;"><i style="margin-right: 10px;" class="fa-solid fa-ruler"></i>Lecturers Manager</div></a></li>
    </ul>

    <div style="background-color: lavender; width: 100%;" class="content_major">
        <div style="margin: 50px; background-color: white; padding: 8px; box-shadow: 5px 0px 10px 2px #888888;" class="box">
            <h3>Student Information</h3>

            <div class="major_create">
                <form action="studentupdate?cc=${sc.getId()}" method="POST">
<!--                    <input type="text" name="cc" value=""  />-->
                    <table> 
                        <tbody>
                            <tr>
                                <td style="padding-left: 50px; font-weight: bold;">StudentID</td>
                                <td style="padding-left: 20px; font-weight: bold;">StudentName</td>
                            </tr>
                            <tr>
                                <td><input style="width: 300px;margin: 0px 50px;height: 30px;background: #f2f2f2;" type="text" name="studentid" value="${sc.getStudentid()}" readonly="" /></td>
                                <td><input style="margin-left: 20px;width: 600px;height: 30px;background: #f2f2f2;" type="text" name="name" value="${sc.name}" /></td>
                            </tr>
                            <tr>
                                <td style="padding-left: 50px; padding-top: 15px;font-weight: bold;">Gender</td>
                                <td style="padding-left: 20px; padding-top: 15px;font-weight: bold;">Date Of Birth</td>
                            </tr>
                            <tr>
                                <td><select style="width: 306px;margin: 0px 50px;height: 34px;background: #f2f2f2;" name="gender">
                                        <option value="1">Male</option>
                                        <option value="0">FeMale</option>
                                    </select></td>
                                <td><input style="margin-left: 20px;width: 600px;height: 30px;background: #f2f2f2;" type="date" name="dob" value="${sc.getDob()}" /></td>
                            </tr>
                            <tr>
                                <td style="padding-left: 50px; padding-top: 15px;font-weight: bold;">Picture Of Student</td>
                                <td style="padding-left: 20px; padding-top: 15px;font-weight: bold;">Common Name</td>
                            </tr>
                            <tr>
                                <td style="display: block; height: 30px;background: #f2f2f2;border: 1px solid black;width: 306px;margin-left: 50px;"><input type="submit" value="Select File" disabled=""/> No photo to choose</td>
                                <td><input style="margin-left: 20px;width: 600px;height: 30px;background: #f2f2f2;" type="text" name="cname" value="${sc.getCname()}" /></td>
                            </tr>

                        </tbody>
                    </table>

                    <div style="display: flex">
                        <div>
                            <img style="width: 310px;margin-left: 52px;height: 223px;" src="image/3.jpg" alt="Student Picture"/>
                        </div>
                        <div style="margin-left: 48px;">
                            <table>
                                <tbody>
                                    <tr>
                                        <td style="padding-left: 20px; padding-top: 15px;font-weight: bold;">Place Of Birth</td>
                                    </tr>
                                    <tr>
                                        <td><input style="margin-left: 20px;width: 600px;height: 30px;background: #f2f2f2;" type="text" name="pob" value="${sc.getPob()}" /></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 20px; padding-top: 15px;font-weight: bold;">HomeTown</td>
                                    </tr>
                                    <tr>
                                        <td><input style="margin-left: 20px;width: 600px;height: 30px;background: #f2f2f2;" type="text" name="ht" value="${sc.getHt()}" /></td>
                                    </tr>
                                    <tr>
                                        <td style="padding-left: 20px; padding-top: 15px;font-weight: bold;">Registered place of permanent residence</td>
                                    </tr>
                                    <tr>
                                        <td><input style="margin-left: 20px;width: 600px;height: 30px;background: #f2f2f2;" type="text" name="prr" value="${sc.getPrr()}" /></td>
                                    </tr>
                                </tbody>
                            </table>


                        </div>
                    </div>

                    <table>
                        <tbody>
                            <tr>
                                <td style="padding-left: 50px; padding-top: 15px;font-weight: bold;">ShoolYear</td>
                                <td style="padding-left: 20px; padding-top: 15px;font-weight: bold;">CMND</td>
                            </tr>
                            <tr>
                                <td><input style="width: 300px;margin: 0px 50px;height: 30px;background: #f2f2f2;" type="text" name="nien" value="${sc.getNien()}" /></td>
                                <td><input style="margin-left: 20px;width: 600px;height: 30px;background: #f2f2f2;" type="text" name="CMND" value="${sc.getCMND()}" /></td>
                            </tr>

                            <tr>
                                <td style="padding-left: 50px; padding-top: 15px;font-weight: bold;">Phone</td>
                                <td style="padding-left: 20px; padding-top: 15px;font-weight: bold;">Gmail</td>
                            </tr>
                            <tr>
                                <td><input style="width: 300px;margin: 0px 50px;height: 30px;background: #f2f2f2;" type="text" name="phone" value="${sc.getPhone()}" /></td>
                                <td><input style="margin-left: 20px;width: 600px;height: 30px;background: #f2f2f2;" type="text" name="gmail" value="${sc.getGmail()}" /></td>
                            </tr>
                        </tbody>
                    </table>

                    <table>
                        <tbody>
                            <tr>
                                <td style="padding-left: 50px; padding-top: 15px;font-weight: bold;">Academic Level</td>
                                <td style="padding-left: 20px; padding-top: 15px;font-weight: bold;">Nation</td>
                                <td style="padding-left: 20px; padding-top: 15px;font-weight: bold;">Religion</td>                        
                            </tr>
                            <tr>
                                <td><input style="width: 300px;margin: 0px 50px;height: 30px;background: #f2f2f2;" type="text" name="academicl" value="${sc.getAcadamicl()}" /></td>
                                <td><input style="width: 250px;margin: 0px 20px;height: 30px;background: #f2f2f2;" type="text" name="nation" value="${sc.getNaion()}"/></td>
                                <td><input style="width: 300px;margin: 0px 20px;height: 30px;background: #f2f2f2;" type="text" name="religion" value="${sc.getReligion()}"/></td>
                            </tr>
                        </tbody>
                    </table>
                    <table>
                        <tbody>

                            <tr>
                                <td></td>
                                <td style="padding-left: 427px; padding-top: 15px;font-weight: bold;">Major</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><select style="margin-left: 427px;width: 607px;height: 34px;background: #f2f2f2;" name="majorid">
                                        <c:forEach var="o" items="${sessionScope.majorid}">
                                            <option value="${o.getMajorid()}">${o.getMajorid()}</option>
                                        </c:forEach>
                                    </select></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td style="padding-left: 427px; padding-top: 15px;font-weight: bold;">Class</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><select style="margin-left: 427px;width: 607px;height: 34px;background: #f2f2f2;" name="classid">
                                        <c:forEach var="o" items="${sessionScope.classid}">
                                            <option value="${o.getClassid()}">${o.getClassid()}</option>
                                        </c:forEach>
                                    </select></td></td>
                            </tr>

                        </tbody>
                    </table>

                    <table>
                        <tbody>
                            <tr> 
                                <td style="padding-left: 50px; padding-top: 15px;font-weight: bold;">Note</td>
                            </tr>
                            <tr> 
                                <td><input style="width: 980px;margin: 0px 50px;height: 200px;background: #f2f2f2;" type="text" name="" value="" /></td>
                            </tr>
                        </tbody>
                    </table>

                    
                    <a style="background-color: red;" href="studentload"> <i class="fa-regular fa-circle-xmark"></i> Cancel</a>

                </form>


            </div> 


        </div>

    </div>   
</div>

</div>


</body>

</html>
