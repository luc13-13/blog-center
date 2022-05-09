package com.lc.blog.center.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lc.blog.center.bo.TagsBO;
import com.lc.blog.center.dto.TagsDTO;
import com.lc.blog.center.model.TagsDO;
import com.lc.blog.center.web.request.PageResult;
import com.lc.blog.center.web.request.SearchRequest;

import java.util.List;

/**
 * (Tags)表服务接口
 * @author lucheng
 * @date 2022-05-04 22:12:40
 */
public interface TagsService extends IService<TagsDO> {

    /**
     * 查询多条数据
     *
     * @param tagsDTO 查询条件
     * @return 对象列表
     */
    Page<TagsBO> getTagsDOListPage(TagsDTO tagsDTO);

    /**
     * 新增数据
     *
     * @param tagsDO 实例对象
     * @return 实例对象
     */
    TagsDO creatOrUpdate(TagsDO tagsDO);

    /**
     * 修改数据
     *
     * @param tagsDO 实例对象
     * @return 实例对象
     */
    TagsDO updateTagsDO(TagsDO tagsDO);

    boolean updateBatchRefCount(List<Long> tagsIds, Integer add);

    /**
     * 物理删除
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    int createByName(String tagsName);

}
