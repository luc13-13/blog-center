package com.lc.blog.center.web.vo;
 
import java.util.Date;
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
public class PaperSetVO {
    
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "id",example = "1")
    private Long id;

    
    @ApiModelProperty(value = "标题")
    private String setTitle;

    
    @ApiModelProperty(value = "文章数量，删除文集时不删除文章")
    private Integer articleCount;

    
    @ApiModelProperty(value = "图片")
    private String coverUrl;

    
    @ApiModelProperty(value = "跳转链接")
    private String clickUrl;

    
    @ApiModelProperty(value = "置顶状态 0 不置顶 1 置顶")
    private Integer recommend;

    
    @ApiModelProperty(value = "排序字段")
    private Integer sort;

    
    @ApiModelProperty(value = "是否删除 0 删除 1 正常")
    private Integer state;

    
    @ApiModelProperty(value = "创建者身份 system 运营人员 school 学校管理员")
    private String creatorIdentity;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "创建者id")
    private Long creatorId;

    
    @ApiModelProperty(value = "${column.comment}")
    private Date gmtCreate;

    
    @ApiModelProperty(value = "${column.comment}")
    private Date gmtModified;


}
