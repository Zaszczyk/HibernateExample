package com.politechnika.hibernatealone.entity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class KlasaRepository {
    Klasa klasa;
    EntityManager manager;

    public KlasaRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Klasa klasa){
        manager.getTransaction().begin();
        manager.persist(klasa);
        manager.getTransaction().commit();
    }

    public Klasa get(int id){
        return manager.find(Klasa.class, id);
    }

    public void delete(Klasa klasa){
        manager.getTransaction().begin();
        manager.remove(klasa);
        manager.getTransaction().commit();
    }

    public void update(Klasa klasa){
        manager.getTransaction().begin();
        manager.merge(klasa);
        manager.getTransaction().commit();
    }
    public List<Klasa> getAll(){
        List<Klasa> klasas = new ArrayList<>();

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Klasa> query = criteriaBuilder.createQuery(Klasa.class);
        Root<Klasa> from = query.from(Klasa.class);
        CriteriaQuery<Klasa> select = query.select(from);
        TypedQuery<Klasa> queryFromManager = manager.createQuery(select);
        manager.getTransaction().begin();
        for (Klasa klasa : queryFromManager.getResultList()) {
            klasas.add(klasa);
        }
        manager.getTransaction().commit();

        return klasas;
    }
}
