<%@ page import="org.springframework.ui.Model" %>
<%@ page import="com.bitmarket.model.TmpStaticModel" %>
<%@ page import="com.bitmarket.model.User" %>
<%@ page import="com.bitmarket.model.TmpStaticModel" %>
<%--
  Created by IntelliJ IDEA.
  User: rgross
  Date: 4/30/11
  Time: 2:47 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>Welcome &lt;%= ((User)com.bitmarket.model.TmpStaticModel, you have
&lt;%= ((User)TmpStaticModel.readModel()).getBalance()%&gt; bitcoins.
</body>
</html>