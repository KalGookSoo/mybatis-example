package com.kalgooksoo.model;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
public class Timestamped {

    /**
     * 생성일시
     */
    private LocalDateTime createdAt;

    /**
     * 수정일시
     */
    private LocalDateTime updatedAt;

    /**
     * 삭제일시
     */
    private LocalDateTime deletedAt;

    /**
     * 생성일시 접근자
     *
     * @return 생성일시
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * 생성일시 설정자
     *
     * @param createdAt 생성일시
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 수정일시 접근자
     *
     * @return 수정일시
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 수정일시 설정자
     *
     * @param updatedAt 수정일시
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 삭제일시 접근자
     *
     * @return 삭제일시
     */
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    /**
     * 삭제일시 설정자
     *
     * @param deletedAt 삭제일시
     */
    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
