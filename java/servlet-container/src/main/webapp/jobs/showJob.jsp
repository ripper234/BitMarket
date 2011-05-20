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
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
    <jsp:attribute name="head">
        <style type="text/css">
                /** Specific to showjob.jsp page !!! */
            button.claim {
                font-weight: bold;
            }
        </style>
    </jsp:attribute>
    <jsp:body>
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
    </jsp:body>
</t:main>