package com.example.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="sxgf_gf")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String class1;
    private String tel;


}
