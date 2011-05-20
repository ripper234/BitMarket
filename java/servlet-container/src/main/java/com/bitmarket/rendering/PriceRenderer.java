package com.bitmarket.rendering;

import java.math.BigDecimal;

public class PriceRenderer {
    private PriceRenderer() {}

    public static String renderPrice(BigDecimal price) {
        // to - only render 2 decimal digits
        return price.toString() + " BTC";
    }
}

