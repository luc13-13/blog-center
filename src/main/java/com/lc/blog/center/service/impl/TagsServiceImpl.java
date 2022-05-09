package com.lc.blog.center.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lc.blog.center.bo.TagsBO;
import com.lc.blog.center.convertor.TagsConvertor;
import com.lc.blog.center.dto.TagsDTO;
import com.lc.blog.center.enums.StatusEnum;
import com.lc.blog.center.model.TagsDO;
import com.lc.blog.center.mapper.TagsDao;
import com.lc.blog.center.service.TagsService;
import com.lc.blog.center.web.request.PageResult;
import com.lc.blog.center.web.request.SearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (Tags)表服务接口
 * @author lucheng
 * @date 2022-05-04 22:12:40
 */
@Service
@Slf4j
public class TagsServiceImpl extends ServiceImpl<TagsDao,TagsDO> implements TagsService {
    
    @Autowired
    private TagsDao tagsDao;
    @Autowired
    private TagsConvertor tagsConvertor;
    

    /**
     * 查询多条数据
     *
     * @param tagsDTO 查询条件
     * @return 对象列表
     */
    public Page<TagsBO> getTagsDOListPage(TagsDTO tagsDTO){
        Page<TagsDO> page = new Page<>(tagsDTO.getPageIndex(), tagsDTO.getPageSize());
        Page<TagsDO> result =  tagsDao.selectPage(page, new LambdaQueryWrapper<TagsDO>().eq(TagsDO::getState, StatusEnum.VALID.getCode()));
        return tagsConvertor.convertDO2BOPage(result);
    }

    /**
     * 新增数据
     *
     * @param tagsDO 实例对象
     * @return 实例对象
     */
    public TagsDO creatOrUpdate(TagsDO tagsDO) {
        return null;
    }

    /**
     * 修改数据
     *
     * @param tagsDO 实例对象
     * @return 实例对象
     */
    public TagsDO updateTagsDO(TagsDO tagsDO) {
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateBatchRefCount(List<Long> tagsIds, Integer add) {
        // 先获取要更新的标签信息
        List<TagsDO> doList = super.listByIds(tagsIds);
        List<TagsDO> updateDO = new ArrayList<>();
        //      如果referenceAdd = 1, 为增加， referenceAdd = -1, 为减少
        // mybatis-plus在更新前回对字段是否为null进行判断，不更新为null的字段
        doList.forEach(o -> updateDO.add(
                TagsDO.builder()
                .id(o.getId())
                .referenceCount(o.getReferenceCount() + add).build()));
        log.info("com.lc.blog.center.service.impl.TagsServiceImpl$updateBatchRefCount:更新标签{}", JSONObject.toJSONString(doList));
        return super.updateBatchById(updateDO);
    }

    /**
     * 物理删除
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return true;
    }

    @Override
    public int createByName(String tagsName) {
        if (tagsDao.selectOne(new LambdaQueryWrapper<TagsDO>()
                .eq(TagsDO::getTagTitle,tagsName)) != null) {
            throw new IllegalArgumentException("标签名已存在！");
        }
        return tagsDao.insert(TagsDO.builder()
                .tagTitle(tagsName).build());
    }
}
