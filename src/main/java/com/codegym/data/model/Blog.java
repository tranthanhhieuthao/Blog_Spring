package com.codegym.data.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(updatable = false)
    @CreationTimestamp
    @JsonIgnore
    private Date date;
    private String describle;
    private String detail;

    @ManyToOne
    @JoinColumn(name = "Category_id")
    private Category category;

    public Category getCategory(){
        return category;
    }

    public void  setCategory(Category category){
        this.category = category;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Blog(){
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Blog(String detail, String describle){
        this.detail =detail;
        this.describle = describle;
    }

    @Override
    public String toString(){
        return String.format("Blog[id=%d,describle='%s']",id,describle);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }
}
