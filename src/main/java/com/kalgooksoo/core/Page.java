package com.kalgooksoo.core;

import javax.annotation.Nonnull;
import java.util.List;

public class Page<T> {

    /**
     * 레코드(Required)
     */
    @Nonnull
    private final List<T> content;

    /**
     * 총 레코드 개수(Required)
     */
    private final int totalRecordCount;

    /**
     * 현재 페이지 번호(Required)
     */
    private int currentPageNo = 1;

    /**
     * 페이지 당 레코드 개수(Required)
     */
    private int recordCountPerPage = 10;

    /**
     * 출력할 페이지 개수(Required)
     */
    private int pageSize = 10;

    /**
     * 10 건씩 10 페이지씩 출력하기 위한 페이지 생성자
     * 
     * @param content          레코드
     * @param totalRecordCount 총 레코드 개수
     */
    public Page(List<T> content, int totalRecordCount) {
        this.content = content;
        this.totalRecordCount = totalRecordCount;
    }

    /**
     * n 건씩 n 페이지씩 출력하기 위한 페이지 생성자
     * 
     * @param content            레코드
     * @param totalRecordCount   총 레코드 개수
     * @param currentPageNo      현재 페이지 번호
     * @param recordCountPerPage 페이지 당 레코드 개수
     * @param pageSize           출력할 페이지 개수
     */
    public Page(List<T> content, int totalRecordCount, int currentPageNo, int recordCountPerPage, int pageSize) {
        this.content = content;
        this.totalRecordCount = totalRecordCount;
        this.currentPageNo = currentPageNo;
        this.recordCountPerPage = recordCountPerPage;
        this.pageSize = pageSize;
    }

    /**
     * 총 페이지 개수
     */
    private int totalPageCount;

    /**
     * 페이지 리스트의 첫 페이지 번호
     */
    private int firstPageNoOnPageList;

    /**
     * 페이지 리스트의 마지막 페이지 번호
     */
    private int lastPageNoOnPageList;

    /**
     * 페이징 SQL의 조건절에 사용되는 시작 요소 번호
     */
    private int firstRecordIndex;

    /**
     * 페이징 SQL의 조건절에 사용되는 마지막 요소 번호
     */
    private int lastRecordIndex;

    /**
     * 레코드 접근자
     *
     * @return 레코드
     */
    @Nonnull
    public List<T> getContent() {
        return content;
    }

    /**
     * 총 레코드 개수 접근자
     *
     * @return 총 레코드 개수
     */
    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    /**
     * 현재 페이지 번호 접근자
     *
     * @return 현재 페이지 번호
     */
    public int getCurrentPageNo() {
        return currentPageNo;
    }

    /**
     * 페이지 당 레코드 개수 접근자
     *
     * @return 페이지 당 레코드 개수
     */
    public int getRecordCountPerPage() {
        return recordCountPerPage;
    }

    /**
     * 출력할 페이지 개수 접근자
     *
     * @return 출력할 페이지 개수
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 총 페이지 개수를 반환합니다.
     * (총 레코드 개수 - 1) / 페이지 당 레코드 개수
     *
     * @return 총 페이지 개수
     */
    public int getTotalPageCount() {
        this.totalPageCount = ((this.getTotalRecordCount() - 1) / this.getRecordCountPerPage()) + 1;
        return this.totalPageCount;
    }

    /**
     * 첫 페이지 번호를 반환합니다.
     *
     * @return 1
     */
    public int getFirstPageNo() {
        return 1;
    }

    /**
     * 마지막 페이지 번호를 반환합니다.
     *
     * @return 총 페이지 개수
     */
    public int getLastPageNo() {
        return this.getTotalPageCount();
    }

    /**
     * 현재 페이지 리스트의 첫 번째 페이지를 반환합니다.
     *
     * @return 페이지 리스트의 첫 페이지 번호
     */
    public int getFirstPageNoOnPageList() {
        this.firstPageNoOnPageList = ((this.getCurrentPageNo() - 1) / this.getPageSize()) * this.getPageSize() + 1;
        return this.firstPageNoOnPageList;
    }

    /**
     * 이전 페이지 리스트의 마지막 페이지를 반환합니다.
     * 첫 페이지와 비교하여 최댓값을 반환합니다.
     * 
     * @return 이전 페이지 리스트의 마지막 페이지 번호
     */
    public int getPreviousPageList() {
        return Math.max(this.getFirstPageNoOnPageList() - 1, this.getFirstPageNo());
    }

    /**
     * 현재 페이지 리스트의 마지막 페이지를 반환합니다.
     * 만약 총 페이지 개수보다 초과할 경우 총 페이지 개수를 반환합니다.
     *
     * @return 페이지 리스트의 마지막 페이지 번호
     */
    public int getLastPageNoOnPageList() {
        this.lastPageNoOnPageList = this.getFirstPageNoOnPageList() + this.getPageSize() - 1;
        if (this.lastPageNoOnPageList > this.getTotalPageCount()) {
            this.lastPageNoOnPageList = this.getTotalPageCount();
        }
        return this.lastPageNoOnPageList;
    }

    /**
     * 다음 페이지 리스트의 첫 페이지를 반환합니다.
     * 마지막 페이지와 비교하여 최솟값을 반환합니다.
     * 
     * @return 다음 페이지 리스트의 첫 페이지 번호
     */
    public int getNextPageList() {
        return Math.min(this.getLastPageNoOnPageList() + 1, this.getLastPageNo());
    }

    /**
     * 페이징 SQL의 조건절에 사용되는 시작 요소 번호를 반환합니다.
     * (현재 페이지 번호 - 1) * 페이지 당 레코드 개수
     *
     * @return 페이징 SQL의 조건절에 사용되는 시작 요소 번호
     */
    public int getFirstRecordIndex() {
        this.firstRecordIndex = (this.getCurrentPageNo() - 1) * this.getRecordCountPerPage();
        return this.firstRecordIndex;
    }

    /**
     * 페이징 SQL의 조건절에 사용되는 마지막 요소 번호를 반환합니다.
     * 현재 페이지 번호 * 페이지 당 레코드 개수
     *
     * @return 페이징 SQL의 조건절에 사용되는 마지막 요소 번호
     */
    public int getLastRecordIndex() {
        this.lastRecordIndex = this.getCurrentPageNo() * this.getRecordCountPerPage();
        return this.lastRecordIndex;
    }

}
