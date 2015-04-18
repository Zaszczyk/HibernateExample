package com.politechnika.hibernatealone.application;

import com.politechnika.hibernatealone.entity.Company;
import com.politechnika.hibernatealone.entity.Employee;
import com.politechnika.hibernatealone.entity.Student;
import com.politechnika.hibernatealone.entity.Klasa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;

public class HibernateAlone {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernateAlone");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        Klasa klasa = new Klasa();
        klasa.setName("1b");
        klasa.setYear("2014/2015");

        manager.persist(klasa);

        Student student = new Student();
        student.setName("Mateusz");
        student.setCity("Opole");
        student.setPesel("12345678901");
        student.setSex("M");
        student.setSurname("Blaszczyk");
        student.setStreet("Ozimska 3e");
        student.setZipcode("34-123");
        student.setKlasa(klasa);

        System.out.println(student.toString());

        manager.persist(student);

        manager.getTransaction().commit();

     /*   CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = query.from(Employee.class);
        CriteriaQuery<Employee> select = query.select(from);
        TypedQuery<Employee> queryFromManager = manager.createQuery(select);
//        manager.getTransaction().begin();
        for (Employee emp : queryFromManager.getResultList()) {
            System.out.println(emp.toString());
//            manager.remove(emp);
        }
//        manager.getTransaction().commit();*/
        
        manager.close();
        factory.close();



    }

}
