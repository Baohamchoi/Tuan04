<%@ page import="iuh.fit.se.nguyenhuynhthebao_22690761.bai01.daos.UserDAO" %>
<%@ page import="iuh.fit.se.nguyenhuynhthebao_22690761.bai01.daos.impl.UserDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.se.nguyenhuynhthebao_22690761.bai01.entities.User" %>
<%@ page import="iuh.fit.se.nguyenhuynhthebao_22690761.bai01.entities.Gender" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/16/2025
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration List</title>
</head>
<body style="justify-content: center; align-items: center">
    <div style="text-align: center">
        <h2>User Registration List</h2>
        <table border="1" style="border-collapse: collapse; width: 100%; text-align: center">
            <thead>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Birthday</th>
                <th>Gender</th>
            </thead>
            <tbody>
                <%
                    UserDAO userDAO = new UserDAOImpl();
                    List<User> users = userDAO.findAll();
                %>
                <%for (User u : users) {%>
                    <tr>
                        <td><%=u.getId()%></td>
                        <td><%=u.getFirstName()%></td>
                        <td><%=u.getLastName()%></td>
                        <td><%=u.getEmail()%></td>
                        <td><%=u.getDob()%></td>
                        <td><%=u.getGender() == Gender.FEMALE ? "Female" : "Male"%></td>
                    </tr>
                <%}%>
            </tbody>
        </table>
    </div>
</body>
</html>
