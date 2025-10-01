<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body style="padding: 0; margin: 0">
    <div style="display: flex; flex-direction: row">
        <img style="height: 160px; width: 50%" src="images/1678270264_news-dice.jpg">
        <img style="height: 160px; width: 50%" src="images/4bbfc86af481e5ce674ed3f8df4fb9e0a13edfa6r1-600-397v2_hq.jpg">
    </div>
    <div style="display: flex; justify-content: center; height: 40px; border: 1px solid black; align-items: center;">
        <a href="${pageContext.request.contextPath}/news" target="contentFrame" style="border-right: 1px solid black; margin-right: 10px; width: 140px">Danh sách tin tức</a>
        <a href="${pageContext.request.contextPath}/addNews.jsp" target="contentFrame" style="border-right: 1px solid black; margin-right: 10px; width: 140px">Thêm tin tức mới</a>
        <a href="${pageContext.request.contextPath}/newsManager.jsp" target="contentFrame">Tin tức quản lý</a>
    </div>
    <div style="margin-top: 20px; display: flex; height: 500px">
        <iframe name="contentFrame" style="border: 0; width: 100%"></iframe>
    </div>
    <div style="position: fixed; bottom: 0; width: 100%; display: flex; justify-content: center; height: 40px; border: 1px solid black; align-items: center">
        <label style="font-weight: bold">Nguyễn Huỳnh Thế Bảo - 22690761 - DHKTPM18CTT</label>
    </div>
</body>
</html>