package com.wongweiye.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {


    private static final long serialVersionUID = -5594338369163343180L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    // one-to-one associations are only rarely used in relational table models, the attribute defined on entity that maps
    // the database table contains foreign key column owns the association
    // we should avoid to use unidirectional one-to-many associations
    // Many-to-Many association default fetch type was the FetchType.LAZY
    @OneToMany(mappedBy="employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Email> emails = new ArrayList<>();

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name) &&
                Objects.equals(emails, employee.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, emails);
    }
}
