package com.academia.danza.repository;

import com.academia.danza.models.Profesor;
import com.academia.danza.models.reportes.ReporteProfCantClases;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfesorRepository extends CrudRepository<Profesor,Integer> {

    @Query(value = "select concat (p.nombre, \" \", p.apellido) as profe, count(*) as cantClases from clase as c, profesor as p where c.profesor_id = p.id group by profesor_id", nativeQuery = true)
    List<ReporteProfCantClases> getProfClases();



}
