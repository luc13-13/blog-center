package com.lc.blog.center.web.request;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 分页请求，默认
 * @author: lucheng
 * @data: 2022/4/28 17:32
 * @version: 1.0
 */
@Data
public class PageResult<T> implements Serializable {

    /**
     * 分页列表
     */
    private List<T> recordList;

    private int pageSize;

    private int pageIndex;

    private long totalPage;

    private long total;

    private Long lastId;

    public PageResult(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public PageResult() {

    }

    public PageResult(Long lastId, int pageIndex, int pageSize) {
        this(pageIndex, pageSize);
        this.lastId = lastId;
    }

    public PageResult(List<T> recordList, long total){
        this.recordList = recordList;
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", totalPage=" + totalPage +
                ", total=" + total +
                ", lastId=" + lastId +
                '}';
    }

    public long getTotalPage() {
        return this.pageSize == 0 ? 0 : (this.total + this.pageSize - 1)/this.pageSize;
    }




}
