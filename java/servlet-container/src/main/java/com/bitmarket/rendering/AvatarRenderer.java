package com.bitmarket.rendering;

import com.bitmarket.model.User;

import java.net.URLEncoder;

public class AvatarRenderer{

    public static String render(User user) {


        String anchor = String.format("<img class='avatar' src='%s'/>",
                URLEncoder.encode(
                        user.getAvatarUrl()));
        return LinkRenderer.render(anchor, UserRenderer.getLinkToUser(user.getId(), "../"));
    }
}
