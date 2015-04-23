package com.politechnika.hibernatealone.entity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {
    EntityManager manager;

    public SubjectRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Subject subject){
        manager.getTransaction().begin();
        manager.persist(subject);
        manager.getTransaction().commit();
    }

    public Subject get(int id){
        return manager.find(Subject.class, id);
    }

    public void delete(Subject subject){
        manager.getTransaction().begin();
        manager.remove(subject);
        manager.getTransaction().commit();
    }

    public void update(Subject subject){
        manager.getTransaction().begin();
        manager.merge(subject);
        manager.getTransaction().commit();
    }
    public List<Subject> getAll(){
        List<Subject> subjects = new ArrayList<>();

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Subject> query = criteriaBuilder.createQuery(Subject.class);
        Root<Subject> from = query.from(Subject.class);
        CriteriaQuery<Subject> select = query.select(from);
        TypedQuery<Subject> queryFromManager = manager.createQuery(select);
        manager.getTransaction().begin();
        for (Subject subject : queryFromManager.getResultList()) {
            subjects.add(subject);
        }
        manager.getTransaction().commit();

        return subjects;
    }
}
