package com.kalgooksoo.criteria;

public class PageRequest {

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
     * offset
     */
    private int offset = 0;

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getRecordCountPerPage() {
        return recordCountPerPage;
    }

    public void setRecordCountPerPage(int recordCountPerPage) {
        this.recordCountPerPage = recordCountPerPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        this.offset = (this.currentPageNo - 1) * this.getPageSize();
        return this.offset;
    }

}
