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

    // this is a bidirectional association
    // owning side tracked by Hibernate means the side of the relation that have/owns the foreign key in the database
    // by annotate this entity as many to one, making this entity address as the owning side, also owning side mostly will have @JoinColumn annotation
    // @JoinColumn will generate a column email_id (refer as foreign key) in this entity class point to email entity class primary key
    // mark the many-to-one side as the owning side will be the good practice
    // to link the address to the new email, need to call address.setEmail(email) because that is the owning side of the relation
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
