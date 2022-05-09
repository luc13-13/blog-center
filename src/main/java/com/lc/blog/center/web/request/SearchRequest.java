package com.lc.blog.center.web.request;

import com.luc.framework.core.util.PaginationParams;
import com.sun.istack.internal.NotNull;
import lombok.Builder;

/**
 * @author: lucheng
 * @data: 2022/5/4 22:32
 * @version: 1.0
 */
@Builder
public class SearchRequest implements PaginationParams {
    private Integer pageSize;
    private Integer pageIndex;
    private Integer total;

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
