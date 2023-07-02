package com.kalgooksoo.mapstruct;

import com.kalgooksoo.command.CategoryCommand;
import com.kalgooksoo.mapstruct.decorator.CategoryMapperDecorator;
import com.kalgooksoo.model.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(CategoryMapperDecorator.class)
public interface CategoryMapper {

    /**
     * CategoryMapper 인스턴스
     */
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    /**
     * 카테고리 커맨드를 카테고리 엔티티로 변환합니다.
     *
     * @param categoryCommand 카테고리 커맨드
     * @return 카테고리 엔티티
     */
    Category convert(CategoryCommand categoryCommand);

    /**
     * 카테고리 엔티티를 카테고리 커맨드로 변환합니다.
     *
     * @param category 카테고리 엔티티
     * @return 카테고리 커맨드
     */
    CategoryCommand convert(Category category);

    /**
     * 카테고리 엔티티에 카테고리 커맨드를 병합합니다.
     *
     * @param category        카테고리 엔티티
     * @param categoryCommand 카테고리 커맨드
     * @return 카테고리 엔티티
     */
    @Mapping(target = "id", ignore = true)
    Category merge(@MappingTarget Category category, CategoryCommand categoryCommand);

}
