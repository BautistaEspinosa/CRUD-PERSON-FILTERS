package com.example.Person_CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Person_CRUD.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Long>{

    
} 