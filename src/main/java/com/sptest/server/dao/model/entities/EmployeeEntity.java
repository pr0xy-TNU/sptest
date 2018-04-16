package com.sptest.server.dao.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long id;

    @Basic
    @Column(name = "employee_name")
    private String employeeName;

    @Basic
    @Column(name = "employee_age")
    private int employeeAge;

    @Basic
    @Column(name = "employee_adress")
    private String employeeAddress;

    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_employee", joinColumns = {
        @JoinColumn(name = "employee_id")}, inverseJoinColumns = {@JoinColumn(name = "employee_id")})*/
    @ManyToMany(mappedBy = "employees")
    private Set<RoleEntity> roles = new HashSet<>();


    public EmployeeEntity(Long id, String employeeName, int employeeAge, String employeeAddress) {
        this(employeeName, employeeAge, employeeAddress);
        this.id = id;
    }

    public EmployeeEntity(String employeeName, int employeeAge, String employeeAddress) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeAddress = employeeAddress;
    }

    public EmployeeEntity() {
        //default
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmployeeEntity)) {
            return false;
        }
        EmployeeEntity that = (EmployeeEntity) o;
        return id == that.id &&
            employeeAge == that.employeeAge &&
            Objects.equals(employeeName, that.employeeName) &&
            Objects.equals(employeeAddress, that.employeeAddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, employeeName, employeeAge, employeeAddress);
    }
}
