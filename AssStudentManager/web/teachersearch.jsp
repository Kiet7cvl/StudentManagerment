<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/template/head_navbar.jsp"/>

<div id="slider">
    <ul class="subnav">
        <li><a href="home.jsp"><i style="margin-right: 10px;" class="fa-solid fa-house"></i>    Home</a></li>
        <li><a href="majorload"><i style="margin-right: 10px;" class="fa-solid fa-landmark"></i>Majors</a></li>
        <li><a href="classload"><i style="margin-right: 10px;" class="fa-solid fa-building"></i>Classes</a></li>
        <li><a href="subjectload"><i style="margin-right: 10px;" class="fa-sharp fa-solid fa-book"></i>Subjects</a></li>
        <li><a href="#"><div style="display: inline-block;"><i style="margin-right: 10px;" class="fa-solid fa-graduation-cap"></i>Students Manager</div></a></li>
        <li style="background-color: grey;" ><a href="teacherload"><div style="display: inline-block;"><i style="margin-right: 10px;" class="fa-solid fa-ruler"></i>Lecturers Manager</div></a></li>
    </ul>

    <div style="background-color: lavender; width: 100%;" class="content_major">
        <div style="margin: 50px; background-color: white; padding: 8px; box-shadow: 5px 0px 10px 2px #888888;" class="box">

            <div class="major_cre" style="display: flex; justify-content: space-between">
                <h2>Teachers List</h2> 
                <c:if test="${sessionScope.user.isAdmin == 1}">
                <a style="  text-decoration: none; border: 1px solid black; background-color: green; color: white; padding: 12px;
                   margin-bottom: 25px; border-radius: 4px;" href="teachercreate.jsp"> <i class="fa-solid fa-circle-plus"></i> CREATE</a>
                   </c:if>
            </div>

            <form action="teachersearch" method="POST">
                <div style="margin-bottom: 30px; display: flex;">
                    <input style="height: 30px; width: 400px;" type="text" name="teacheridname" value="${teachername}" placeholder="Enter Teacher want to find"/>
                    <input style="margin: 0px 4px; width: 100px; background-color: #00bcd4; color: white; border: 1px solid black" type="submit" value="SEARCH" />
                    <select style="margin-right: 4px;" name="subjectid" value="">
                    <option value="">SubjectID</option>
                    <c:forEach var="o" items="${sessionScope.subjectid}">
                        <option value="${o.getSubjectid()}">${o.getSubjectid()}</option>
                            </c:forEach>
                    </select> 
                    <select name="classid" value="">
                    <option value="">ClassID</option>
                    <c:forEach var="o" items="${sessionScope.classid}">
                        <option value="${o.getClassid()}">${o.getClassid()}</option>
                            </c:forEach>
                    </select> 
                </div>
                
            </form>

            <div >
                <table style=" line-height: 1.7;" >
                    <hr/>
                    <thead>

                        <tr>
                            <th style="padding-right: 40px;" >STT</th>
                            <th style="padding-right: 60px;">TeacherID</th>
                            <th style="padding-right: 100px;">TeacherName</th>
                            <th style="padding-right: 100px;">Phone</th>
                            <th style="padding-right: 50px;">Literacy</th>
                            <th style="padding-right: 50px;">Nationality</th>
                            <th style="padding-right: 50px;">SubjectID</th>
                            <th style="padding-right: 50px;">ClassID</th>
                            <th >Operation</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${teacherlist}" var="op">
                            <tr>

                                <td>${op.getStt()}</td>       
                                <td>${op.getTeacherid()}</td>
                                <td>${op.getTeachername()}</td>  
                                <td>${op.getPhone()}</td> 
                                <td>${op.getLiteracy()}</td> 
                                <td>${op.getNationality()}</td> 
                                <td>${op.getSubjectid()}</td> 
                                <td>${op.getClassid()}</td> 
                                <td>
                                    <c:if test="${sessionScope.user.isAdmin == 1}">
                                        <a href="teacherupdate?sid=${op.getTeacherid()}"><i class="fa-sharp fa-regular fa-pen-to-square"></i></a>
<!--                                    <a href="#" onclick="Mess(${op.getTeacherid()})">DELETE</a>-->
                                    <a style="margin-left: 10px;" href="teachercreate?sid=${op.getTeacherid()}"><i class="fa-sharp fa-solid fa-trash"></i></a>
                                    </c:if>
                                    
                                </td>
                                </div>

                            </tr>
                            

                        </c:forEach>


                    </tbody>

                </table>   
            </div>

        </div>

    </div>   
</div>

<div id="footer">

</div>

</div>

</body>

</html>
