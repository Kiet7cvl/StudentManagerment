<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/template/head_navbar.jsp"/>

<div id="slider">
    <ul class="subnav">
        <li><a href="home.jsp"><i style="margin-right: 10px;" class="fa-solid fa-house"></i>    Home</a></li>
        <li><a href="majorload"><i style="margin-right: 10px;" class="fa-solid fa-landmark"></i>Majors</a></li>
        <li><a href="classload"><i style="margin-right: 10px;" class="fa-solid fa-building"></i>Classes</a></li>
        <li style="background-color: grey;" ><a href="subjectload"><i style="margin-right: 10px;" class="fa-sharp fa-solid fa-book"></i>Subjects</a></li>
        <li><a href="#"><div style="display: inline-block;"><i style="margin-right: 10px;" class="fa-solid fa-graduation-cap"></i>Students Manager</div></a></li>
        <li><a href="teacherload"><div style="display: inline-block;"><i style="margin-right: 10px;" class="fa-solid fa-ruler"></i>Lecturers Manager</div></a></li>
    </ul>

    <div style="background-color: lavender; width: 100%;" class="content_major">
        <div style="margin: 50px; background-color: white; padding: 8px; box-shadow: 5px 0px 10px 2px #888888;" class="box">
            <h3>Create New Subject</h3>

            <div class="major_create">
                <form action="subjectcreate" method="POST">
                    <ul class="major_form_cre" style="list-style: none;">
                        <li><h4>SubjectID</h4></li>
                        <li><input  style="height: 40px; width: 95%;" type="text" name="subjectid" value="" placeholder="Enter subjectID" /></li>
                        
                        <p style="color: red">${error}</p>
                        <li><h4>SubjectName</h4></li>
                        <li><input  style="height: 40px; width: 95%;" type="text" name="subjectname" value="" placeholder="Enter subjectName" /></li>
                        <li><h4>MajorID</h4></li>
                        <select style="height: 46px; width: 95.5%;" name="majorid">
                            <c:forEach var="o" items="${sessionScope.majorid}">
                                <option>${o.getMajorid()}</option>
                            </c:forEach>
                        </select>
                    </ul>

                    <input style="background-color: green" class="major_create_buton" type="submit" name="" value="Create"/>
                    <a style="background-color: red;" href="subjectload"> <i class="fa-regular fa-circle-xmark"></i> Cancel</a>

                </form>


            </div> 


        </div>

    </div>   
</div>

</div>


</body>

</html>
