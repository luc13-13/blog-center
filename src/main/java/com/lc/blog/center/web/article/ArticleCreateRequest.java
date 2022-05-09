package com.lc.blog.center.web.article;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.lc.blog.center.web.request.CreateRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lucheng
 * @data: 2022/5/4 17:32
 * @version: 1.0
 */
@ApiModel
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreateRequest {

    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "标题")
    private String title;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "创建者id")
    private Long creatorId;

    @ApiModelProperty(value = "标签数组id，英文逗号分隔")
    private String tagId;
    @ApiModelProperty(value = "封面url")
    private String coverUrl;
    @ApiModelProperty(value = "跳转url")
    private String clickUrl;

    @ApiModelProperty(value = "类型")
    private String contentType;

    @ApiModelProperty(value = "内容形式 1链接 2手动编辑")
    private Integer contentForm;

    @ApiModelProperty(value = "置顶状态，0不置顶 1置顶")
    private Integer recommend;
    @ApiModelProperty(value = "排序字段")
    private Integer sort;

    /*** 是否删除 0 删除 1 正常 */
    @ApiModelProperty(value = "是否删除 0删除 1正常")
    private Integer state;

}
