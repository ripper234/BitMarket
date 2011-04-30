<%@ page import="org.springframework.ui.Model" %>
<%@ page import="com.bitmarket.model.TmpModelResolverCrap" %>
<%@ page import="com.bitmarket.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: rgross
  Date: 4/30/11
  Time: 2:47 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>Welcome <%= ((User)com.bitmarket.model.TmpModelResolverCrap.readModel()).getName() %>, you have
<%= ((User)com.bitmarket.model.TmpModelResolverCrap.readModel()).getBalance()%> bitcoins.
</body>
</html>