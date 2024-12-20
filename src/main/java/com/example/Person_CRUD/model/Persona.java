package com.example.Person_CRUD.model;

import jakarta.persistence.*;

@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String nombre;
    private String Apaterno;
    private String Amaterno;
    private int edad;
    private String genero;

    public Persona(){}

    public Persona(Long id, String nombre, String apaterno, String amaterno, int edad, String genero) {
        this.id = id;
        this.nombre = nombre;
        Apaterno = apaterno;
        Amaterno = amaterno;
        this.edad = edad;
        this.genero = genero;
    }

    //
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApaterno() {
        return Apaterno;
    }
    public void setApaterno(String apaterno) {
        Apaterno = apaterno;
    }
    public String getAmaterno() {
        return Amaterno;
    }
    public void setAmaterno(String amaterno) {
        Amaterno = amaterno;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    
}