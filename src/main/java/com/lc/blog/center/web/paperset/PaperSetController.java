package com.lc.blog.center.web.paperset;

import com.lc.blog.center.bo.PaperSetBO;
import com.lc.blog.center.convertor.PaperSetConvertor;
import com.lc.blog.center.dto.ArticleDTO;
import com.lc.blog.center.dto.PaperSetDTO;
import com.lc.blog.center.service.PaperSetService;
import com.lc.blog.center.web.AbstractWebController;
import com.lc.blog.center.web.request.PageResult;
import com.lc.blog.center.web.vo.ConditionVO;
import com.lc.blog.center.web.vo.PaperSetVO;
import com.luc.framework.core.mvc.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: lucheng
 * @data: 2022/4/28 20:03
 * @version: 1.0
 */
@Api(tags = "文章文件夹")
@RestController
@RequestMapping("/paperSet")
@AllArgsConstructor
@RestControllerAdvice
public class PaperSetController extends AbstractWebController {

    private final PaperSetService paperSetService;
    private final PaperSetConvertor paperSetConvertor;

    // 加载文件夹列表
    @ApiOperation("查询用户文件夹列表")
    @GetMapping("/list")
    public WebResult<PageResult<PaperSetVO>> listPaperSet(ConditionVO conditionVO) {
        // 默认的查询条件：userId+按创建时间排序
        // 附加筛选条件：文件夹名称，时间范围，
        // TODO 过滤user_id
        PageResult<PaperSetBO> boPageResult = paperSetService.getPaperSetBOPage(conditionVO);
        PageResult<PaperSetVO> voPageResult = paperSetConvertor.convertBO2VOPage(boPageResult);
        return WebResult.successData(voPageResult);
    }

    // 向文件夹中添加
    @ApiOperation("向文件夹中批量添加文章")
    public WebResult addArticleToPaperSet(List<ArticleDTO> articleDTOList) {
        // TODO
        return WebResult.success();
    }

    // 创建文件夹
    @ApiOperation("创建文件夹")
    @PostMapping("/create")
    public WebResult<String> createPaperSet(@RequestBody PaperSetDTO paperSetDTO) {
        // TODO 同一用户不可以有重复名称的文件夹
        paperSetService.saveOrUpdate(paperSetConvertor.convertDTO2DO(paperSetDTO));
        return WebResult.successData("创建成功 ");
    }

}
