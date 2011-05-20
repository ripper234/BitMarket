<%@tag description="User" pageEncoding="UTF-8" %>
<%@ attribute name="user" required="true" type="com.bitmarket.model.User" %>

<a href="/user/showUser.do?userId=${user.id}">
    <p>${user.name}</p>
    <img class='avatar' src='${user.avatarUrl}' alt=""/>
</a>