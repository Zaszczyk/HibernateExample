package com.politechnika.hibernatealone.application;

import com.politechnika.hibernatealone.entity.Company;
import com.politechnika.hibernatealone.entity.Employee;
import com.politechnika.hibernatealone.entity.Position;

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

        Position position = new Position();
        position.setPositionName("Manager");

        manager.persist(position);
 
        Company company = new Company();
        company.setCompanyName("Fulda");
        
        manager.persist(company);
                
        Employee employee = new Employee();
        employee.setPosition(position);
        employee.setFullName("Zenek Zenkowski");
        employee.setStreet("Paderewskiego");
        employee.setStreetNumber("26/64");
        employee.setCompany(company);

        manager.persist(employee);
        manager.getTransaction().commit();

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = query.from(Employee.class);
        CriteriaQuery<Employee> select = query.select(from);
        TypedQuery<Employee> queryFromManager = manager.createQuery(select);
//        manager.getTransaction().begin();
        for (Employee emp : queryFromManager.getResultList()) {
            System.out.println(emp.toString());
//            manager.remove(emp);
        }
//        manager.getTransaction().commit();
        
        manager.close();
        factory.close();



    }

}
