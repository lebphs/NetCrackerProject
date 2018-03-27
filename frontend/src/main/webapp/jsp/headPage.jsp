<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 25.03.2018
  Time: 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Head of practice page</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th >Check</th>
        <th scope="col">L.Name</th>
        <th scope="col">F.Name</th>
        <th scope="col">Faculty</th>
        <th scope="col">Specialty</th>
        <th scope="col">Group</th>
        <th scope="col">Is budget</th>
        <th scope="col">Average score</th>
        <th scope="col">Status</th>
        <th scope="col">Name of company</th>
        <th scope="col">Practic period</th>
        <th scope="col">Btn "Show info"</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">
            <input type="checkbox" class="form-check-input" id="checkBox1">
        </th>
        <th>
            <input type="button" value="Info" onClick='location.href="aboutStudent.jsp"'/>
        </th>
    </tr>
    <tr>
        <th scope="row">
            <input type="checkbox" class="form-check-input" id="checkBox2">
        </th>
    </tr>
    <tr>
        <th scope="row">
            <input type="checkbox" class="form-check-input" id="checkBox3">
        </th>
    </tr>
    </tbody>
</table>

</body>
</html>
