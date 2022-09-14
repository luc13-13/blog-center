package com.lc.blog.center.web.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: lucheng
 * @data: 2022/5/4 14:41
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "查询条件")
public class ConditionVO implements Serializable {

    @ApiModelProperty(name = "userId", value = "用户id", dataType = "Long")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    @ApiModelProperty(name = "current", value = "页码", dataType = "Integer")
    private Integer current;

    @ApiModelProperty(name = "lastId", value = "上一页最后一条数据的id", dataType = "Long",example = "1")
    private Long lastId;

    @ApiModelProperty(name = "size", value = "每页条数", dataType = "Integer")
    private Integer size;

    @ApiModelProperty(name = "keywords", value = "搜索内容", dataType = "String")
    private String keywords;

    @ApiModelProperty(name = "paperSetId", value = "文集id", dataType = "Long",example = "1")
    private Long paperSetId;

    @ApiModelProperty(name = "tagId", value = "标签id", dataType = "Long",example = "1")
    private Long tagId;

    @ApiModelProperty(name = "contentType",value = "类型",dataType = "String")
    private String contentType;

    @ApiModelProperty(name = "contentTitle",value = "标题",dataType = "String")
    private String contentTitle;

    @ApiModelProperty(name = "state", value = "是否删除 0 删除 1 正常",dataType = "Integer")
    private Integer state;

    @ApiModelProperty(name = "startDate", value = "开始时间",dataType = "Date")
    private Date startDate;

    @ApiModelProperty(name = "endDate", value = "结束时间",dataType = "Date")
    private Date endDate;


    @ApiModelProperty(name = "gmtCreate", value = "创建时间",dataType = "Date")
    private Date gmtCreate;

    @ApiModelProperty(name = "gmtModified", value = "最后一次更新时间", dataType = "Date")
    private Date gmtModified;

    @ApiModelProperty(name = "recommend",value = "是否置顶", dataType = "Integer")
    private Integer recommend;
}
