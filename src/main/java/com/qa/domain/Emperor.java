package com.qa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Emperor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String reignStart;
    private String reignEnd;

    @OneToMany(mappedBy = "emp", fetch = FetchType.LAZY)
    private List<Article> articles = new ArrayList<>();

    public Emperor() {
    }

    public Emperor(String name, String reignStart, String reignEnd) {
        this.name = name;
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return id.equals(emperor.id) &&
                Objects.equals(name, emperor.name) &&
                Objects.equals(reignStart, emperor.reignStart) &&
                Objects.equals(reignEnd, emperor.reignEnd) &&
                Objects.equals(articles, emperor.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, reignStart, reignEnd, articles);
    }
}
