package com.lc.blog.center.convertor;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lc.blog.center.dto.PaperSetDTO;
import com.lc.blog.center.model.PaperSetDO;
import com.lc.blog.center.bo.PaperSetBO;
import com.lc.blog.center.web.request.PageResult;
import com.lc.blog.center.web.vo.ConditionVO;
import com.lc.blog.center.web.vo.PaperSetVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * (PaperSet)表服务接口
 *
 * @author lucheng
 * @since 2022-09-02 17:21:13
 */
public interface PaperSetConvertor{
    PaperSetDO convertBO2DO(PaperSetBO paperSetBO);
    
    Page<PaperSetDO> convertBO2DOPage(Page<PaperSetBO> boPage);
    
    PageResult<PaperSetBO> convertDO2BOPage(Page<PaperSetDO> doPage);
    
    PaperSetBO convertDO2BO(PaperSetDO paperSetDO);
    
    List<PaperSetDO> convertBO2DOList(Page<PaperSetBO> boList);

    List<PaperSetBO> convertDO2BOList(List<PaperSetDO> doList);

    PaperSetDO convertDTO2DO(PaperSetDTO paperSetDTO);

    PaperSetVO convertBO2VO(PaperSetBO bo);

    PageResult<PaperSetVO> convertBO2VOPage(PageResult<PaperSetBO> boPageResult);

    PaperSetDO convertCondition2DO(ConditionVO conditionVO);

}

