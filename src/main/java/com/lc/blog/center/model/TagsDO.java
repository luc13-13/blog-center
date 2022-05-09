package com.lc.blog.center.model;
 
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
 
/**
 * (Tags)实体类
 *
 * @author lucheng
 * @since 2022-05-04 22:12:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("tags")
public class TagsDO {

         
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /** 标题 */     
    private String tagTitle;


    /** 引用数量 */     
    private Integer referenceCount;


    /** 是否删除 0 删除 1 正常 */     
    private Integer state;


    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
