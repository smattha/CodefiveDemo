package com.skyroof.model;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RequestMapping("firstpost/")
public class MyRequest {

    //fields
    String firstName;
    String lastName;
    String country;
    String id;
    int age;
    Date date;
    AgeType ageType;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AgeType getAgeType() {
        return ageType;
    }

    public void setAgeType(AgeType ageType) {
        this.ageType = ageType;
    }

    @Override
    public String toString() {
        return "MyRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", ageType=" + ageType +
                '}';
    }
}
