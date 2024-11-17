<%--
  Created by IntelliJ IDEA.
  User: 23563
  Date: 2024/11/17
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.etl.Entity.MergeMovie"%>
<%@ page import="java.util.List" %>

<html>
<head>
  <title>Title</title>
  <style>
    #scrollingList {
      height: 300px;
      overflow-y: scroll;
      border: 1px solid #000;
      padding: 5px;
    }
  </style>
</head>
<body>
<h2>Scrolling List of Items</h2>
<div id="scrollingList">
  <%
    // 从 request 属性中获取数据
    List<MergeMovie> dataList = (List<MergeMovie>) request.getAttribute("result");
    if (dataList != null) {
      for (MergeMovie item : dataList) {
  %>
  <p><%= item.toString() %></p>
  <%
      }
    }
  %>
</div>

</body>
</html>
