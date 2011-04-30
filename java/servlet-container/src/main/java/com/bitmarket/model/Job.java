package com.bitmarket.model;

import java.math.BigDecimal;

public class Job extends Identifiable{
    private String title;
    private String body;
    private BigDecimal price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null)
            throw new IllegalArgumentException("title");
        int maxLength = 100;
        if (title.length() > maxLength)
            throw new IllegalArgumentException("For now, a title shouldn't be more than " + maxLength + " chars");

        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
