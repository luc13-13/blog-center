package com.lc.blog.center.binding;

import com.lc.blog.center.model.TagsDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @Author : Lu Cheng
 * @Date : 2022/9/20 00:27
 * @Version : 1.0
 */
@Configuration
@Slf4j
public class TestBindingConfig {
    private AtomicInteger count = new AtomicInteger(1);

//    @Bean
//    public Function<String, String> transfer(){
//        return (input) ->  {
//            input = input+"-afterTransfer";
//            log.info("after transfer:" + input);
//            return input;
//        };
//    }


    @Bean(value = "msgProvider")
    public Supplier<BaseMsg<TagsDO>> msgProvider() {
        /** 这里消息要用import org.springframework.messaging.support.@link{MessageBuilder};才行*/
        return () -> {
            BaseMsg<TagsDO> tagsDOBaseMsg = new BaseMsg<>(1, TagsDO.builder().id(1001L).tagTitle("创建tags").build());
            log.info("发送消息: " + count.addAndGet(1));
            return tagsDOBaseMsg;
        };
    }

    @Bean(value = "msgConsumer")
    public Consumer<Object> msgConsumer() {
        return (o) -> {
            log.info("consumer01收到消息:" + o.toString());
        };
    }
}
