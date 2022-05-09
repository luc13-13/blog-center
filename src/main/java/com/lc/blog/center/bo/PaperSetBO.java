package com.lc.blog.center.bo;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

/**
 * @author: lucheng
 * @data: 2022/4/28 20:01
 * @version: 1.0
 */
@Data
@Builder
public class PaperSetBO {
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

    private Date gmtCreate;

    private Date gmtModified;
}
