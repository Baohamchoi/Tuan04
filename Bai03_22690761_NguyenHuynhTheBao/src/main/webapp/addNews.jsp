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
    <title>Add news</title>
</head>
<body>
    <div style="display: flex; flex-direction: column; align-items: center">
        <form action="${pageContext.request.contextPath}/add-new" method="get" style="display: flex; flex-direction: column; border: 1px solid black; height: 300px; width: 300px; padding-left: 10px">
            <div style="display: flex; justify-content: center">
                <h2 style="margin-top: 10px;">Thêm tin tức mới</h2>
            </div>
            <div style="flex-direction: column; margin-top: 10px;">
                <h4 style="margin: 0px;">Tiêu đề</h4>
                <input style="width: 280px" type="text" name="tieuDe" value="" placeholder="Nhập tiêu đề...">
            </div>
            <div style="flex-direction: column; margin-top: 10px">
                <h4 style="margin: 0px">Nội dung</h4>
                <input style="width: 280px" type="text" name="noiDung" value="" placeholder="Nhập nội dung...">
            </div>
            <div style="flex-direction: column; margin-top: 10px">
                <h4 style="margin: 0px">Chọn danh mục bài viết</h4>
                <select style="width: 280px" name="danhMuc" id="danhMuc">
                    <option value="Công nghệ">Công nghệ</option>
                    <option value="Thể thao">Thể thao</option>
                    <option value="Giáo dục">Giáo dục</option>
                    <option value="Giải trí">Giải trí</option>
                    <option value="Kinh tế">Kinh tế</option>
                </select>
            </div>
            <div style="display: flex; justify-content: center">
                <button style="display: flex; align-items: center; margin-top: 20px; height: 40px; width: 200px;
                    justify-content: center; background-color: green; color: white;
                    font-weight: bold" type="submit">Thêm tin tức</button>
            </div>
        </form>
    </div>
</body>
</html>
