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
  <h2>Enter Year and Month</h2>
  <form action="queryMonth.jsp" method="post">
    <label for="year">Year:</label>
    <select id="year" name="year">
      <% for (int i = 1930; i <= 2024; i++) { %>
      <option value="<%= i %>"><%= i %></option>
      <% } %>
    </select><br><br>

    <label for="month">Month:</label>
    <select id="month" name="month">
      <option value="1">January</option>
      <option value="2">February</option>
      <option value="3">March</option>
      <option value="4">April</option>
      <option value="5">May</option>
      <option value="6">June</option>
      <option value="7">July</option>
      <option value="8">August</option>
      <option value="9">September</option>
      <option value="10">October</option>
      <option value="11">November</option>
      <option value="12">December</option>
    </select><br><br>

    <input type="submit" value="Submit">
  </form>
</head>
<body>

</body>
</html>
