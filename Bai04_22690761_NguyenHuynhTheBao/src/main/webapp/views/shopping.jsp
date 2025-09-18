<%@ page import="iuh.fit.se.bai04_22690761_nguyenhuynhthebao.entities.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product catalog</title>
</head>
<body>
<!-- Link sang cart -->
<a href="${pageContext.request.contextPath}/views/cart.jsp"><h2>View cart</h2></a>

<div style="display: flex; flex-direction: column; align-items: center">
    <h1>Product Catalog</h1>
    <div style="display: grid; grid-template-columns: repeat(3,1fr); gap: 20px">
        <c:forEach var="p" items="${products}">
            <div style="display: flex; flex-direction: column; height: auto; width: 180px;
                    row-gap: 8px; border: 1px solid black; border-radius: 4px; align-items: center; justify-content: space-between">

                <h4>${p.name}</h4>
                <img src="image?id=${p.id}" style="width: 100px; height: 100px">
                <label>Price: ${p.price}</label>

                <!-- Form add to cart -->
                <form action="${pageContext.request.contextPath}/cart" method="post" style="margin: 0; display: flex; flex-direction: column; align-items: center; gap: 5px">
                    <input type="hidden" name="id" value="${p.id}"/>
                    <input type="number" name="quantity" value="1" min="1"
                           style="height: 20px; width: 40px; text-align: center"/>
                    <button type="submit" name="action" value="add"
                            style="width: 100px; margin-bottom: 10px; background-color: green; color: white">
                        Add to cart
                    </button>
                </form>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
