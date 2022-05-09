package com.lc.blog.center.convertor;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lc.blog.center.bo.ArticleBO;
import com.lc.blog.center.model.ArticleDO;
import com.lc.blog.center.web.article.ArticleCreateRequest;
import com.lc.blog.center.web.request.PageResult;
import com.lc.blog.center.web.vo.ArticleVO;

import java.util.List;

/**
 * @author: lucheng
 * @data: 2022/5/4 14:07
 * @version: 1.0
 */
public interface ArticleConvertor {
    ArticleVO convertDO2VO(ArticleDO articleDO);

    ArticleBO convertDO2BO(ArticleDO articleDO);

    List<ArticleBO> convertDOList2BO(List<ArticleDO> articleDOList);

    PageResult<ArticleBO> convertDOPage2BO(Page<ArticleDO> articleDOPage);

    ArticleDO convertBO2DO(ArticleBO articleBO);

    ArticleVO convertBO2VO(ArticleBO articleBO);

    List<ArticleVO> convertBOList2VO(List<ArticleBO> boList);

    public PageResult<ArticleVO> convertBOPage2VO(PageResult<ArticleBO> boPageResult);

    ArticleDO convertRequest2DO(ArticleCreateRequest articleCreateRequest);
}
