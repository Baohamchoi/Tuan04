<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/17/2025
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
<%--  Thẻ meta dùng để hiển thị trang thông báo success.jsp và đóng sau tgian chỉ định là 2s (content="2, <link trang chuyển tới>")--%>
  <meta http-equiv="refresh" content="2; url=<%=request.getContextPath()%>/views/listUser.jsp">
</head>
<body>
  <div class="alert">
    <%= request.getAttribute("message")%> <br>
<%--    (Sẽ chuyển sang danh sách người dùng (listUser.jsp)...)--%>
  </div>
</body>
</html>
