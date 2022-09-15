package com.lc.blog.center.convertor;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lc.blog.center.bo.TagsBO;
import com.lc.blog.center.dto.TagsDTO;
import com.lc.blog.center.model.TagsDO;
import com.lc.blog.center.web.vo.TagsVO;

import java.util.List;

/**
 * @author: lucheng
 * @data: 2022/5/4 22:37
 * @version: 1.0
 */
public interface TagsConvertor {

    TagsVO convertBO2VO(TagsBO tagsBO);

    Page<TagsVO> convertBO2VOPage(Page<TagsBO> tagsBOPage);

    TagsDO convertBO2DO(TagsBO bo);

    List<TagsDO> convertBO2DOList(List<TagsBO> boList);

    TagsBO convertDO2BO(TagsDO tagsDO);

    Page<TagsBO> convertDO2BOPage(Page<TagsDO> doPage);

    List<TagsVO> convertDO2VOList(List<TagsDO> doList);

    TagsVO convertDO2VO(TagsDO tagsDO);

    TagsDO convertDTO2DO(TagsDTO tagsDTO);
}
