<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/17/2025
  Time: 11:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Cart</title>
</head>
<body>
<div style="display: flex; flex-direction: column; align-items: center">
  <h2 style="color: #b48c14">Your cart</h2>
  <a href="products"><h2>View product</h2></a>
  <table border="1" style="border-collapse: collapse;">
    <tr>
      <th style="padding: 6px">Model Description</th>
      <th style="padding: 6px">Quantity</th>
      <th style="padding: 6px">Unit Price</th>
      <th style="padding: 6px">Total</th>
    </tr>
    <c:if test="${empty sessionScope.cart.getCart()}">
      <tr>
        <td colspan="4">Cart is currently empty -</td>
      </tr>
    </c:if>
    <c:if test="${not empty sessionScope.cart.getCart()}">
      <c:forEach items="${sessionScope.cart.getCart()}" var="cartItem">
        <form action="cart" method="post">
          <tr>
            <td style="border: solid 1px black">${cartItem.product.name}</td>
            <td style="border: solid 1px black; flex-direction: row">
              <input name="quantity" value="${cartItem.quantity}"/>
            <td style="display: flex;justify-content: center;gap: 5px;border: solid 1px black">
              <button type="submit" style="width: 40%;background: red;color: white;padding-top: 5px;padding-bottom: 5px" name="action" value="update"> Update</button>
              <button type="submit" style="width: 40%;background: blue;color: white;padding-top: 5px;padding-bottom: 5px" name="action" value="Delete"> Delete</button>
            </td>
            </td>
            <td style="border: solid 1px black">${cartItem.product.price}</td>
            <td style="border: solid 1px black">${cartItem.totalPrice()}</td>
          </tr>
        </form>
      </c:forEach>
    </c:if>
    <tr>
      <td></td>
      <td></td>
      <td></td>
      <td colspan="2" style="width: 160px">Subtotal: $${cart.totalOrder()}</td>
    </tr>
  </table>
</div>
</body>
</html>
