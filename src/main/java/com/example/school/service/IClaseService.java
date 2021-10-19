package com.example.school.service;

import com.example.school.model.Clase;

import java.util.List;

public interface IClaseService {
    boolean save(Clase clase) throws Exception;
    List<Clase> findAll();
    Clase findById(int id);
    void deleteById(int id);
}
