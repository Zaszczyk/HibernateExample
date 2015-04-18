package com.politechnika.hibernatealone.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "classes")
public class Klasa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "class_id")
    private Integer classId;

    @Column(unique = true, length = 2)
    private String name;

    @Column(length = 9)
    private String year;

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getClassId() {
        return classId;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Klasa{" +
            "classId=" + classId +
            ", name='" + name + '\'' +
            ", year=" + year +
            '}';
    }
}
