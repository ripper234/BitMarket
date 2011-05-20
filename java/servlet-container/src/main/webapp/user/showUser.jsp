<%@ page import="com.bitmarket.model.User" %>
<%@ page import="com.bitmarket.model.TmpStaticModel" %>
<%@ page import="com.bitmarket.rendering.DateRenderer" %>
<%@ page import="com.bitmarket.model.Job" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bitmarket.rendering.LinkRenderer" %>
<%@ page import="com.bitmarket.rendering.JobRenderer" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Simple jsp page</title>
    <style type="text/css">
        th {
            background-color:#90ee90;
        }
        table {
            border:solid 1px;
        }
        table td {
            border-top:dashed 1px;
            border-top:dashed 1px;
        }
    </style>
</head>
<body>
<% User viewedUser = TmpStaticModel.readModel("viewedUser");
    List<Job> jobs = TmpStaticModel.readModel("viewedUserPostedJobs");
%>
<h1><%= viewedUser.getName() %>
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


    <table>
        <tr>
            <th>Posted</th>
            <th>Expires</th>
            <th>Title</th>
        </tr>
        <% for (Job job : jobs) { %>
        <tr>
            <td><%= DateRenderer.render(job.getPostedDate()) %></td>
            <td><%= DateRenderer.render(job.getExpiryDate()) %></td>
            <td><%= LinkRenderer.render(job.getTitle(), JobRenderer.linkify(job.getId(), "../")) %></td>
        </tr>
        <% } %>
    </table>
    <% } %>
</div>
</body>
</html>