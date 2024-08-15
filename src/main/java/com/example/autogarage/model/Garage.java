package com.example.autogarage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long garageId;

    private String imgURL;
    private String name;
    private String garageName;
    private Double rating;
    private Long contact;
    private String address;
    private String email;
    private String locationURL;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getGarageId() {
        return garageId;
    }
    public void setGarageId(Long garageId) {
        this.garageId = garageId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGarageName() {
        return garageName;
    }
    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public String getImgURL() {
        return imgURL;
    }
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    public Long getContact() {
        return contact;
    }
    public void setContact(Long contact) {
        this.contact = contact;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getLocationURL() {
        return locationURL;
    }
    public void setLocationURL(String locationURL) {
        this.locationURL = locationURL;
    }
    

}
