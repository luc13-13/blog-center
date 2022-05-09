package com.lc.blog.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.lc.blog.center.model.PaperSetDO;
import com.lc.blog.center.bo.PaperSetBO;
import java.util.List;

/**
 * (PaperSet)表数据库访问层
 *
 * @author lucheng
 * @date 2022-04-28 20:01:25
 */
@Mapper
public interface PaperSetDao extends BaseMapper<PaperSetDO> {

    List<PaperSetDO> queryAllByLimit();
    
    List<PaperSetDO> queryAll(PaperSetBO bo);
}
