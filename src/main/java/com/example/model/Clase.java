package com.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Clase {

    @Id
    @GeneratedValue
    private int id;
    private String name;
}
