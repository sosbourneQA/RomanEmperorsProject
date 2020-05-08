package com.qa.service;

import com.qa.domain.Article;
import com.qa.dto.ArticleDTO;
import com.qa.repo.ArticlesRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceIntegrationTest {

    @Autowired
    private ArticleService service;

    @Autowired
    private ArticlesRepository repo;

    @Autowired
    private ModelMapper mapper;

    private Article testArticle;

    private Article testArticleWithId;

    private ArticleDTO mapToDTO(Article article) {
        return this.mapper.map(article, ArticleDTO.class);
    }

    @Before
    public void setUp() {
        this.repo.deleteAll();
        this.testArticle = new Article("text");
        this.testArticleWithId = this.repo.save(this.testArticle);

    }

    @Test
    public void readArticleTest() {
        assertThat(this.service.readArticles()).isEqualTo(
                Stream.of(this.mapToDTO(testArticle)).collect(Collectors.toList())
        );
    }

    @Test
    public void createArticleTest() {
        assertEquals(this.mapToDTO(this.testArticleWithId), this.service.createArticle(testArticle));
    }

    @Test
    public void findArticleByIdTest() {
        assertThat(this.service.findArticleById(this.testArticleWithId.getId())).isEqualTo(this.mapToDTO(this.testArticleWithId));
    }

    @Test
    public void deleteArticleTest() {
        assertThat(this.service.deleteArticle(this.testArticleWithId.getId())).isFalse();
    }
}

