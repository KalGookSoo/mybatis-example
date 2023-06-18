package com.kalgooksoo.model;

import java.math.BigDecimal;

public class Product extends Timestamped {
    private Long id;
    private Long categoryId;
    private String name;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
