package com.lc.blog.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.lc.blog.center.model.TagsDO;
import com.lc.blog.center.bo.TagsBO;
import java.util.List;

/**
 * (Tags)表数据库访问层
 *
 * @author lucheng
 * @date 2022-05-04 22:12:40
 */
@Mapper
public interface TagsDao extends BaseMapper<TagsDO> {

}
