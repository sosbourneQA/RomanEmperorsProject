package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Emperor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String reignStart;
    private String reignEnd;

    public Emperor() {
    }

    public Emperor(String name, String reignStart, String reignEnd) {
        this.name = name;
        this.reignStart = reignStart;
        this.reignEnd = reignEnd;
    }

    public Emperor(Long id, String name, String reignStart, String reignEnd) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emperor emperor = (Emperor) o;
        return id.equals(emperor.id) &&
                name.equals(emperor.name) &&
                reignStart.equals(emperor.reignStart) &&
                reignEnd.equals(emperor.reignEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, reignStart, reignEnd);
    }
}
