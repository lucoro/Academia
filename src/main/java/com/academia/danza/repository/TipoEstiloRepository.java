package com.academia.danza.repository;

import com.academia.danza.models.TipoEstilo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoEstiloRepository extends CrudRepository<TipoEstilo,Integer> {

    @Query(value = "select * from tipo_estilo where nombre like :name%", nativeQuery = true)
    List<TipoEstilo> getTipoEstiloByName(@Param("name") String nombre);
}




