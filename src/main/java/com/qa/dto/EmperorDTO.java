package com.qa.dto;

import java.util.*;

public class EmperorDTO {

    private Long emperorId;
    private String name;
    private String reignStart;
    private String reignEnd;
    private List<ArticleDTO> articles;


    public EmperorDTO() {
    }

    public EmperorDTO(String name, String reignStart, String reignEnd, List<ArticleDTO> articles) {
        this.name = name;
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
        this.articles = articles;
    }

    public EmperorDTO(Long id, String name, String reignStart, String reignEnd, List<ArticleDTO> articles) {
        this.emperorId = id;
        this.name = name;
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
        this.articles = articles;
    }

    public Long getEmperorId() {
        return emperorId;
    }

    public void setEmperorId(Long emperorId) {
        this.emperorId = emperorId;
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
        return emperorId.equals(that.emperorId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(reignStart, that.reignStart) &&
                Objects.equals(reignEnd, that.reignEnd) &&
                Objects.equals(articles, that.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emperorId, name, reignStart, reignEnd, articles);
    }
}
