<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/26/2025
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List news</title>
</head>
<body>
    <div style="display: flex; flex-wrap: wrap; justify-content: center">
        <c:forEach var="t" items="${tintucList}">
                <div style="border:1px solid #ccc; margin:10px; padding:10px; width:300px; height:200px;">
                    <h5>${t.tieuDe}</h5>
                    <p>${t.noiDungTT}</p>
                    <p>Ngày đăng: ${t.ngayDang}</p>
                </div>
        </c:forEach>
    </div>
</body>
</html>
