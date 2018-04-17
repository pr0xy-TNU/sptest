package com.sptest.server.dao.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departament_role")
public class RoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "role_name")
    private String roleName;

    @Basic
    @Column(name = "role_salary")
    private double roleSalary;

    @Basic
    @Column(name = "role_code")
    private int roleCode;

    public RoleEntity(String roleName, double roleSalary, int roleCode) {
        this(roleName, roleSalary);
        this.roleCode = roleCode;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "role_employee",
        joinColumns = {@JoinColumn(name = "id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<EmployeeEntity> employees = new HashSet<>();

    public RoleEntity(String roleName, double roleSalary) {
        this.roleName = roleName;
        this.roleSalary = roleSalary;
    }

    public RoleEntity(Long id, String roleName, double roleSalary) {
        this(roleName, roleSalary);
        this.id = id;
    }

    public RoleEntity(Long id, String roleName, double roleSalary, int roleCode) {
        this.id = id;
        this.roleName = roleName;
        this.roleSalary = roleSalary;
        this.roleCode = roleCode;
    }



    public RoleEntity() {
        //default
    }

    public Long getId() {
        return id;
    }

    public void setId(Long roleId) {
        this.id = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public double getRoleSalary() {
        return roleSalary;
    }

    public void setRoleSalary(double roleSalary) {
        this.roleSalary = roleSalary;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public Set<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeEntity> employees) {
        this.employees = employees;
    }

}
