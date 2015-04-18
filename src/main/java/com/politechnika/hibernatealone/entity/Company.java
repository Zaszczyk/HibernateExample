package com.politechnika.hibernatealone.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long companyId;

    @Column(unique = true)
    private String companyName;

    @OneToMany(mappedBy = "company")
    private List<Employee> employee = new ArrayList<>();

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(final Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(final List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Company{" +
            "companyId=" + companyId +
            ", companyName='" + companyName + '\'' +
            ", employee=" + employee +
            '}';
    }
}
