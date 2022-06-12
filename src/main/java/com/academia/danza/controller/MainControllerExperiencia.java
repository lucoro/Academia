package com.academia.danza.controller;

import com.academia.danza.models.Experiencia;
import com.academia.danza.models.reportes.ReporteYearsEstilo;
import com.academia.danza.models.reportes.ReporteYearsExp;
import com.academia.danza.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/academia/danza/experiencia")
public class MainControllerExperiencia {

    @Autowired
    ExperienciaRepository experienciaRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Experiencia> getAllExperiencia(){
        return experienciaRepository.findAll();
    }

    @GetMapping(path = "/years")
    public @ResponseBody
    Iterable<ReporteYearsExp> getExpYears(){
        return experienciaRepository.getExpYears();
    }

    @GetMapping(path = "/estilo/years/{estilo}")
    public @ResponseBody
    Iterable<ReporteYearsEstilo> getYearsEstilo(@PathVariable("estilo") String estilo){
        return experienciaRepository.getYearsEstilo(estilo);
    }


    @PostMapping(path = "/create",
    consumes="application/json", produces = "application/json")
    public Experiencia experienciaCreate(@RequestBody Experiencia newExperiencia){
        return experienciaRepository.save(newExperiencia);
    }

    @PutMapping(path ="/update",
            consumes="application/json", produces = "application/json")
    public Experiencia experienciaUpdate(@RequestBody Experiencia updateExperiencia){
        return experienciaRepository.save(updateExperiencia);
    }

    @DeleteMapping(path = "/delete/{experiencia_id}")
    public @ResponseBody
    Iterable<Experiencia> deleteExperiencia(@PathVariable("experiencia_id") int id_e) {
        experienciaRepository.deleteById(id_e);
        return experienciaRepository.findAll();

}
}

