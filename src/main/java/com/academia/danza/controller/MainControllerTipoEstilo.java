package com.academia.danza.controller;

import com.academia.danza.models.TipoEstilo;
import com.academia.danza.repository.TipoEstiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "/academia/danza/tipoEstilo")
public class MainControllerTipoEstilo {

    @Autowired
    public TipoEstiloRepository tipoEstiloRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<TipoEstilo> getAllEstilos(){
        return tipoEstiloRepository.findAll();
    }

    @GetMapping(path = "/{id_tipo_estilo}")
    public @ResponseBody
    Optional<TipoEstilo> getEstiloById(@PathVariable("id_tipo_estilo") int id_te){
        return tipoEstiloRepository.findById(id_te);
    }

    @GetMapping(path = "/consulta/{name}")
    public @ResponseBody
    List<TipoEstilo> getTipoEstiloByName(@PathVariable("name") String name){
        return tipoEstiloRepository.getTipoEstiloByName(name);
    }

    @PostMapping(path = "/create",
            consumes = "application/json", produces = "application/json")
    public TipoEstilo createEstilo (@RequestBody TipoEstilo newEstilo){
        return tipoEstiloRepository.save(newEstilo);
    }

    @PutMapping(path = "/update",
            consumes = "application/json", produces = "application/json")
    public TipoEstilo updateEstilo(@RequestBody TipoEstilo updateEstilo){
        return tipoEstiloRepository.save(updateEstilo);
    }

    @DeleteMapping(path = "/delete/{id_tipo_estilo}")
    public @ResponseBody
    Iterable<TipoEstilo> deleteEstilo(@PathVariable("id_tipo_estilo") int id_te){
        tipoEstiloRepository.deleteById(id_te);
        return tipoEstiloRepository.findAll();
    }
}
