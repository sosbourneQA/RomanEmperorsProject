package com.qa.domain;

import java.util.Objects;

public class Article {

    private Long id;
    private String text;

    public Article() {
    }

    public Article(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Article article = (Article) o;
        return id.equals(article.id) &&
                text.equals(article.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }
}
