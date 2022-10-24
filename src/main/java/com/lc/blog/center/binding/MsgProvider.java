package com.lc.blog.center.binding;

import com.lc.blog.center.model.TagsDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * @Author : Lu Cheng
 * @Date : 2022/9/27 15:23
 * @Version : 1.0
 */
//@Component(value = "msgProvider")
@Slf4j
public class MsgProvider implements Supplier<BaseMsg<TagsDO>>{
    AtomicInteger count = new AtomicInteger(0);
    @Override
    @ConditionalOnBean(TagAction.class)
    public BaseMsg<TagsDO> get() {
        BaseMsg<TagsDO> tagsDOBaseMsg = new BaseMsg<TagsDO>(count.addAndGet(1),
                "addTags",
                TagsDO.builder().id(1001L).tagTitle("创建tags").build());
        log.info("发送消息: " + tagsDOBaseMsg);
        return tagsDOBaseMsg;
    }
}
