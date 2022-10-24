package com.lc.blog.center.web;

import com.luc.framework.core.mvc.WebResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lucheng
 * @data: 2022/4/19 21:52
 * @version: 1.0
 */
@RestController
@RequestMapping("/index")
public class ExampleController {

    @GetMapping("/test")
    public WebResult<String> test() {
        return WebResult.successData("hello devtools!");
    }

}
