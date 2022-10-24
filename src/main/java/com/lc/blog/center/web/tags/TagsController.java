package com.lc.blog.center.web.tags;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lc.blog.center.bo.TagsBO;
import com.lc.blog.center.convertor.TagsConvertor;
import com.lc.blog.center.dto.TagsDTO;
import com.lc.blog.center.service.TagsService;
import com.lc.blog.center.web.request.PageResult;
import com.lc.blog.center.web.request.SearchRequest;
import com.lc.blog.center.web.request.SearchRequestFilter;
import com.lc.blog.center.web.vo.TagsVO;
import com.luc.framework.core.mvc.WebResult;
import com.luc.framework.core.util.PaginationParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lucheng
 * @data: 2022/5/4 22:35
 * @version: 1.0
 */
@Api(tags = "标签查看与管理")
@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagsController {
    private final TagsService tagsService;
    private final TagsConvertor tagsConvertor;

    @PostMapping("create")
    @ApiOperation("创建标签")
    public WebResult<String> createTags(@RequestParam String tagsName) {
        tagsService.createByName(tagsName);
        return WebResult.successData("创建成功！");
    }

    @ApiOperation("分页获取标签列表")
    @GetMapping("/getPageList")
    public WebResult<Page<TagsVO>> tagPageList(SearchRequestFilter searchRequestFilter) {
        TagsDTO tagsDTO = TagsDTO.builder()
                .tagTitle(searchRequestFilter.getTitle())
                .pageIndex(searchRequestFilter.getPageIndex())
                .pageSize(searchRequestFilter.getPageSize()).build();
        Page<TagsBO> boPage =  tagsService.getTagsDOListPage(tagsDTO);
        return WebResult.successData(tagsConvertor.convertBO2VOPage(boPage));
    }
}
