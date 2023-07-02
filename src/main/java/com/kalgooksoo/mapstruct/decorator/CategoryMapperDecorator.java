package com.kalgooksoo.mapstruct.decorator;

import com.kalgooksoo.command.CategoryCommand;
import com.kalgooksoo.mapstruct.CategoryMapper;
import com.kalgooksoo.model.Category;

public class CategoryMapperDecorator implements CategoryMapper {

    /** Mapstruct Mapper delegate instance */
    private final CategoryMapper delegate;

    /**
     * CategoryMapperDecorator 생성자
     *
     * @param delegate Mapstruct Mapper delegate instance
     */
    public CategoryMapperDecorator(CategoryMapper delegate) {
        this.delegate = delegate;
    }

    /**
     * @see CategoryMapper#convert(CategoryCommand)
     */
    @Override
    public Category convert(CategoryCommand categoryCommand) {
        Category category = this.delegate.convert(categoryCommand);
        return category;
    }

    /**
     * @see CategoryMapper#convert(Category)
     */
    @Override
    public CategoryCommand convert(Category category) {
        CategoryCommand command = this.delegate.convert(category);
        return command;
    }

    /**
     * @see CategoryMapper#merge(Category, CategoryCommand)
     */
    @Override
    public Category merge(Category category, CategoryCommand categoryCommand) {
        Category mergedCategory = this.delegate.merge(category, categoryCommand);
        return mergedCategory;
    }
}
