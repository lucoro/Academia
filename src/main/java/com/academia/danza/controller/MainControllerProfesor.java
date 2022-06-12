package com.academia.danza.controller;


import com.academia.danza.models.Profesor;
import com.academia.danza.models.reportes.ReporteProfCantClases;
import com.academia.danza.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path= "/academia/danza/profesor")
public class MainControllerProfesor {

    @Autowired
    public ProfesorRepository profesorRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Profesor> getAllProfesores(){
        return profesorRepository.findAll();
    }

    @GetMapping(path = "/{profesor_id}")
    public @ResponseBody
    Optional<Profesor> getProfesorById(@PathVariable("profesor_id") int id_pr){
        return profesorRepository.findById(id_pr);
    }

    @GetMapping(path = "/clases")
    public @ResponseBody
    Iterable<ReporteProfCantClases> getProfClases(){
        return profesorRepository.getProfClases();
    }

    @PostMapping(path = "/create",
            consumes = "application/json", produces = "application/json")
    public Profesor createProfesor(@RequestBody Profesor newProfesor){
        return profesorRepository.save(newProfesor);
    }

    @PutMapping(path = "/update",
            consumes = "application/json", produces = "application/json")
    public Profesor updateProfesor(@RequestBody Profesor updateProfesor){
        return profesorRepository.save(updateProfesor);
    }

    @DeleteMapping(path = "/delete/{profesor_id}")
    public @ResponseBody
    Iterable<Profesor> deleteProfesor(@PathVariable("profesor_id") int id_pr){
        profesorRepository.deleteById(id_pr);
        return profesorRepository.findAll();
    }
}

