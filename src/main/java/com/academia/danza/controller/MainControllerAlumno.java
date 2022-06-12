package com.academia.danza.controller;

import com.academia.danza.models.Alumno;
import com.academia.danza.models.Experiencia;
import com.academia.danza.models.reportes.EdadMenor;
import com.academia.danza.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path= "/academia/danza/alumno")
public class MainControllerAlumno {

    @Autowired
    public AlumnoRepository alumnoRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Alumno> getAllAlumnos(){
        return alumnoRepository.findAll();
    }

    @GetMapping(path = "/{alumno_id}")
    public @ResponseBody
    Optional<Alumno> getAlumnosById(@PathVariable("alumno_id") int id_al){
        return alumnoRepository.findById(id_al);
    }

    @GetMapping(path = "/edad/menor")
    public @ResponseBody
    Iterable<EdadMenor> getAlumnoEdad1(){
        return alumnoRepository.getAlumnoEdadMenor();
    }


    @PostMapping(path = "/create",
            consumes="application/json", produces = "application/json")
    public Alumno alumnoCreate(@RequestBody Alumno newAlumno){
        return alumnoRepository.save(newAlumno);
    }
    @PutMapping(path = "/update",
            consumes = "application/json", produces = "application/json")
    public Alumno updateAlumno(@RequestBody Alumno updateAlumno){
        return alumnoRepository.save(updateAlumno);
    }

    @DeleteMapping(path = "/delete/{alumno_id}")
    public @ResponseBody
    Iterable<Alumno> deleteAlumno(@PathVariable("alumno_id") int id_al){
        alumnoRepository.deleteById(id_al);
        return alumnoRepository.findAll();
    }
}
