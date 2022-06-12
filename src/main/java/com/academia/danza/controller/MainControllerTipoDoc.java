package com.academia.danza.controller;

import com.academia.danza.models.TipoDoc;
import com.academia.danza.repository.TipoDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path= "/academia/danza/tipoDoc")
public class MainControllerTipoDoc {

    @Autowired
    private TipoDocRepository tipoDocRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<TipoDoc> getAllTipoDocs() {
        return tipoDocRepository.findAll();
    }

    @GetMapping(path = "/{id_tipo_doc}")
    public @ResponseBody
    Optional<TipoDoc> getTipoDocById(@PathVariable("id_tipo_doc") int id_td) {
        return tipoDocRepository.findById(id_td);
    }

    @PostMapping(path = "/create",
            consumes = "application/json", produces = "application/json")
    public TipoDoc createTipoDoc(@RequestBody TipoDoc newTipoDoc) {
        return tipoDocRepository.save(newTipoDoc);
    }

    @PutMapping(path = "/update",
            consumes = "application/json", produces = "application/json")
    public TipoDoc updateTipoDoc(@RequestBody TipoDoc updatedTipoDoc) {
        return tipoDocRepository.save(updatedTipoDoc);
    }

    @DeleteMapping(path = "/delete/{id_tipo_doc}")
    public @ResponseBody
    Iterable<TipoDoc> deleteTipoDocById(@PathVariable("id_tipo_doc") int id_td) {
        tipoDocRepository.deleteById(id_td);
        return tipoDocRepository.findAll();
    }
}
