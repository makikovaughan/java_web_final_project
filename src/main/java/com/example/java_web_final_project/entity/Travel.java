package com.example.java_web_final_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Travel {

    //Instance
    @Id
    @GeneratedValue
    Integer id;

    String country;
    Integer review;
    String comment;

    //Constructor
    public Travel() {
    }

    public Travel(Integer id, String country, Integer review, String comment) {
        this.id = id;
        this.country = country;
        this.review = review;
        this.comment = comment;
    }

    public Travel(String country, Integer review, String comment) {
        this.country = country;
        this.review = review;
        this.comment = comment;
    }

    //getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //toString()
    @Override
    public String toString() {
        return "Travel{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", review=" + review +
                ", comment='" + comment + '\'' +
                '}';
    }
}
