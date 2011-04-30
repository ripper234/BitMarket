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
        h2 {
            font-size: 120%;
        }

        div#header {
            width: 100%;
        }

        div#navbar {
            width: 100%;
            background-color: #fafad2;
            border: solid 1px;
        }

        div#jobs {
            width: 60%;
            border: solid 2px;
        }

        div#sidebar {
            width: 10%;
            border: solid 1px;
            background-color: red;
        }

        .job {
            height: 12em;
        }

        .text {
            border: solid 1px;
            width: 50%;
        }

        .price {
        /*color:#daa520;*/
            color: #ff8c00;
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
    <p>Click <a href="../login/showProviders.do">here</a> to login with OpenID.

        Until this is actually implemented, just click <a href="../login/cheatLogin.do?userId=1">Ron</a> or
        <a href="../login/cheatLogin.do?userId=2">Yair</a> to do a cheat-login</p>

    <% } else { %>
    Welcome <%= user.getName() %>, you have <%= user.getBalance()%> bitcoins.

    <a href="../login/showLogoutForm.do">logout</a>
    <% } %>
</div>
<div id="body">
    <div id="navbar">
        <button id="sortHighest">Highest</button>
        <button id="sortNewest">Newest</button>
        <button id="sortActivity">Most Activity</button>
    </div>
    <div id="main">
        <div id="jobs">
            <%
                /* todo - color every other line in a different color */
                for (Job job : jobs) { %>
            <div class="job">
                <div class="text">
                    <h2><%= job.getTitle() %>
                    </h2>

                    <p><%= job.getBody()%>
                    </p>
                </div>
                <div class="price">Price: <%= PriceRenderer.renderPrice(job.getPrice()) %>
                </div>

                <button class="claim">Claim this job</button>
            </div>
            <% } %>
        </div>
        <div id="sidebar">Side</div>
    </div>
</div>
</body>
</html>
