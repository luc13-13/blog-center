package com.lc.blog.center;

import com.lc.blog.center.model.ArticleDO;
import com.lc.blog.center.service.ArticleService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	public ArticleService articleService;

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
}
