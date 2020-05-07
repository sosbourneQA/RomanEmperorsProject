package com.qa.dto;

import java.util.Objects;

public class HistorianDTO {

    private Long id;
    private String name;
    private String speciality;

    public HistorianDTO() {
    }

    public HistorianDTO(Long id, String name, String speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorianDTO that = (HistorianDTO) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                speciality.equals(that.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, speciality);
    }
}
