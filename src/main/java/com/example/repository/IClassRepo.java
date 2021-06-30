package com.example.repository;

import com.example.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepo extends JpaRepository<Clase, Integer> {
}
