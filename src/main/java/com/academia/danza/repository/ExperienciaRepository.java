package com.academia.danza.repository;

import com.academia.danza.models.Experiencia;
import com.academia.danza.models.reportes.EdadMenor;
import com.academia.danza.models.reportes.ReporteYearsEstilo;
import com.academia.danza.models.reportes.ReporteYearsExp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ExperienciaRepository extends CrudRepository<Experiencia,Integer> {

    @Query(value = "select concat (a.nombre, \" \", a.apellido) as RegistroAlum, te.nombre as RegistroEstilo, e.years as experiencia from experiencia as e, alumno as a, tipo_estilo as te where e.alumno_id=a.id and e.tipo_estilo_id= te.id and  e.years >= 3 order by 3 asc", nativeQuery = true)
    Iterable<ReporteYearsExp> getExpYears();

    @Query(value = " select concat(a.nombre,\" \", a.apellido) as alum , e.years as years from experiencia as e, alumno as a , tipo_estilo as te where e.alumno_id= a.id and e.tipo_estilo_id = te.id and te.nombre like %:name% order by 2 desc", nativeQuery = true)
    Iterable<ReporteYearsEstilo> getYearsEstilo(@Param("name") String estilo);


}


