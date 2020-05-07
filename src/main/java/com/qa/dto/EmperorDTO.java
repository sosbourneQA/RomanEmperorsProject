package com.qa.dto;

import java.util.Objects;

public class EmperorDTO {

    private Long id;
    private String name;
    private String reignStart;
    private String reignEnd;


    public EmperorDTO() {
    }

    public EmperorDTO(String name, String reignStart, String reignEnd) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmperorDTO that = (EmperorDTO) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                reignStart.equals(that.reignStart) &&
                reignEnd.equals(that.reignEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, reignStart, reignEnd);
    }
}
