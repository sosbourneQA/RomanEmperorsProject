package com.qa.dto;

import java.util.List;
import java.util.Objects;

public class EmperorDTO {

    private Long id;
    private String name;
    private String reignStart;
    private String reignEnd;
    private List<ArticleDTO> articles;


    public EmperorDTO() {
    }

    public EmperorDTO(String name, String reignStart, String reignEnd) {
        this.name = name;
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
    }

    public EmperorDTO(String name, String reignStart, String reignEnd, List<ArticleDTO> articles) {
        this.name = name;
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
        this.articles = articles;
    }

    public EmperorDTO(Long id, String name, String reignStart, String reignEnd, List<ArticleDTO> articles) {
        this.id = id;
        this.name = name;
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
        this.articles = articles;
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

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmperorDTO that = (EmperorDTO) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(reignStart, that.reignStart) &&
                Objects.equals(reignEnd, that.reignEnd) &&
                Objects.equals(articles, that.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, reignStart, reignEnd, articles);
    }
}
