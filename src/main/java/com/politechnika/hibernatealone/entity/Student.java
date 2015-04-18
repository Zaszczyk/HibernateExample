package com.politechnika.hibernatealone.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "class_id")
    private Long classId;

    @Column(length = 60)
    private String name;

    @Column(length = 60)
    private String surname;

    @Column(length = 120)
    private String street;

    @Column(length = 60)
    private String city;

    @Column(length = 6)
    private String zipcode;

    @Column(length = 1)
    private String sex;

    @Column(length = 11)
    private String pesel;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @ManyToOne
    @JoinColumn(name = "class_id")
    Klasa class_id;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", classId=" + classId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", sex='" + sex + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }


}
