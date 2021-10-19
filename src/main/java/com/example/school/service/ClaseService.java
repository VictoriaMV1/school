package com.example.school.service;

import com.example.school.model.Clase;
import com.example.school.repository.IClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService implements IClaseService{

    @Autowired
    IClassRepo classRepo;
    @Override
    public boolean save(Clase clase) throws Exception {
        return false;
    }

    @Override
    public List<Clase> findAll() {
        return null;
    }

    @Override
    public Clase findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
