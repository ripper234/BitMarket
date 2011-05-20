<%@tag description="Job Title" pageEncoding="UTF-8" %>
<%@ attribute name="job" required="true" type="com.bitmarket.model.Job" %>

<a href="/jobs/showJob.do?jobId=${job.id}">${job.title}</a>