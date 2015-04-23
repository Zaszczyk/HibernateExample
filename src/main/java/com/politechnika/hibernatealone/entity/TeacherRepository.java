package com.politechnika.hibernatealone.entity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    Teacher teacher;
    EntityManager manager;

    public TeacherRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Teacher teacher){
        manager.getTransaction().begin();
        manager.persist(teacher);
        manager.getTransaction().commit();
    }

    public Teacher get(int id){
        return manager.find(Teacher.class, id);
    }

    public void delete(Teacher teacher){
        manager.getTransaction().begin();
        manager.remove(teacher);
        manager.getTransaction().commit();
    }

    public void update(Teacher teacher){
        manager.getTransaction().begin();
        manager.merge(teacher);
        manager.getTransaction().commit();
    }
    public List<Teacher> getAll(){
        List<Teacher> teachers = new ArrayList<>();

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Teacher> query = criteriaBuilder.createQuery(Teacher.class);
        Root<Teacher> from = query.from(Teacher.class);
        CriteriaQuery<Teacher> select = query.select(from);
        TypedQuery<Teacher> queryFromManager = manager.createQuery(select);
        manager.getTransaction().begin();
        for (Teacher teacher : queryFromManager.getResultList()) {
            teachers.add(teacher);
        }
        manager.getTransaction().commit();

        return teachers;
    }
}
