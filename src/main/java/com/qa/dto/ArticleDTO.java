package com.qa.dto;

import java.util.Objects;

public class ArticleDTO {

    private Long articleId;
    private String text;

    public ArticleDTO() {
    }

    public ArticleDTO(String text) {
        this.text = text;
    }

    public ArticleDTO(Long id, String text) {
        this.articleId = id;
        this.text = text;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleDTO that = (ArticleDTO) o;
        return articleId.equals(that.articleId) &&
                text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, text);
    }
}
