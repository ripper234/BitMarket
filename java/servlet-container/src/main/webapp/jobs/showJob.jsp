<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="job" scope="request" type="com.bitmarket.model.Job"/>

<t:main>
    <jsp:attribute name="head">
        <style type="text/css">
            button.claim {
                font-weight: bold;
            }
        </style>
    </jsp:attribute>
    <jsp:body>

        <div id="job">
                <div class="poster">
                   <t:user user="${job.poster}"/>
                </div>

                <div class="details">
                    <div class="text">
                        <h2>
                            <t:jobTitle job="${job}"/>
                        </h2>
                        <p>${job.body}</p>
                    </div>
                    <p class="hidden">${job.id}</p>
                    <div class="price">Price: ${job.price} BTC</div>
                    <button class="claim">Claim job!</button>
                </div>
        </div>
    </jsp:body>
</t:main>