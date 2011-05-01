<%@ page import="com.bitmarket.model.User" %>
<%@ page import="com.bitmarket.model.TmpStaticModel" %>
<%@ page import="com.bitmarket.rendering.DateRenderer" %>
<%@ page import="com.bitmarket.model.Job" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bitmarket.rendering.LinkRenderer" %>
<%@ page import="com.bitmarket.rendering.JobRenderer" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Simple jsp page</title></head>
<body>
<% User viewedUser = TmpStaticModel.readModel("viewedUser");
    List<Job> jobs = TmpStaticModel.readModel("viewedUserPostedJobs");
%>
<h1>User <%= viewedUser.getName() %>
</h1>

<h2>Member since: <%= DateRenderer.render(viewedUser.getRegistrationDate()) %>
</h2>

<h2>Completed transactions: <%= viewedUser.getCompletedTx() %>
</h2>

<div id="posted-jobs">
    <h2>Posted jobs: </h2>
    <% if (jobs.size() == 0) { %>
    This user has no posted jobs
    <% } else { %>

    <% for (Job job : jobs) { %>
    <div class="job-short">
        <p>Posted on <%= job.getPostedDate() %>,
            <%= DateRenderer.renderExpiresExpired(job.getExpiryDate()) %>
            on <%= DateRenderer.render(job.getExpiryDate())%>
        </p>

        <h3><%= LinkRenderer.render(job.getTitle(), JobRenderer.linkify(job.getId(), "../")) %>
        </h3>
    </div>
    <% } %>
    <% } %>
</div>
</body>
</html>