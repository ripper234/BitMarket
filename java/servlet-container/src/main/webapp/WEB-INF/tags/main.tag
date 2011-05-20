<%@tag description="Main tag" pageEncoding="UTF-8" %>
<%@attribute name="head" fragment="true" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <jsp:invoke fragment="head"/>
</head>
<body>
    <div id="header">
        <h1>Welcome to BitMarket</h1>

        <c:choose>
            <c:when test="${user == null}">
                <p>Click <a href="../login/showProviders.do">here</a> to login with OpenID.

                        Until this is actually implemented, just click <a href="/login/cheatLogin.do?userId=1">Ron</a> or
                        <a href="../login/cheatLogin.do?userId=2">Yair</a> to do a cheat-login</p>
            </c:when>
            <c:otherwise>
                Welcome ${user.Name}, you have ${user.Balance} bitcoins.
                <a href="/login/showLogoutForm.do">logout</a>
            </c:otherwise>
        </c:choose>
    </div>
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
    </div>
</body>
</html>