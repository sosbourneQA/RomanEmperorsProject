package com.qa.service;



import com.qa.domain.Article;
import com.qa.dto.ArticleDTO;
import com.qa.exceptions.ArticleNotFoundException;
import com.qa.repo.ArticlesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final ArticlesRepository repo;
    private final ModelMapper mapper;

    @Autowired
    public ArticleService(ArticlesRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private ArticleDTO mapToDTO(Article article) {
        return this.mapper.map(article, ArticleDTO.class);
    }

    public List<ArticleDTO> readArticles() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ArticleDTO createArticle(Article article) {
        Article tempArticle = this.repo.save(article);
        return this.mapToDTO(tempArticle);
    }

    public ArticleDTO findArticleById(Long id) {
        return this.mapToDTO(this.repo.findById(id).orElseThrow(ArticleNotFoundException::new));
    }

    public ArticleDTO updateArticle(Long id, Article article) {
        Article update = this.repo.findById(id).orElseThrow(ArticleNotFoundException::new);
        update.setText(article.getText());
        Article tempArticle = this.repo.save(article);
        return this.mapToDTO(tempArticle);
    }

    public boolean deleteArticle(Long id) {
        if(!this.repo.existsById(id)) {
            throw new ArticleNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }


}