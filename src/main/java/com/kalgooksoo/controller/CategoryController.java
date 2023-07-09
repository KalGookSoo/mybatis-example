package com.kalgooksoo.controller;

import com.kalgooksoo.command.CategoryCommand;
import com.kalgooksoo.core.Page;
import com.kalgooksoo.criteria.CategoryCriteria;
import com.kalgooksoo.mapstruct.CategoryMapper;
import com.kalgooksoo.model.Category;
import com.kalgooksoo.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    /**
     * 카테고리 관리 서비스 객체
     */
    private CategoryService categoryService;

    /**
     * 카테고리 데이터 변환 매퍼
     */
    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * 카테고리 초기 페이지
     *
     * @param model    모델
     * @param criteria 검색 및 페이징 조건
     * @return 뷰
     */
    @GetMapping
    public String index(Model model, CategoryCriteria criteria) {
        Page<Category> page = this.categoryService.find(criteria);
        model.addAttribute("page", page);
        return "category/index";
    }

    /**
     * 카테고리 수정 페이지
     *
     * @param model 모델
     * @param id    카테고리 식별자
     * @return 뷰
     */
    @GetMapping("/{id}")
    public String update(Model model, @PathVariable Long id) {

        // TODO 스프링 시큐리티 추가 후 ACL 및 권한 및 그룹 설정에 따라 수정 권한 유무를 파악해 라우팅하도록 한다.

        Category category = this.categoryService.findById(id);
        CategoryCommand command = this.categoryMapper.convert(category);
        model.addAttribute("command", command);
        return "category/update";
    }

    /**
     * 카테고리 생성
     *
     * @param command 커맨드
     * @param result  검증 결과
     * @return 뷰
     */
    @PostMapping
    public String insert(
            @ModelAttribute("command") @Valid CategoryCommand command,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "category/save";
        }

        Category category = this.categoryMapper.convert(command);
        this.categoryService.insert(category);

        return "redirect:/categories";

    }

    /**
     * 카테고리 수정
     *
     * @param command 커맨드
     * @param result  검증 결과
     * @return 뷰
     */
    @PutMapping("/{id}")
    public String update(
            @ModelAttribute("command") @Valid CategoryCommand command,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "category/update";
        }

        Category category = this.categoryMapper.convert(command);
        this.categoryService.update(category);

        return "redirect:/category";

    }

}
