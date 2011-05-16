<%@ page import="com.bitmarket.model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bitmarket.rendering.PriceRenderer" %>
<%@ page import="com.bitmarket.rendering.UserRenderer" %>
<%@ page import="com.bitmarket.rendering.AvatarRenderer" %>
<%@ page import="com.bitmarket.rendering.JobRenderer" %>
<%--
  Created by IntelliJ IDEA.
  User: rgross
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>BitMarket</title>

    <style type="text/css">
        h2 {
            font-size: 120%;
        }

        body {
            width: 80%;
            margin-left: 10%; /* TODO - horizontal align ? */
        }

        .hidden {
            display: none;
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
            float: left;
        }

        div#sidebar {
            width: 30%;
            border: solid 1px;
            float: left;
        }

        .job {
            height: 12em;
            margin: 1em;
            margin-bottom: 1em;
            display: block;
        }

        .job .poster {
            float: left;
            background: red;
            margin: 1em;
            width: 120px;
            display: inline;
        }

        .job .details {
            float: left;
            background: lightgray;
            width: 400px; /* TODO Remove */
            display: inline;
        }

        .job .text {
            border: solid 1px;
            width: 70%;
            padding: 0.5em;
            margin-bottom: 0.5em;
        }

        .job .text p {
        /* TODO - Disable underline */
        }

        .price {
        /*co    lor:#daa520;*/
            color: #ff8c00;
            display: inline;
        }

        img.avatar {
            width: 100px;
            height: 100px;
        }





        /** Specific to showjob.jsp page !!! */
        button.claim {
            font-weight:bold;
        }
    </style>

</head>
<body>
<div id="header">
    <% Job job = TmpStaticModel.readModel("job");
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
        <div id="job">
            <div class="job">
                <p class="poster">
                    <%= UserRenderer.render(job.getPoster(), "../") %>
                    <%= AvatarRenderer.render(job.getPoster()) %>
                </p>

                <div class="details">
                    <div class="text">
                        <h2><%= JobRenderer.render(job.getId(), job.getTitle()) %>
                        </h2>

                        <p><%= JobRenderer.render(job.getId(), job.getBody()) %>
                        </p>
                    </div>
                    <p class="hidden"><%= job.getId()%>
                    </p>

                    <div class="price">Price: <%= PriceRenderer.renderPrice(job.getPrice()) %>
                    </div>
                    <button class="claim">Claim job!</button>
                </div>

            </div>
        </div>
        <div id="sidebar">
            <h2>Hot Tags</h2>
            <span class="tag">Stack Overflow</span>
            <span class="tag">Quora</span>
            <span class="tag">Books</span>
            <span class="tag">Tel Aviv</span>
            <span class="tag">Pizza</span>
        </div>
    </div>
</div>
</body>
</html>
