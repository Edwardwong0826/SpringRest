package com.wongweiye.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {

    private static final long serialVersionUID = -6976604522767999092L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "address")
    private String addressName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_id")
    @JsonBackReference
    private Email email;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "email_id", referencedColumnName = "id", nullable = false)
//    @JsonBackReference
//    private Email email;

    public Address(long id, String addressName, Email email) {
        this.id = id;
        this.addressName = addressName;
        this.email = email;

    }

    public Address() {

    }

//    public Address(long id, String addressName, Email email) {
//        this.id = id;
//        this.addressName = addressName;
//        this.email = email;
//    }

//    public Address( String addressName, Email email) {
//
//        this.addressName = addressName;
//        this.email = email;
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                Objects.equals(addressName, address.addressName) &&
                Objects.equals(email, address.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressName, email);
    }
}
