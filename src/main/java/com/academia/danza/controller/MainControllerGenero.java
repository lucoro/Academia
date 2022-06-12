package com.academia.danza.controller;

import com.academia.danza.models.Genero;
import com.academia.danza.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path= "/academia/danza/genero")
public class MainControllerGenero {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Genero> getAllGenero() {
        return generoRepository.findAll();

    }

    @GetMapping(path = "/{id_genero}")
    public @ResponseBody
    Optional<Genero> getGeneroById(@PathVariable("id_genero") int id_genero){
        return generoRepository.findById(id_genero);
    }

    @PostMapping(path = "/create",
            consumes = "application/json", produces = "application/json")
    public Genero createGenero(@RequestBody Genero newGenero){
        return generoRepository.save(newGenero);
    }

    @PutMapping(path = "/update",
            consumes ="application/json", produces = "application/json")
    public Genero updateGenero(@RequestBody Genero updateGenero){
        return generoRepository.save(updateGenero);
    }

    @DeleteMapping(path = "/delete/{id_genero}")
    public @ResponseBody
    Iterable<Genero> deleteGeneroById(@PathVariable("id_genero") int id_genero){
        generoRepository.deleteById(id_genero);
        return generoRepository.findAll();
    }


}
