package com.qa.dto;

public class EmperorDTO {

    private Long id;
    private String name;
    private String reignStart;
    private String reignEnd;


    public EmperorDTO() {
    }

    public EmperorDTO(Long id, String name, String reignStart, String reignEnd) {
        this.id = id;
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
}
