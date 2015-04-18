package com.politechnika.hibernatealone.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "mark")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mark_id")
    private Integer markId;

    private Integer mark;

    @Column(length = 30)
    private String description;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;

}
