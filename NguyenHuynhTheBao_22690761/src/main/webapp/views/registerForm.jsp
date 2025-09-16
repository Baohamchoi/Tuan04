<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - User Registration</title>
</head>
<body style="display:flex; justify-content:center; align-items:center; height:100vh; background:#f2f2f2;">
<form action="<%=request.getContextPath()%>/register" method="get"
      style="display:flex; flex-direction:column; gap:15px;
                 height:auto; width:400px; padding:20px;
                 background:white; border-radius:10px;
                 box-shadow:0 0 10px rgba(0,0,0,0.2);">

    <h3 style="text-align:center; margin-bottom:10px;">User Registration Form</h3>

    <div style="display:flex; gap:10px;">
        <input type="text" name="firstName" placeholder="First Name" style="flex:1; padding:8px;">
        <input type="text" name="lastName" placeholder="Last Name" style="flex:1; padding:8px;">
    </div>

    <input type="text" name="email" placeholder="Your Email" style="padding:8px;">
    <input type="text" name="reEmail" placeholder="Re-enter Email" style="padding:8px;">
    <input type="password" name="password" placeholder="New Password" style="padding:8px;">

    <div>
        <label>Birthday</label><br>
        <select name="month" style="padding:5px;">
            <option value="">Month</option>
            <% for (int i = 1; i <= 12; i++) { %>
            <option value="<%=i%>"><%=i%></option>
            <%}%>
        </select>
        <select name="day" style="padding:5px;">
            <option value="">Day</option>
            <% for (int i = 1; i <= 31; i++) { %>
            <option value="<%=i%>"><%=i%></option>
            <%}%>
        </select>
        <select name="year" style="padding:5px;">
            <option value="">Year</option>
            <% for (int i = 1900; i <= 2025; i++) { %>
            <option value="<%=i%>"><%=i%></option>
            <%}%>
        </select>
    </div>

    <div>
        <label style="margin-right:15px;">
            <input type="radio" value="female" name="gender"> Female
        </label>
        <label>
            <input type="radio" value="male" name="gender"> Male
        </label>
    </div>

    <button type="submit"
            style="background-color:darkblue; border:0; color:white;
                       padding:10px; border-radius:5px; cursor:pointer;">
        Sign up
    </button>
</form>
</body>
</html>
