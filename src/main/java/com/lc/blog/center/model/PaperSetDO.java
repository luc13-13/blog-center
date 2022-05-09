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
 * (PaperSet)实体类
 *
 * @author lucheng
 * @since 2022-05-04 13:41:24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("paper_set")
public class PaperSetDO {

         
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /** 标题 */     
    private String setTitle;


    /** 文章数量，删除文集时不删除文章 */     
    private Integer articleCount;


    /** 图片 */     
    private String coverUrl;


    /** 跳转链接 */     
    private String clickUrl;


    /** 置顶状态 0 不置顶 1 置顶 */     
    private Integer recommend;


    /** 排序字段 */     
    private Integer sort;


    /** 是否删除 0 删除 1 正常 */     
    private Integer state;


    /** 创建者身份 system 运营人员 school 学校管理员 */     
    private String creatorIdentity;


    /** 创建者id */     
    private Long creatorId;


    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
