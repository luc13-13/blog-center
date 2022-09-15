package com.lc.blog.center.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.luc.framework.core.util.PaginationParams;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: lucheng
 * @data: 2022/5/9 13:27
 * @version: 1.0
 */
@Data
@Builder
public class TagsDTO implements PaginationParams, Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String tagTitle;
    private Integer pageSize;
    private Integer pageIndex;
    private Integer total;
}
