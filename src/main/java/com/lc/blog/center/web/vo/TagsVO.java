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
public class TagsVO {
    
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    
    @ApiModelProperty(value = "标题")
    private String tagTitle;

    
    @ApiModelProperty(value = "引用数量")
    private Integer referenceCount;

    
    @ApiModelProperty(value = "是否删除 0 删除 1 正常")
    private Integer state;

    
    @ApiModelProperty(value = "${column.comment}")
    private Date gmtCreate;

    
    @ApiModelProperty(value = "${column.comment}")
    private Date gmtModified;


}
