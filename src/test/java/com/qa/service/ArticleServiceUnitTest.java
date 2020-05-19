package com.qa.service;



import com.qa.domain.Article;
import com.qa.dto.ArticleDTO;
import com.qa.exceptions.ArticleNotFoundException;
import com.qa.repo.ArticlesRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ArticleServiceUnitTest {
//    5 Tests

    @InjectMocks
    private ArticleService service;

    @Mock
    private ArticlesRepository repo;

    @Mock
    private ModelMapper mapper;

    private List<Article> articleList;

    private Article testArticle;

    private long id = 1L;

    private Article testArticleWithId;

    private ArticleDTO articleDTO;

    private ArticleDTO mapToDTO(Article article) {
        return this.mapper.map(article, ArticleDTO.class);
    }

    @Before
    public void setUp() {
        this.articleList = new ArrayList<>();
        this.testArticle = new Article("text");
        this.articleList.add(testArticle);
        this.testArticleWithId = new Article(testArticle.getText());
        this.testArticleWithId.setArticleId(id);
        this.articleDTO = this.mapToDTO(testArticleWithId);
    }

    @Test
    public void getAllArticlesTest() {
        when(repo.findAll()).thenReturn(this.articleList);
        when(this.mapper.map(testArticleWithId, ArticleDTO.class)).thenReturn(articleDTO);
        assertFalse("Service returned no Articles", this.service.readArticles().isEmpty());
        verify(repo, times(1)).findAll();
    }

    @Test
    public void createArticleTest() {
        when(repo.save(testArticle)).thenReturn(testArticleWithId);
        when(this.mapper.map(testArticleWithId, ArticleDTO.class)).thenReturn(articleDTO);
        assertEquals(this.service.createArticle(testArticle), this.articleDTO);
        verify(repo, times(1)).save(this.testArticle);
    }

    @Test
    public void findArticleByIdTest() {
        when(this.repo.findById(id)).thenReturn(Optional.ofNullable(testArticleWithId));
        when(this.mapper.map(testArticleWithId, ArticleDTO.class)).thenReturn(articleDTO);
        assertEquals(this.service.findArticleById(this.id), articleDTO);
        verify(repo, times(1)).findById(id);
    }

    @Test
    public void deleteArticleById() {
        when(this.repo.existsById(id)).thenReturn(true, false);
        assertFalse(service.deleteArticle(id));
        verify(repo, times(1)).deleteById(id);
        verify(repo, times(2)).existsById(id);
    }

    @Test(expected = ArticleNotFoundException.class)
    public void deleteArticleByNonExistingId() {
        when(this.repo.existsById(id)).thenReturn(false);
        service.deleteArticle(id);
        verify(repo, times(1)).existsById(id);
    }


}