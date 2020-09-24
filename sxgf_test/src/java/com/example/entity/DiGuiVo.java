package com.example.entity;

import lombok.Data;


import java.util.List;

@Data
public class DiGuiVo {
    private Integer id;
    private String name;

    private List<DiGuiVo> diGuiVos;
}
