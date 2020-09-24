package com.example.entity;

import lombok.Data;


import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="tree_01")
@Data
public class DiGui {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    @Column(name = "pid")
    private Integer pId;


}
