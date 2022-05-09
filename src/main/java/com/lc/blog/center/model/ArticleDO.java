package com.lc.blog.center.model;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * (Article)实体类
 *
 * @author lucheng
 * @since 2022-04-24 22:52:49
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("article")
public class ArticleDO implements Serializable {

    private static final long serialVersionUID = -32363005648587940L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /*** 类型 */
    private String contentType;

    /*** 标题 */    
    private String contentTitle;

    /*** 内容 */    
    private String content;

    /*** 标签id数组，英文逗号分隔 */    
    private String tagId;

    /*** 图片 */    
    private String coverUrl;

    /*** 跳转链接，暂时同服务器中文章markdown文件存储位置，之后考虑对服务器IP进行加密和解密 */    
    private String clickUrl;

    /*** 内容形式 1链接 2手动编辑 */    
    private Integer contentForm;

    /*** 置顶状态 0 不置顶 1 置顶 */    
    private Integer recommend;

    /*** 排序字段 */    
    private Integer sort;

    /*** 是否删除 0 删除 1 正常 */    
    private Integer state;

    /*** 创建者身份 system 运营人员 school 学校管理员 */    
    private String creatorIdentity;

    /*** 创建者id */    
    private Long creatorId;


    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
