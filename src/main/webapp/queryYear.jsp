<%--
  Created by IntelliJ IDEA.
  User: 23563
  Date: 2024/11/17
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Enter Year and Month</h2>
<form action="queryYear.jsp" method="post">
    <label for="year">Year:</label>
    <select id="year" name="year">
        <% for (int i = 1930; i <= 2024; i++) { %>
        <option value="<%= i %>"><%= i %></option>
        <% } %>
    </select><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
