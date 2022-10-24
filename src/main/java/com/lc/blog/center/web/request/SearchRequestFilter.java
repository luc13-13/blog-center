package com.lc.blog.center.web.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @Author : Lu Cheng
 * @Date : 2022/9/4 21:47
 * @Version : 1.0
 */
@Data
@SuperBuilder
@ApiModel(description = "查询条件")
public class SearchRequestFilter extends SearchRequest{

    @ApiModelProperty(name = "userId", value = "用户id", dataType = "Long")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    @ApiModelProperty(name = "lastId", value = "上一页最后一条数据的id", dataType = "Long",example = "1")
    private Long lastId;

    @ApiModelProperty(name = "keywords", value = "搜索内容", dataType = "String")
    private String keywords;
    @ApiModelProperty(name = "fuzzyQuery", value = "开启模糊查询 true", dataType = "Boolean")
    private Boolean fuzzyQuery;

    @ApiModelProperty(name = "title",value = "标题",dataType = "String")
    private String title;

    @ApiModelProperty(name = "targetId", value = "目标id", dataType = "Long")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long targetId;

    @ApiModelProperty(name = "type",value = "类型",dataType = "String")
    private String type;

    @ApiModelProperty(name = "state", value = "是否删除 0 删除 1 正常",dataType = "Integer")
    private Integer state;

    private Integer count;

    @ApiModelProperty(name = "startDate", value = "开始时间",dataType = "Date")
    private Date startDate;

    @ApiModelProperty(name = "endDate", value = "结束时间",dataType = "Date")
    private Date endDate;

    @ApiModelProperty(name = "recommend",value = "是否置顶", dataType = "Integer")
    private Integer recommend;

    public SearchRequestFilter(Integer pageSize, Integer pageIndex, Integer total) {
        super(pageSize, pageIndex, total);
    }

}
