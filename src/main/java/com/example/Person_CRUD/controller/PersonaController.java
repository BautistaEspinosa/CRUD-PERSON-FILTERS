package com.example.Person_CRUD.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Person_CRUD.model.Persona;
import com.example.Person_CRUD.repository.PersonaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("${endpoints.base-url}")
public class PersonaController {
    private final PersonaRepository repositorio;

    public PersonaController(PersonaRepository repositorio){
        this.repositorio = repositorio;
    }
    
    @Value("${endpoints.filtros.porNombre}")
    private String FiltroPorNombre;

    @Value("${endpoints.filtros.porEdad}")
    private String FiltroPorEdad;
    
    @Value("${endpoints.filtros.porGenero}")
    private String FiltroPorGenero;

    @PostMapping
    public Persona creaPersona(@RequestBody Persona persona) {
        return repositorio.save(persona);
    }

    @GetMapping
    public List<Persona> getPersonas() {
        return repositorio.findAll();
    }
    
    @GetMapping("${endpoints.filtros.porNombre}")
    public List<Persona> FiltroPorNombre(@RequestParam Optional<String> nombre, @RequestParam Optional<String> Apaterno, @RequestParam Optional<String> Amaterno) {
        return repositorio.findAll().stream()
        .filter(persona->nombre.map(n->persona.getNombre().equalsIgnoreCase(n)).orElse(true))
        .filter(persona->Apaterno.map(n->persona.getApaterno().equalsIgnoreCase(n)).orElse(true))
        .filter(persona->Amaterno.map(n->persona.getAmaterno().equalsIgnoreCase(n)).orElse(true))
        .collect(Collectors.toList());
    }
    
    @GetMapping("${endpoints.filtros.porEdad}")
    public List<Persona> FiltroPorEdad(@RequestParam int edad) {
        return repositorio.findAll().stream()
        .filter(persona->persona.getEdad() == edad)
        .collect(Collectors.toList());
    }
    
    @GetMapping("${endpoints.filtros.porGenero}")
    public List<Persona> FiltroPorGenero(@RequestParam String genero) {
        return repositorio.findAll().stream()
        .filter(persona->persona.getGenero().equalsIgnoreCase(genero))
        .collect(Collectors.toList());
    }
    
}
