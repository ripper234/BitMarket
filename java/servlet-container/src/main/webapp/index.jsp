<%@ page import="com.bitmarket.model.ModelWithUser" %>
<%@ page import="com.bitmarket.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: rgross
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head><title>BitMarket</title></head>
<body>
	<h1>Welcome to BitMarket</h1>
	<p>Greetings.</p>

    <% ModelWithUser model = ((ModelWithUser)com.bitmarket.model.TmpModelResolverCrap.readModel()); %>

    <% if (model == null || model.user == null) { %>
	<p>Click <a href="login/showProviders.do">here</a> to login with OpenID.
    <p>Until this is actually implemented, just click <a href="login/cheatLogin.do?userId=1">Ron</a> or
    <a href="login/cheatLogin.do?userId=2">Yair</a> to do a cheat-login</p>

    <% } else { %>
    Welcome <%= model.user.getName() %>, you have <%= model.user.getBalance()%> bitcoins.

    <a href="login/showLogoutForm.do">logout</a>
    <% } %>

</body>
</html>
