package com.politechnika.hibernatealone.entity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MarkRepository {
    Mark mark;
    EntityManager manager;

    public MarkRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Mark mark){
        manager.getTransaction().begin();
        manager.persist(mark);
        manager.getTransaction().commit();
    }

    public Mark get(int id){
        return manager.find(Mark.class, id);
    }

    public void delete(Mark mark){
        manager.getTransaction().begin();
        manager.remove(mark);
        manager.getTransaction().commit();
    }

    public void update(Mark mark){
        manager.getTransaction().begin();
        manager.merge(mark);
        manager.getTransaction().commit();
    }
    public List<Mark> getAll(){
        List<Mark> marks = new ArrayList<>();

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Mark> query = criteriaBuilder.createQuery(Mark.class);
        Root<Mark> from = query.from(Mark.class);
        CriteriaQuery<Mark> select = query.select(from);
        TypedQuery<Mark> queryFromManager = manager.createQuery(select);
        manager.getTransaction().begin();
        for (Mark mark : queryFromManager.getResultList()) {
            marks.add(mark);
        }
        manager.getTransaction().commit();

        return marks;
    }
}
