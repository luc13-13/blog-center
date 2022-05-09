package com.lc.blog.center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lc.blog.center.bo.PaperSetBO;
import com.lc.blog.center.model.PaperSetDO;
import com.lc.blog.center.web.request.PageResult;
import com.lc.blog.center.web.vo.ConditionVO;

import java.util.List;

/**
 * (PaperSet)表服务接口
 * @author lucheng
 * @date 2022-04-28 20:55:11
 */
public interface PaperSetService extends IService<PaperSetDO> {

    /**
     * 查询多条数据
     *
     * @param condition 查询条件
     * @return 对象列表
     */
    PageResult<PaperSetBO> getPaperSetDOListPage(ConditionVO condition);

    /**
     * 新增数据
     *
     * @param paperSetBO 实例对象
     * @return 实例对象
     */
    PaperSetDO creatOrUpdate(PaperSetBO paperSetBO);

    /**
     * 修改数据
     *
     * @param paperSetBO 实例对象
     * @return 实例对象
     */
    PaperSetBO updatePaperSetDO(PaperSetBO paperSetBO);

    /**
     * 物理删除
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


}
