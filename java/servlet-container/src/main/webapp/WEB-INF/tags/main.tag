<%@tag description="Main tag" pageEncoding="UTF-8" %>
<%@attribute name="head" fragment="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" scope="request" class="com.bitmarket.model.User"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <jsp:invoke fragment="head"/>
</head>
<body>
<div id="header">
    <h1>Welcome to BitMarket</h1>

    <c:choose>
        <c:when test="${user == null}">
            <p>Click <a href="/login/showProviders.do">here</a> to login with OpenID.

                Until this is actually implemented, just click <a href="/login/cheatLogin.do?userId=1">Ron</a> or
                <a href="/login/cheatLogin.do?userId=2">Yair</a> to do a cheat-login</p>
        </c:when>
        <c:otherwise>

            Welcome ${user.name}, you have ${user.balance} bitcoins.
            <a href="/login/showLogoutForm.do">logout</a>
        </c:otherwise>
    </c:choose>
</div>
<div id="content">
    <div id="body">
        <jsp:doBody/>
    </div>
    <div id="sidebar">
        <h2>Hot Tags</h2>
        <span class="tag">Stack Overflow</span>
        <span class="tag">Quora</span>
        <span class="tag">Books</span>
        <span class="tag">Tel Aviv</span>
        <span class="tag">Pizza</span>
        <span class="tag">Pizza</span>
        <span class="tag">Pizza</span>
        <span class="tag">Pizza</span>
        <span class="tag">Pizza</span>
        <span class="tag">Quora</span>
    </div>
</div>
<div id="footer">
    Copyright bla bla bla ... footer.
</div>
</body>
</html>