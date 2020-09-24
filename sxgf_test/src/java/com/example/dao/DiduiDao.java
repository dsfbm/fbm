package com.example.dao;

import com.example.entity.DiGui;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiduiDao extends JpaRepository<DiGui,Object> {
    List<DiGui> findByPId(Integer pid);
}
