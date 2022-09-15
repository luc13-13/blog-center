package com.lc.blog.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lc.blog.center.bo.PaperSetBO;
import com.lc.blog.center.convertor.PaperSetConvertor;
import com.lc.blog.center.model.PaperSetDO;
import com.lc.blog.center.mapper.PaperSetDao;
import com.lc.blog.center.service.PaperSetService;
import com.lc.blog.center.web.vo.ConditionVO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.lc.blog.center.web.request.PageResult;
import java.util.List;
/**
 * (PaperSet)表服务接口
 * @author lucheng
 * @date 2022-04-28 20:55:11
 */
@Service
public class PaperSetServiceImpl extends ServiceImpl<PaperSetDao,PaperSetDO> implements PaperSetService {
    
    @Autowired
    private PaperSetDao paperSetDao;
    @Autowired
    private PaperSetConvertor  paperSetConvertor;


    /**
     * 查询多条数据
     *
     * @param condition 查询条件
     * @return 对象列表
     */
    public PageResult<PaperSetBO> getPaperSetBOPage(ConditionVO condition){
        if(condition == null) {
            return new PageResult<>();
        }
        //condition转为DO作为查询条件
//        Page<PaperSetDO> page = paperSetDao.selectPage(new Page<>(condition.getCurrent(), condition.getSize()),
//                new LambdaQueryWrapper<PaperSetDO>()
//                        .eq(ObjectUtils.isNotEmpty(condition.getPaperSetId()), PaperSetDO::getId, condition.getPaperSetId())
//                        .eq(ObjectUtils.isNotEmpty(condition.getUserId()), PaperSetDO::getCreatorId, condition.getUserId())
//                        .eq(PaperSetDO::getState, condition.getState())
//                        .like(ObjectUtils.isNotEmpty(condition.getContentTitle()),PaperSetDO::getSetTitle, condition.getContentTitle())
//                        .between(ObjectUtils.isNotEmpty(condition.getStartDate()),PaperSetDO::getGmtCreate, condition.getStartDate(), condition.getEndDate())
//                );
        Page<PaperSetDO> page = paperSetDao.selectPage(new Page<>(condition.getCurrent(), condition.getSize()),
                new LambdaQueryWrapper<>(paperSetConvertor.convertCondition2DO(condition))
                        .like(condition.getFuzzyQuery() && ObjectUtils.isNotEmpty(condition.getContentTitle()),PaperSetDO::getSetTitle, condition.getContentTitle())
                        .between(ObjectUtils.isNotEmpty(condition.getStartDate()),PaperSetDO::getGmtCreate, condition.getStartDate(), condition.getEndDate())
        );
        PageResult<PaperSetBO> result = paperSetConvertor.convertDO2BOPage(page);
        return result;
    }

    /**
     * 新增数据
     *
     * @param paperSetBO 实例对象
     * @return 实例对象
     */
    public PaperSetDO creatOrUpdate(PaperSetBO paperSetBO) {
        this.saveOrUpdate(paperSetConvertor.convertBO2DO(paperSetBO));
        return null;
    }

    /**
     * 修改数据
     *
     * @param paperSetBO 实例对象
     * @return 实例对象
     */
    public PaperSetBO updatePaperSetDO(PaperSetBO paperSetBO) {
        return null;
    }

    /**
     * 物理删除
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return true ;
    }
}
