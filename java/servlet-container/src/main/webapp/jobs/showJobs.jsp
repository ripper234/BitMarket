<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:main>
    <div id="header">
        <h1>Welcome to BitMarket</h1>

        <c:choose>
            <c:when test="${user == null}">
                <p>Click <a href="../login/showProviders.do">here</a> to login with OpenID.

                        Until this is actually implemented, just click <a href="../login/cheatLogin.do?userId=1">Ron</a> or
                        <a href="../login/cheatLogin.do?userId=2">Yair</a> to do a cheat-login</p>
            </c:when>
            <c:otherwise>
                Welcome ${user.Name}, you have ${user.Balance} bitcoins.
                <a href="../login/showLogoutForm.do">logout</a>
            </c:otherwise>
        </c:choose>
    </div>

    <div id="body">
        <div id="navbar">
            <button id="sortHighest">Highest</button>
            <button id="sortNewest">Newest</button>
            <button id="sortActivity">Most Activity</button>
        </div>
        <div id="main">
            <div id="jobs">
                <c:forEach var="job" items="${jobs}">
                    <%-- todo - color every other line in a different color --%>
                <div class="job">
                    <p class="poster">
                        <!-- TODO reuse - http://stackoverflow.com/questions/6071614/how-can-i-reuse-code-in-jslt-el -->
                        <a href="../user/showUser.do?userId=${job.poster.id}">
                            ${job.poster.name}
                            <img class='avatar' src='${job.poster.avatarUrl}' alt=""/>
                        </a>
                    </p>

                    <div class="details">
                        <div class="text">
                            <a href="../jobs/showJob?jobId=${job.id}">
                                <h2>${job.title}</h2>
                                <p>${job.body}</p>
                            </a>
                        </div>
                        <div class="price">
                            Price: ${job.price} BTC
                        </div>
                    </div>

                </div>
                </c:forEach>
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
</t:main>