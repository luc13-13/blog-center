package com.lc.blog.center.web.article;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lc.blog.center.bo.ArticleBO;
import com.lc.blog.center.convertor.ArticleConvertor;
import com.lc.blog.center.model.ArticleDO;
import com.lc.blog.center.model.TagsDO;
import com.lc.blog.center.service.ArticleService;
import com.lc.blog.center.service.TagsService;
import com.lc.blog.center.utils.LucStringUtils;
import com.lc.blog.center.web.request.PageResult;
import com.lc.blog.center.web.vo.ArticleVO;
import com.lc.blog.center.web.vo.ConditionVO;
import com.luc.framework.core.mvc.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lucheng
 * @data: 2022/4/28 20:02
 * @version: 1.0
 */
@Api(tags = "文章操作模块-访客模式")
@RestController
@RequestMapping("/visit/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleConvertor articleConvertor;

    @ApiOperation("根据id查看文章详情")
    @ApiImplicitParam(name = "articleId",value = "文章主键id",required = true, dataType = "Long")
    @GetMapping("/detail/{articleId}")
    public WebResult<ArticleVO> getArticleDetail(@PathVariable("articleId") Long articleId) {
        // 封装标签
        ArticleVO vo = articleService.getDetail(articleId);
        return WebResult.successData(vo);
    }

    @ApiOperation("首页置顶文章")
    @GetMapping("/visit/recommend")
    public WebResult<PageResult<ArticleVO>> getArticlePageList(@ApiParam(value = "作者id",required = false) Long userId,
                                                         @ApiParam(value = "查询参数",required = true) ConditionVO conditionVO) {
        if(userId != null) {

        }
        // 暂时不考虑用户注册模式，只查询admin文章
        PageResult<ArticleBO> boPageResult = articleService.getArticleBOListPage(conditionVO);
        PageResult<ArticleVO> voPageResult = articleConvertor.convertBOPage2VO(boPageResult);

        //封装作者头像和loginName

        return WebResult.successData(voPageResult);
    }



}
