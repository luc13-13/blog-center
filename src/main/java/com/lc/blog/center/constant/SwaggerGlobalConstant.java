package com.lc.blog.center.constant;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lucheng
 * @data: 2022/5/4 23:23
 * @version: 1.0
 */
public class SwaggerGlobalConstant {
    public static List<Parameter> globalParameter() {

        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .name("user_id")
                .description("用户id").modelRef(new ModelRef("Long"))
                .parameterType("header").required(true).build()
        );
        return parameters;
    }
}
