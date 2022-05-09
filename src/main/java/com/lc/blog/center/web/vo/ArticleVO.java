package com.lc.blog.center.web.vo;
 
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
 
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVO {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    
    @ApiModelProperty(value = "类型",example = "文章")
    private String contentType;

    
    @ApiModelProperty(value = "标题",example = "标题")
    private String contentTitle;

    
    @ApiModelProperty(value = "内容",example = "内容")
    private String content;

    @ApiModelProperty(name = "tagsVOList", value = "文章标签集合",example = "List<>")
    private List<TagsVO> tagsVOList;

//    @ApiModelProperty(name = "commentCount", value = "评论数量")
//    private int commentCount;
//    @ApiModelProperty(name = "likeCount", value = "点赞数量")
//    private int likeCount;

    
    @ApiModelProperty(value = "图片",example = "URL")
    private String coverUrl;

    
    @ApiModelProperty(value = "跳转链接，暂时同服务器中文章markdown文件存储位置，之后考虑对服务器IP进行加密和解密",example = "URL")
    private String clickUrl;

    
    @ApiModelProperty(value = "内容形式 1链接 2手动编辑",example = "2")
    private Integer contentForm;

    
    @ApiModelProperty(value = "置顶状态 0 不置顶 1 置顶",example = "1")
    private Integer recommend;

    
    @ApiModelProperty(value = "排序字段",example = "1")
    private Integer sort;

    
    @ApiModelProperty(value = "是否删除 0 删除 1 正常",example = "1")
    private Integer state;

    
    @ApiModelProperty(value = "创建者身份 system 运营人员 school 学校管理员",example = "无")
    private String creatorIdentity;

    @ApiModelProperty(value = "作者loginName",example = "loginName")
    private String createName;

    @ApiModelProperty(value = "作者头像",example = "url")
    private String userIcon;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "创建者id",example = "123")
    private Long creatorId;

    
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    
    @ApiModelProperty(value = "最后一次更新时间")
    private Date gmtModified;


}
