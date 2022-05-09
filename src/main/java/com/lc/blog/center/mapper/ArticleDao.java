package com.lc.blog.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.lc.blog.center.model.ArticleDO;
import com.lc.blog.center.bo.ArticleBO;
import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author lucheng
 * @date 2022-04-28 19:33:31
 */
@Mapper
public interface ArticleDao extends BaseMapper<ArticleDO> {

    List<ArticleDO> queryAllByLimit();
    
    List<ArticleDO> queryAll(ArticleBO bo);
}
