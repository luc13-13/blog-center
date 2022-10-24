package com.lc.blog.center.web.request;

import com.luc.framework.core.util.PaginationParams;
import com.sun.istack.internal.NotNull;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author: lucheng
 * @data: 2022/5/4 22:32
 * @version: 1.0
 */
@SuperBuilder
public class SearchRequest implements PaginationParams, Serializable {
    public Integer pageSize;
    public Integer pageIndex;
    public Integer total;

    public SearchRequest(Integer pageSize, Integer pageIndex, Integer total) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.total = total;
    }

    @Override
    public Integer getPageIndex() {
        return this.pageIndex;
    }

    @Override
    public void setPageIndex(@NotNull Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public Integer getPageSize() {
        return this.pageSize;
    }

    @Override
    public void setPageSize(@NotNull Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public Integer getRowStart() {
        return PaginationParams.super.getRowStart();
    }

}
