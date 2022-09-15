package com.lc.blog.center.convertor.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lc.blog.center.bo.PaperSetBO;
import com.lc.blog.center.convertor.PaperSetConvertor;
import com.lc.blog.center.dto.PaperSetDTO;
import com.lc.blog.center.model.PaperSetDO;
import com.lc.blog.center.web.request.PageResult;
import com.lc.blog.center.web.vo.ConditionVO;
import com.lc.blog.center.web.vo.PaperSetVO;
import lombok.NonNull;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Lu Cheng
 * @Date : 2022/9/4 22:35
 * @Version : 1.0
 */
@Service
public class PaperSetConvertorImpl implements PaperSetConvertor {
    @Override
    public PaperSetDO convertBO2DO(@NonNull PaperSetBO paperSetBO) {

        return PaperSetDO.builder()
                .id(paperSetBO.getId())
                .setTitle(paperSetBO.getSetTitle())
                .build();
    }

    @Override
    public Page<PaperSetDO> convertBO2DOPage(Page<PaperSetBO> boPage) {
        return null;
    }

    @Override
    public PageResult<PaperSetBO> convertDO2BOPage(Page<PaperSetDO> doPage) {
        if(doPage == null) {
            return new PageResult<>();
        }
        return new PageResult<>(this.convertDO2BOList(doPage.getRecords()), doPage.getTotal());
    }

    @Override
    public PaperSetBO convertDO2BO(PaperSetDO paperSetDO) {
        if(ObjectUtils.isEmpty(paperSetDO)) {
            return PaperSetBO.builder().build();
        }
        return PaperSetBO.builder()
                .id(paperSetDO.getId())
                .setTitle(paperSetDO.getSetTitle())
                .creatorId(paperSetDO.getCreatorId())
                .creatorIdentity(paperSetDO.getCreatorIdentity())
                .sort(paperSetDO.getSort())
                .state(paperSetDO.getState())
                .recommend(paperSetDO.getRecommend())
                .coverUrl(paperSetDO.getCoverUrl())
                .clickUrl(paperSetDO.getClickUrl())
                .articleCount(paperSetDO.getArticleCount())
                .gmtCreate(paperSetDO.getGmtCreate())
                .gmtModified(paperSetDO.getGmtModified()).build();
    }

    @Override
    public List<PaperSetDO> convertBO2DOList(Page<PaperSetBO> doList) {

        return null;
    }

    @Override
    public List<PaperSetBO> convertDO2BOList(List<PaperSetDO> doList) {
        if(CollectionUtils.isEmpty(doList)) {
            return new ArrayList<>();
        }
        return doList.stream().map(o -> this.convertDO2BO(o)).collect(Collectors.toList());
    }

    @Override
    public PaperSetDO convertDTO2DO(PaperSetDTO paperSetDTO) {
        if (paperSetDTO == null) {
            return new PaperSetDO();
        }
        return PaperSetDO.builder()
                .id(paperSetDTO.getId())
                .setTitle(paperSetDTO.getSetTitle())
                .creatorId(paperSetDTO.getCreatorId())
                .recommend(paperSetDTO.getRecommend())
                .clickUrl(paperSetDTO.getClickUrl())
                .coverUrl(paperSetDTO.getCoverUrl())
                .creatorIdentity(paperSetDTO.getCreatorIdentity())
                .sort(paperSetDTO.getSort())
                .articleCount(paperSetDTO.getArticleCount())
                .build();
    }

    @Override
    public PaperSetVO convertBO2VO(PaperSetBO bo) {
        if(bo == null) {
            return PaperSetVO.builder().build();
        }
        return PaperSetVO.builder()
                .id(bo.getId())
                .clickUrl(bo.getClickUrl())
                .coverUrl(bo.getCoverUrl())
                .setTitle(bo.getSetTitle())
                .gmtCreate(bo.getGmtCreate())
                .sort(bo.getSort())
                .articleCount(bo.getArticleCount())
                .recommend(bo.getRecommend())
                .creatorId(bo.getCreatorId())
                .build();
    }

    public List<PaperSetVO> convertBO2VOList(List<PaperSetBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return new ArrayList<>();
        }
        return boList.stream().map(o -> this.convertBO2VO(o)).collect(Collectors.toList());
    }

    @Override
    public PageResult<PaperSetVO> convertBO2VOPage(PageResult<PaperSetBO> boPageResult) {
        if (boPageResult == null) {
             return new PageResult<>();
        }
        return new PageResult<PaperSetVO>(this.convertBO2VOList(boPageResult.getRecordList()), boPageResult.getTotal());
    }

    @Override
    public PaperSetDO convertCondition2DO(ConditionVO conditionVO) {
        if (conditionVO == null) {
            return new PaperSetDO();
        }
        return PaperSetDO.builder()
                .id(conditionVO.getPaperSetId())
                .setTitle(conditionVO.getFuzzyQuery() ? null: conditionVO.getContentTitle())
                .creatorId(conditionVO.getUserId())
                .state(conditionVO.getState())
                .recommend(conditionVO.getRecommend()).build();
    }
}
