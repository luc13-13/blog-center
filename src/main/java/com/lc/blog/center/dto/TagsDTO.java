package com.lc.blog.center.dto;

import com.luc.framework.core.util.PaginationParams;
import lombok.Builder;
import lombok.Data;

/**
 * @author: lucheng
 * @data: 2022/5/9 13:27
 * @version: 1.0
 */
@Data
@Builder
public class TagsDTO implements PaginationParams {

    private Integer pageSize;
    private Integer pageIndex;
    private Integer total;
}
