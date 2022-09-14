package com.lc.blog.center.dto;

import com.luc.framework.core.util.PaginationParams;
import lombok.Builder;
import lombok.Data;

/**
 * @Author : Lu Cheng
 * @Date : 2022/9/4 22:30
 * @Version : 1.0
 */
@Data
@Builder
public class PaperSetDTO implements PaginationParams {

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

    private Integer pageSize;
    private Integer pageIndex;
    private Integer total;
}
