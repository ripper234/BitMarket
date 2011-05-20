<%@tag description="Main tag" pageEncoding="UTF-8" %>
<%@attribute name="head" fragment="true" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <jsp:invoke fragment="head"/>
</head>
<body>
    <h1>Some large heading</h1>
    <br/>
    <jsp:doBody/>
</body>
</html>