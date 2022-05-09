package com.lc.blog.center.handler;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static com.lc.blog.center.enums.TZoneEnum.SHANGHAI;

/**
 * @author: lucheng
 * @data: 2022/4/28 19:41
 * @version: 1.0
 */
@Component
@Slf4j
public class MyObjectMetaHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Date insertD = Date.from(LocalDateTime.now().atZone(ZoneId.of(SHANGHAI.getZone())).toInstant());
        log.info("填充时间insertFill：{}",LocalDateTime.now(ZoneId.of(SHANGHAI.getZone())));
        this.strictInsertFill(metaObject,"gmtCreate", Date.class, insertD);
        this.strictInsertFill(metaObject,"gmtModified", Date.class, insertD);
        log.info("自动填充后：{},{}",JSONObject.toJSONString(metaObject.getValue("gmtCreate")),JSONObject.toJSONString(metaObject.getValue("gmtModified")));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date updateD = Date.from(LocalDateTime.now().atZone(ZoneId.of(SHANGHAI.getZone())).toInstant());
        this.strictUpdateFill(metaObject,"gmtModified", Date.class, updateD);
    }
}
