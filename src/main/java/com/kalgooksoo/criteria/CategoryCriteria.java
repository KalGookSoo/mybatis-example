package com.kalgooksoo.criteria;

import com.kalgooksoo.model.Category;

public class CategoryCriteria extends Criteria<Category> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
