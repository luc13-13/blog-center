package com.lc.blog.center.web.article;

import com.lc.blog.center.bo.ArticleBO;
import com.lc.blog.center.bo.TagsBO;
import com.lc.blog.center.constant.HttpRequestHeaderConstant;
import com.lc.blog.center.convertor.ArticleConvertor;
import com.lc.blog.center.service.ArticleService;
import com.lc.blog.center.service.TagsService;
import com.lc.blog.center.utils.LucStringUtils;
import com.lc.blog.center.web.AbstractWebController;
import com.lc.blog.center.web.vo.ArticleVO;
import com.luc.framework.core.mvc.WebResult;
import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lucheng
 * @data: 2022/5/4 17:24
 * @version: 1.0
 */
@Api(tags = "文章管理")
@RestController
@RequestMapping("/admin/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleActionController extends AbstractWebController {
    private final ArticleService articleService;
    private final TagsService tagsService;
    private final ArticleConvertor articleConvertor;

    @ApiOperation("创建文章，仅管理员可用")
    @PostMapping("/create")
//    @ApiImplicitParam(name = "createRequest", value = "ArticleCreateRequest", required = true)
    public WebResult<String> createArticle(@ApiParam("articleCreateRequest") @RequestBody ArticleCreateRequest articleCreateRequest) {
        String userId = this.getHeaderValue(HttpRequestHeaderConstant.USER_ID);
        articleCreateRequest.setCreatorId(Long.parseLong(userId));
        articleService.createOne(articleCreateRequest);
        log.info("com.lc.blog.center.web.article.ArticleActionController$createArticle:创建文章成功");
        return WebResult.successData("创建成功");
    }

    @ApiOperation("更细文章标签，需要前端处理好标签idList为字符串")
    @PostMapping("/updateTags")
    public WebResult<String> addTags(@RequestParam String tagsIdList,
                                     @RequestParam Long articleId,
                                     @RequestParam Integer isAdd) {
        log.info("目标文章：{}",articleId);
        ArticleBO articleBO = ArticleBO.builder()
                .id(articleId)
                .tagId(tagsIdList).build();
        articleService.updateArticleDO(articleBO);

        // 更新标签引用量
        List<Long> tagsId = LucStringUtils.parseToLongList(tagsIdList);
        List<TagsBO> boList = new ArrayList<>();
        tagsId.forEach(i ->
                boList.add(TagsBO.builder()
                        .id(i)
                        .referenceAdd(1).build()
                ));
        tagsService.updateBatchRefCount(tagsId, isAdd);
        return WebResult.successData("添加成功！");
    }

    @ApiOperation("修改文章")
    @PostMapping("/saveOrUpdate")
    public WebResult<String> saveOrUpdateArticle(@RequestBody ArticleVO articleVO) {
        return WebResult.successData("修改成功");
    }

}
