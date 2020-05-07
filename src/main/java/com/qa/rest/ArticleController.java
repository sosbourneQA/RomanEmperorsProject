package com.qa.rest;


import com.qa.domain.Article;
import com.qa.dto.ArticleDTO;
import com.qa.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class ArticleController {

//    private final ArticleService service;
//
//    @Autowired
//    public ArticleController(ArticleService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/getAllArticles")
//    public ResponseEntity<List<ArticleDTO>> getAllArticle() {
//        return ResponseEntity.ok(this.service.readArticles());
//    }
//
//    @PostMapping("/createArticle")
//    public ResponseEntity<ArticleDTO> createEmperor(@RequestBody Article article) {
//        return new ResponseEntity<ArticleDTO>(this.service.createArticle(article), HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/deleteArticle/{id}")
//    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
//        return this.service.deleteArticle(id)
//                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
//                : ResponseEntity.noContent().build();
//
//    }
//
//    @GetMapping("/getArticleById/{id}")
//    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) {
//        return ResponseEntity.ok(this.service.findArticleById(id));
//    }
//
//    @PutMapping("/updateArticle/{id}")
//    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @RequestBody Article article) {
//        return ResponseEntity.ok(this.service.updateArticle(id, article));
//    }
//
//    @PutMapping("/updateEmperor2")
//    public ResponseEntity<ArticleDTO> updateEmperor2(@PathParam("id") Long id, @RequestBody Article article) {
//        return ResponseEntity.ok(this.service.updateArticle(id, article));
//    }
}
