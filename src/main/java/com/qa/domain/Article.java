package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long articleId;
    private String text;

    @ManyToOne(targetEntity = Emperor.class)
    private Emperor emperor;

    public Article() {
    }

    public Article(String text) {
        this.text = text;
    }

    public Article(Long id, String text) {
        this.articleId = id;
        this.text = text;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long id) {
        this.articleId = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Emperor getEmperor() {
        return emperor;
    }

    public void setEmperor(Emperor emperor) {
        this.emperor = emperor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return articleId.equals(article.articleId) &&
                Objects.equals(text, article.text) &&
                Objects.equals(emperor, article.emperor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, text, emperor);
    }
}
