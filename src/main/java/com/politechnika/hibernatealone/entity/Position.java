package com.politechnika.hibernatealone.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long positionId;

    @Column(unique = true)
    private String positionName;

    @OneToMany(mappedBy = "position")
    private List<Employee> employee = new ArrayList<Employee>();

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(final Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(final String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(final List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Position{" +
            "positionId=" + positionId +
            ", positionName='" + positionName + '\'' +
            ", employee=" + employee +
            '}';
    }
}
