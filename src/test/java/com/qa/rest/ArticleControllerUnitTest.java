package com.qa.rest;


import com.qa.domain.Article;
import com.qa.dto.ArticleDTO;
import com.qa.service.ArticleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleControllerUnitTest {

    @InjectMocks
    private ArticleController controller;

    @Mock
    private ArticleService service;

    private List<Article> articles;

    private Article testArticle;

    private Article testArticleWithId;

    private long id = 1L;

    private ArticleDTO articleDTO;

    private final ModelMapper mapper = new ModelMapper();

    private final ArticleDTO mapToDTO(Article article) {
        return this.mapper.map(article, ArticleDTO.class);
    }

    @Before
    public void setUp() {
        this.articles = new ArrayList<>();
        this.testArticle = new Article("text");
        this.articles.add(testArticle);
        this.testArticleWithId = new Article(testArticle.getText());
        this.testArticleWithId.setId(this.id);
        this.articleDTO = this.mapToDTO(testArticleWithId);
    }

    @Test
    public void getAllArticlesTest() {
        when(service.readArticles()).thenReturn(this.articles.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No emperors found", this.controller.getAllArticles().getBody().isEmpty());
        verify(service, times(1)).readArticles();
    }

    @Test
    public void createArticleTest() {
        when(this.service.createArticle(testArticle)).thenReturn(this.articleDTO);
        assertEquals(this.controller.createArticle(testArticle), new ResponseEntity<ArticleDTO>(this.articleDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createArticle(testArticle);
    }

    @Test
    public void deleteArticleTestFalse() {
        this.controller.deleteArticle(id);
        verify(service, times(1)).deleteArticle(id);
    }

    @Test
    public void deleteArticleTestTrue() {
        when(service.deleteArticle(3L)).thenReturn(true);
        this.controller.deleteArticle(3L);
        verify(service, times(1)).deleteArticle(3L);
    }

    @Test
    public void getArticleByIdTest() {
        when(this.service.findArticleById(id)).thenReturn(this.articleDTO);
        assertEquals(this.controller.getArticleById(id), new ResponseEntity<ArticleDTO>(this.articleDTO, HttpStatus.OK));
        verify(service, times(1)).findArticleById(id);
    }

}

