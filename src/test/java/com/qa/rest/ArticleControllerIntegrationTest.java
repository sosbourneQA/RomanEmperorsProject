package com.qa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Article;
import com.qa.dto.ArticleDTO;
import com.qa.repo.ArticlesRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleControllerIntegrationTest {
//    4 Tests

    @Autowired
    private MockMvc mock;

    @Autowired
    private ArticlesRepository repo;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Article testArticle;

    private Article testArticleWithID;

    private long id;

    private ArticleDTO articleDTO;

    private ArticleDTO mapToDTO(Article article){
        return this.mapper.map(article, ArticleDTO.class);
    }

    @Before
    public void setUp(){
        this.repo.deleteAll();
        this.testArticle = new Article("text");
        this.testArticleWithID = this.repo.save(testArticle);
        this.id = testArticleWithID.getId();
        this.articleDTO = this.mapToDTO(testArticleWithID);
    }

    @Test
    public void getAllArticleTest() throws Exception {
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        articleDTOList.add(articleDTO);
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getAllArticles")
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(articleDTOList));
    }

    @Test
    public void getArticleByID() throws Exception {
        String content = this.mock.perform(
                request(HttpMethod.GET, "/getArticleById/" + this.id)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(content, this.objectMapper.writeValueAsString(articleDTO));
    }

    @Test
    public void createArticleTest() throws Exception {
        String result = this.mock.perform(
                request(HttpMethod.POST, "/createArticle")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(testArticle))
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(articleDTO));
    }

    @Test
    public void deleteArticleTest() throws Exception {
        this.mock.perform(
                request(HttpMethod.DELETE, "/deleteArticle/" + this.id)
        ).andExpect(status().isNoContent());
    }


}
