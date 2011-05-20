package com.bitmarket.rendering;

import java.util.Date;

public class DateRenderer {
    private DateRenderer () {}

    public static String render(Date date) {
        // todo - do something here
        // todo - switch to joda time
        return date.toString();
    }

    public static String renderExpiresExpired(Date expiryDate) {
        if (expiryDate.after(new Date()))
            return "expired";
        return "expires";
    }
}
