package com.qa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Emperor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emperorId;
    private String name;
    private String reignStart;
    private String reignEnd;

    @OneToMany(mappedBy = "emperor", fetch = FetchType.EAGER)
    private List<Article> articles = new ArrayList<>();

    public Emperor() {
    }

    public Emperor(String name, String reignStart, String reignEnd) {
        this.name = name;
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
    }

    public Emperor(Long id, String name, String reignStart, String reignEnd) {
        this.emperorId = id;
        this.name = name;
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
    }

    public Emperor(String name, String reignStart, String reignEnd, List<Article> articles) {
        this.name = name;
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
        this.articles = articles;
    }

    public Emperor(Long id, String name, String reignStart, String reignEnd, List<Article> articles) {
        this.emperorId = id;
        this.name = name;
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
        this.articles = articles;
    }

    public Long getEmperorId() {
        return emperorId;
    }

    public void setEmperorId(Long id) {
        this.emperorId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReignStart() {
        return reignStart;
    }

    public void setReignStart(String reignStart) {
        this.reignStart = reignStart;
    }

    public String getReignEnd() {
        return reignEnd;
    }

    public void setReignEnd(String reignEnd) {
        this.reignEnd = reignEnd;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emperor emperor = (Emperor) o;
        return emperorId.equals(emperor.emperorId) &&
                Objects.equals(name, emperor.name) &&
                Objects.equals(reignStart, emperor.reignStart) &&
                Objects.equals(reignEnd, emperor.reignEnd) &&
                Objects.equals(articles, emperor.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emperorId, name, reignStart, reignEnd, articles);
    }
}
