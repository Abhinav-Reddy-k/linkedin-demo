package com.example.linkedin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    private String hNo;
    private String colony;
    private String state;
    private String country;
    private String locality;
    private String city;
    private Long id;

    private Long profileId;

    public Address() {
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gethNo() {
        return hNo;
    }

    public void sethNo(String hNo) {
        this.hNo = hNo;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
