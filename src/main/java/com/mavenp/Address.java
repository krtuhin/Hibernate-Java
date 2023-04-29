package com.mavenp;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "student_address") //create table with name student_address
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //auto increament
    @Column(name = "address_id") //name of the column in database
    private int addressId;

    @Column(length = 50) //length of the column in database
    private String street;

    @Column(length = 100)
    private String city;

    @Column(name = "is_open", length = 5)
    private boolean isOpen;

    @Transient //do not create any column in database for this field
    private double x;

    @Column(name = "added_date")
    @Temporal(TemporalType.DATE) //for formatting the date (in this case take only date not time)
    private Date addedDate;

    @Lob // for large object
    private byte[] image;

    public Address() {
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
