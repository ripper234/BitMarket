<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:main>
    <jsp:attribute name="head">
        <link rel="stylesheet" type="text/css" href="/css/jobs.css"/>
    </jsp:attribute>
    <jsp:body>
        <div id="sortBar">
            <button id="sortHighest">Highest</button>
            <button id="sortNewest">Newest</button>
            <button id="sortActivity">Most Activity</button>
        </div>
        <div id="jobs">
                <c:forEach var="job" items="${jobs}">
                    <%-- todo - color every other line in a different color --%>
                    <div class="job">
                        <div class="poster">
                            <t:user user="${job.poster}"/>
                        </div>

                        <div class="details">
                            <div class="text">
                                <h3>
                                    <t:jobTitle job="${job}"/>
                                </h3>

                                <p>${job.body}</p>
                            </div>
                            <div class="price">
                                Price: ${job.price} BTC
                            </div>
                        </div>

                    </div>
                </c:forEach>
            </div>
    </jsp:body>
</t:main>