package com.lc.blog.center.convertor.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lc.blog.center.bo.ArticleBO;
import com.lc.blog.center.convertor.ArticleConvertor;
import com.lc.blog.center.model.ArticleDO;
import com.lc.blog.center.utils.PageUtils;
import com.lc.blog.center.web.article.ArticleCreateRequest;
import com.lc.blog.center.web.request.PageResult;
import com.lc.blog.center.web.vo.ArticleVO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: lucheng
 * @data: 2022/5/4 14:08
 * @version: 1.0
 */
@Service
public class ArticleConvertorImpl implements ArticleConvertor {

    @Override
    public ArticleVO convertDO2VO(ArticleDO articleDO) {
        if (articleDO == null) {
            return null;
        }
        return ArticleVO.builder()
                .id(articleDO.getId())
                .contentTitle(articleDO.getContentTitle())
                .content(articleDO.getContent())
                .contentType(articleDO.getContentType())
                .coverUrl(articleDO.getCoverUrl())
                .clickUrl(articleDO.getClickUrl())
                .contentForm(articleDO.getContentForm())
                .recommend(articleDO.getRecommend())
                .sort(articleDO.getSort())
                .state(articleDO.getState())
                .creatorId(articleDO.getCreatorId())
                .gmtCreate(articleDO.getGmtCreate())
                .gmtModified(articleDO.getGmtModified()).build();
    }

    @Override
    public ArticleBO convertDO2BO(ArticleDO articleDO) {
        if(articleDO == null) {
            return null;
        }
        return ArticleBO.builder()
                .id(articleDO.getId())
                .content(articleDO.getContent())
                .contentForm(articleDO.getContentForm())
                .contentTitle(articleDO.getContentTitle())
                .contentType(articleDO.getContentType())
                .tagId(articleDO.getTagId())
                .coverUrl(articleDO.getCoverUrl())
                .clickUrl(articleDO.getClickUrl())
                .recommend(articleDO.getRecommend())
                .sort(articleDO.getSort())
                .state(articleDO.getState())
                .creatorId(articleDO.getId())
                .gmtCreate(articleDO.getGmtCreate())
                .gmtModified(articleDO.getGmtModified()).build();

    }

    @Override
    public List<ArticleBO> convertDOList2BO(List<ArticleDO> articleDOList) {
        if(CollectionUtils.isEmpty(articleDOList)) {
            return new ArrayList<>();
        }
        List<ArticleBO> boList = articleDOList.stream().map(obj -> this.convertDO2BO(obj)).collect(Collectors.toList());
        return boList;
    }

    public PageResult<ArticleBO> convertDOPage2BO(Page<ArticleDO> articleDOPage) {
        if(articleDOPage.getTotal() == 0) {
            return new PageResult<>(null, 0);
        }
        return new PageResult<>(this.convertDOList2BO(articleDOPage.getRecords()),articleDOPage.getTotal());
    }

    @Override
    public ArticleDO convertBO2DO(ArticleBO articleBO) {
        if(articleBO == null){
            return null;
        }
        return ArticleDO.builder()
                .id(articleBO.getId())
                .creatorId(articleBO.getCreatorId())
                .tagId(articleBO.getTagId())
                .clickUrl(articleBO.getClickUrl())
                .content(articleBO.getContent())
                .contentForm(articleBO.getContentForm())
                .contentTitle(articleBO.getContentTitle())
                .contentType(articleBO.getContentType())
                .creatorIdentity(articleBO.getCreatorIdentity())
                .coverUrl(articleBO.getCoverUrl())
                .recommend(articleBO.getRecommend())
                .sort(articleBO.getSort())
                .state(articleBO.getState())
                .build();
    }

    @Override
    public ArticleVO convertBO2VO(ArticleBO articleBO) {
        if(articleBO == null) {
            return new ArticleVO();
        }
        return ArticleVO.builder()
                .id(articleBO.getId())
                .content(articleBO.getContent())
                .contentType(articleBO.getContentType())
                .contentForm(articleBO.getContentForm())
                .contentTitle(articleBO.getContentTitle())
                .coverUrl(articleBO.getCoverUrl())
                .clickUrl(articleBO.getClickUrl())
                .recommend(articleBO.getRecommend())
                .sort(articleBO.getSort())
                .state(articleBO.getState())
                .creatorId(articleBO.getCreatorId())
                .gmtModified(articleBO.getGmtModified())
                .gmtCreate(articleBO.getGmtCreate()).build();
    }

    @Override
    public List<ArticleVO> convertBOList2VO(List<ArticleBO> boList) {
        if(CollectionUtils.isEmpty(boList)) {
            return new ArrayList<ArticleVO>();
        }
        return boList.stream().map(bo -> this.convertBO2VO(bo)).collect(Collectors.toList());
    }

    @Override
    public PageResult<ArticleVO> convertBOPage2VO(PageResult<ArticleBO> boPageResult) {
        if(PageUtils.isEmpty(boPageResult)) {
            return new PageResult<>(null, 0);
        }

        return new  PageResult(this.convertBOList2VO(boPageResult.getRecordList()),boPageResult.getTotal());
    }

    @Override
    public ArticleDO convertRequest2DO(ArticleCreateRequest articleCreateRequest){
        if(articleCreateRequest == null) {
            return null;
        }
        return ArticleDO.builder()
                .creatorId(articleCreateRequest.getCreatorId())
                .tagId(articleCreateRequest.getTagId())
                .clickUrl(articleCreateRequest.getClickUrl())
                .content(articleCreateRequest.getContent())
                .contentTitle(articleCreateRequest.getTitle())
                .contentType(articleCreateRequest.getContentType())
                .contentForm(articleCreateRequest.getContentForm())
                .coverUrl(articleCreateRequest.getCoverUrl())
                .state(articleCreateRequest.getState())
                .sort(articleCreateRequest.getSort())
                .recommend(articleCreateRequest.getRecommend()).build();
    }
}
