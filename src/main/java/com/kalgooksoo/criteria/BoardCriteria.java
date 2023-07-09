package com.kalgooksoo.criteria;

/**
 * 게시글 조회 조건
 */
public class BoardCriteria extends PageRequest {

    /**
     * 카테고리 식별자
     */
    private Long categoryId;

    /**
     * 검색어
     */
    private String searchTerm;

    /**
     * 카테고리 식별자 접근자
     * 
     * @return 카테고리 식별자
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 카테고리 식별자 설정자
     * 
     * @param categoryId 카테고리 식별자
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 검색어 접근자
     * 
     * @return 검색어
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * 검색어 설정자
     * 
     * @param searchTerm 검색어
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

}
