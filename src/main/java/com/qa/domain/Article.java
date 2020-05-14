package com.qa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;

    @ManyToOne(targetEntity = Emperor.class)
    private Emperor emperor;

    public Article() {
    }

    public Article(String text) {
        this.text = text;
    }

    public Article(Long id, String text) {
        this.id = id;
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
        return id.equals(article.id) &&
                Objects.equals(text, article.text) &&
                Objects.equals(emperor, article.emperor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, emperor);
    }
}
