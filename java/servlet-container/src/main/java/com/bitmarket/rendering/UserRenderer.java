package com.bitmarket.rendering;

import com.bitmarket.model.User;

public class UserRenderer {
    private UserRenderer(){}

    public static String render(User user, String prefix) {
        return LinkRenderer.render(user.getName(), getLinkToUser(user.getId(), prefix));
    }

    private static String getLinkToUser(long id, String prefix) {
        return prefix + "user/showUser.do?userId=" + id;
    }
}
