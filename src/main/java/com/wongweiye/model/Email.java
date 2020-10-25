package com.wongweiye.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "email")
public class Email  {

    private static final long serialVersionUID = 3933081088642448523L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;

    @OneToMany(mappedBy="email", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Address> emailAddress = new ArrayList<>();;


//    @OneToOne(mappedBy = "email", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Address address;

    public Email(long id, String type, Employee employee) {
        this.id = id;
        this.type = type;
        this.employee = employee;

    }

    public Email() {
    }

//    public Email( String type, Employee employee) {
//
//        this.type = type;
//        this.employee = employee;
//
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Address> getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(List<Address> emailAddress) {
        this.emailAddress = emailAddress;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return id == email.id &&
                Objects.equals(type, email.type) &&
                Objects.equals(employee, email.employee) &&
                Objects.equals(emailAddress, email.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, employee, emailAddress);
    }
}
