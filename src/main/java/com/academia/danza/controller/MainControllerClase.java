package com.academia.danza.controller;

import com.academia.danza.models.Alumno;
import com.academia.danza.models.Clase;
import com.academia.danza.models.reportes.ReporteClaseProfe;
import com.academia.danza.models.reportes.ReporteDiasAlumnos;
import com.academia.danza.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/academia/danza/clase")
public class MainControllerClase {

    @Autowired
    ClaseRepository claseRepository;

    @GetMapping(path = "/alumno/{alumno_id}/{dia}")
    public @ResponseBody
    Iterable<Clase> getClasesxAlumno(@PathVariable ("alumno_id") int alumno_id, @PathVariable("dia") String dia){
        return claseRepository.getClasexAlumno(alumno_id, dia);
    }

    @GetMapping(path = "/profesor/{profesor_id}")
    public @ResponseBody
    Iterable<ReporteClaseProfe> getClasesProfeById(@PathVariable ("profesor_id") int profesor_id ){
        return claseRepository.getClaseProfeById(profesor_id);
    }

    @GetMapping(path = "/alumno/asistencia/{dia}")
    public @ResponseBody
    Iterable<ReporteDiasAlumnos> getClaseDiaByParam(@PathVariable ("dia") String dia ){
        return claseRepository.getClaseDiaByParam(dia);
    }
}
