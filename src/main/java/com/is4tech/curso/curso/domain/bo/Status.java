package com.is4tech.curso.curso.domain.bo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Status {
    private Integer id;
    private String name;
    private String description;

    @Id
    @Column(name = "id", table = "status", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", table = "status", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", table = "status", length = 70)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(id, status.id) &&
                Objects.equals(name, status.name) &&
                Objects.equals(description, status.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
