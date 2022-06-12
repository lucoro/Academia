package com.academia.danza.repository;

import com.academia.danza.models.*;
import com.academia.danza.models.reportes.EdadMenor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno,Integer> {

    @Query(value = "select concat (nombre, \" \", apellido) as nombre, edad from alumno where edad <=30", nativeQuery = true)
    Iterable<EdadMenor> getAlumnoEdadMenor();

}
