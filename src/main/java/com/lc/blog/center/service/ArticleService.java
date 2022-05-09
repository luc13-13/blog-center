package com.lc.blog.center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lc.blog.center.bo.ArticleBO;
import com.lc.blog.center.model.ArticleDO;
import com.lc.blog.center.web.article.ArticleCreateRequest;
import com.lc.blog.center.web.request.PageResult;
import com.lc.blog.center.web.vo.ArticleVO;
import com.lc.blog.center.web.vo.ConditionVO;

import java.util.List;

/**
 * (Article)表服务接口
 * @author lucheng
 * @date 2022-04-28 20:55:10
 */
public interface ArticleService extends IService<ArticleDO> {

    /**
     * 查询多条数据
     *
     * @param condition 查询条件
     * @return 对象列表
     */
    PageResult<ArticleBO> getArticleBOListPage(ConditionVO condition);


    boolean createOne(ArticleCreateRequest articleCreateRequest);

    /**
     * 新增数据
     *
     * @param articleVO 实例对象
     * @return 实例对象
     */
    boolean saveOrUpdateOne(ArticleVO articleVO);

    /**
     * 修改数据
     *
     * @param articleBO 实例对象
     * @return 操作记录数目
     */
    int updateArticleDO(ArticleBO articleBO);


    /**
     * 物理删除
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询文章详情，封装成articleVO
     */
    ArticleVO getDetail(Long articleId);
}
