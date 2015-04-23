package com.politechnika.hibernatealone.entity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    Student student;
    EntityManager manager;

    public StudentRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Student student){
        manager.getTransaction().begin();
        manager.persist(student);
        manager.getTransaction().commit();
    }

    public Student get(int id){
        return manager.find(Student.class, id);
    }

    public void delete(Student student){
        manager.getTransaction().begin();
        manager.remove(student);
        manager.getTransaction().commit();
    }

    public void update(Student student){
        manager.getTransaction().begin();
        manager.merge(student);
        manager.getTransaction().commit();
    }
    public List<Student> getAll(){
        List<Student> students = new ArrayList<>();

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        Root<Student> from = query.from(Student.class);
        CriteriaQuery<Student> select = query.select(from);
        TypedQuery<Student> queryFromManager = manager.createQuery(select);
        manager.getTransaction().begin();
        for (Student student : queryFromManager.getResultList()) {
            students.add(student);
        }
        manager.getTransaction().commit();

        return students;
    }
}
