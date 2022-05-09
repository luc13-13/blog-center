package com.lc.blog.center.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lc.blog.center.bo.ArticleBO;
import com.lc.blog.center.convertor.ArticleConvertor;
import com.lc.blog.center.convertor.TagsConvertor;
import com.lc.blog.center.model.ArticleDO;
import com.lc.blog.center.mapper.ArticleDao;
import com.lc.blog.center.model.TagsDO;
import com.lc.blog.center.service.ArticleService;
import com.lc.blog.center.service.TagsService;
import com.lc.blog.center.utils.LucStringUtils;
import com.lc.blog.center.web.article.ArticleCreateRequest;
import com.lc.blog.center.web.vo.ArticleVO;
import com.lc.blog.center.web.vo.ConditionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.lc.blog.center.web.request.PageResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.security.InvalidParameterException;
import java.util.List;

import static com.lc.blog.center.enums.StatusEnum.*;
import static com.lc.blog.center.enums.SystemEnums.*;

/**
 * (Article)表服务接口
 *
 * @author lucheng
 * @date 2022-04-28 20:55:11
 */
@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleDO> implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleConvertor articleConvertor;
    @Autowired
    private TagsService tagsService;
    @Autowired
    private TagsConvertor tagsConvertor;


    /**
     * 查询多条数据
     *
     * @param condition 查询条件
     * @return 对象列表
     */
    public PageResult<ArticleBO> getArticleBOListPage(ConditionVO condition) {
        Page<ArticleDO> page = articleDao.selectPage(new Page<ArticleDO>(condition.getCurrent(), condition.getSize()),
                new LambdaQueryWrapper<ArticleDO>()
                        .select(ArticleDO::getId, ArticleDO::getContentTitle, ArticleDO::getCoverUrl, ArticleDO::getGmtCreate, ArticleDO::getGmtModified)
                        .eq(ArticleDO::getCreatorId, ADMIN_ID.getCode())
                        .eq(ArticleDO::getState, VALID.getCode())
                        .eq(ArticleDO::getRecommend, condition.getRecommend())
                        .orderByAsc(ArticleDO::getGmtModified));

        PageResult<ArticleBO> result = articleConvertor.convertDOPage2BO(page);
        return result;
    }

    @Override
    public ArticleVO getDetail(Long articleId) {
        ArticleDO articleDO =  super.getById(articleId);
        if(articleDO == null) {
            throw new InvalidParameterException("没有指定文章，id="+articleId);
        }
        ArticleVO vo = articleConvertor.convertDO2VO(articleDO);
        //封装tags
        List<Long> tagsIdList = LucStringUtils.parseToLongList(articleDO.getTagId());
        List<TagsDO> tagsDOS = tagsService.listByIds(tagsIdList);
        vo.setTagsVOList(tagsConvertor.convertDO2VOList(tagsDOS));
        //封装点赞和评论列表

        return vo;
    }

    /**
     * 创建文章
     * @param articleCreateRequest
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createOne(ArticleCreateRequest articleCreateRequest) {
        ArticleDO articleDO = articleConvertor.convertRequest2DO(articleCreateRequest);
        articleDao.insert(articleDO);
        log.info("com.lc.blog.center.service.impl$createOne:创建文章成功{}", JSONObject.toJSONString(articleDO));

        // 更新标签引用数量
        List<Long> tagsIdList = LucStringUtils.parseToLongList(articleDO.getTagId());
        if(!CollectionUtils.isEmpty(tagsIdList)) {
            tagsService.updateBatchRefCount(tagsIdList, COUNT_ADD.getCode());
        }
        return true;
    }

    /**
     * 新增数据
     *
     * @param articleVO 实例对象
     * @return 实例对象
     */
    public boolean saveOrUpdateOne(ArticleVO articleVO) {

        // 更新文章内容：

        // 更新标签引用

        // 跟新

        return true;
    }

    /**
     * 修改数据
     *
     * @param articleBO 实例对象
     * @return 实例对象
     */
    public int updateArticleDO(ArticleBO articleBO) {
        return articleDao.updateById(articleConvertor.convertBO2DO(articleBO));
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

}
