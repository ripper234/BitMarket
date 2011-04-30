<%@ page import="com.bitmarket.model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bitmarket.rendering.PriceRenderer" %>
<%--
  Created by IntelliJ IDEA.
  User: rgross
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>BitMarket</title>
    <link rel="stylesheet" target="css/main.css"/>

    <style type="text/css">
        div#header {
            width: 100%;
        }

        div#navbar {
            width: 100%;
            background-color: #fafad2;
            border: solid 1px;
        }

        div#main {
            width: 80%;
            border: solid 1px;
            display: inline;
        }

        div#sidebar {
            width: 20%;
            border: solid 1px;
            background-color: red;
            display: inline;

        }

        .job {
            border: solid 1px;
            height: 10em;
        }
    </style>

</head>
<body>
<div id="header">
    <h1>Welcome to BitMarket</h1>

    <% List<Job> jobs = TmpStaticModel.readModel("jobs");
        User user = TmpStaticModel.readModel("user");
    %>

    <% if (user == null) { %>
    <p>Click <a href="login/showProviders.do">here</a> to login with OpenID.

    <p>Until this is actually implemented, just click <a href="login/cheatLogin.do?userId=1">Ron</a> or
        <a href="login/cheatLogin.do?userId=2">Yair</a> to do a cheat-login</p>

    <% } else { %>
    Welcome <%= user.getName() %>, you have <%= user.getBalance()%> bitcoins.

    <a href="login/showLogoutForm.do">logout</a>
    <% } %>
</div>
<div id="body">
    <div id="navbar">
        <form>
            <button id="sortHighest">Highest</button>
            <button id="sortNewest">Newest</button>
            <button id="sortActivity">Most Activity</button>
        </form>
    </div>
    <div id="main">Main</div>

    <%
        /* todo - color every other line in a different color */

        for (Job job : jobs) { %>
    <div class="job">
        <div class="title"><%= job.getTitle() %></div>
        <div class="price"><%= PriceRenderer.renderPrice(job.getPrice()) %></div>
    </div>
    <% } %>

    <div id="sidebar">Side</div>
</div>
</body>
</html>
