package com.lc.blog.center.convertor.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lc.blog.center.bo.TagsBO;
import com.lc.blog.center.convertor.TagsConvertor;
import com.lc.blog.center.dto.TagsDTO;
import com.lc.blog.center.model.TagsDO;
import com.lc.blog.center.web.vo.TagsVO;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * @author: lucheng
 * @data: 2022/5/4 22:37
 * @version: 1.0
 */
@Service
public class TagsConvertorImpl implements TagsConvertor {

    @Override
    public TagsVO convertBO2VO(TagsBO tagsBO) {
        if(tagsBO == null) {
            return null;
        }
        return TagsVO.builder()
                .id(tagsBO.getId())
                .tagTitle(tagsBO.getTagTitle())
                .state(tagsBO.getState())
                .referenceCount(tagsBO.getReferenceCount()).build();
    }

    @Override
    public Page<TagsVO> convertBO2VOPage(Page<TagsBO> tagsBOPage) {
        if(tagsBOPage == null || CollectionUtils.isEmpty(tagsBOPage.getRecords())) {
            return null;
        }
        Page<TagsVO> voPage = new Page<>(tagsBOPage.getCurrent(), tagsBOPage.getSize(), tagsBOPage.getTotal());
        voPage.setRecords(tagsBOPage.getRecords().stream().map(o -> convertBO2VO(o)).collect(Collectors.toList()));
        return voPage;
    }

    @Override
    public TagsDO convertBO2DO(TagsBO bo) {
        if(bo == null) {
            return null;
        }
        return TagsDO.builder()
                .id(bo.getId())
                .tagTitle(bo.getTagTitle())
                .referenceCount(bo.getReferenceCount())
                .state(bo.getState()).build();

    }

    @Override
    public List<TagsDO> convertBO2DOList(List<TagsBO> boList) {
        if(CollectionUtils.isEmpty(boList)) {
            return null;
        }
        return boList.stream().map(this::convertBO2DO).collect(Collectors.toList());
    }

    @Override
    public TagsBO convertDO2BO(TagsDO tagsDO) {
        if(tagsDO == null) {
            return null;
        }
        return TagsBO.builder()
                .id(tagsDO.getId())
                .state(tagsDO.getState())
                .referenceCount(tagsDO.getReferenceCount())
                .tagTitle(tagsDO.getTagTitle()).build();
    }

    @Override
    public Page<TagsBO> convertDO2BOPage(Page<TagsDO> doPage) {
        if (doPage == null || CollectionUtils.isEmpty(doPage.getRecords())) {
            return null;
        }
        Page<TagsBO> page = new Page<>(doPage.getCurrent(), doPage.getSize(), doPage.getTotal());
        page.setRecords(doPage.getRecords().stream().map(this::convertDO2BO).collect(Collectors.toList()));
        return page;
    }

    @Override
    public List<TagsVO> convertDO2VOList(List<TagsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
            return null;
        }
        return doList.stream().map(this::convertDO2VO).collect(Collectors.toList());
    }

    @Override
    public TagsVO convertDO2VO(TagsDO tagsDO) {
        if(tagsDO == null) {
            return null;
        }
        return TagsVO.builder()
                .tagTitle(tagsDO.getTagTitle()).build();
    }

    @Override
    public TagsDO convertDTO2DO(TagsDTO tagsDTO) {
        if(tagsDTO == null) {
            return TagsDO.builder().build();
        }
        return TagsDO.builder()
                .id(tagsDTO.getId())
                .tagTitle(tagsDTO.getTagTitle())
                .build();
    }
}
