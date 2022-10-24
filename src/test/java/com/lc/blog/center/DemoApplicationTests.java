package com.lc.blog.center;

import com.alibaba.fastjson.JSONObject;
import com.lc.blog.center.binding.BaseMsg;
import com.lc.blog.center.model.ArticleDO;
import com.lc.blog.center.model.TagsDO;
import com.lc.blog.center.service.ArticleService;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

	@Autowired
	public ArticleService articleService;

	@Autowired
	public StreamBridge streamBridge;

	@Test
	void contextLoads() {
	}

	@Test
	void saveArticle(){
		ArticleDO articleDO = ArticleDO.builder()
				.content("test article 01")
				.contentType("test")
				.contentTitle("Hello Article!")
				.creatorId(123456L)
				.build();
		articleService.save(articleDO);
	}

	@Test
	void sendMsg() {
		AtomicInteger count = new AtomicInteger(0);
		BaseMsg<TagsDO> tagsDOBaseMsg = new BaseMsg<TagsDO>(count.addAndGet(1), TagsDO.builder().id(1001L).tagTitle("创建tags").build());
//		CountDownLatch latch = new CountDownLatch(10);
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			MessageBuilder.withPayload(tagsDOBaseMsg).setHeader("msgType", "tagsAdd");
			streamBridge.send("msgConsumer-in-0", JSONObject.toJSONString(tagsDOBaseMsg));
		}
	}
}
