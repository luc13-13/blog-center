package com.lc.blog.center.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * 修改 mybatis plus 的 uid 生成方式，采用uid-provider项目中的接口 /uid/nextId
 * 对 tag 等数据量较少的表采用 mybatis plus 的自增ID，需要对TagDO类的 id进行设置 idType =
 * @author: lucheng
 * @data: 2022/4/28 11:22
 * @version: 1.0
 */
@Component
@Slf4j
public class IUidGenerator implements IdentifierGenerator {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Number nextId(Object entity) {

        long id = restTemplate.getForObject("http://192.168.223.128:8888/uid/nextId",Long.class);
        log.info("IUidGenerator:---------Get uid : {}",id);
        return id;
    }

}
