package com.academia.danza.repository;

import com.academia.danza.models.Clase;
import com.academia.danza.models.reportes.EdadMenor;
import com.academia.danza.models.reportes.ReporteClaseProfe;
import com.academia.danza.models.reportes.ReporteDiasAlumnos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClaseRepository extends CrudRepository<Clase,Integer> {

    @Query(value = "select c.* from alumnoxclase as ac, alumno as a, clase as c where ac.alumno_id = a.id and ac.clase_id= c.id and alumno_id= :alumno_id and dia like %:name%", nativeQuery = true)
    Iterable<Clase> getClasexAlumno(@Param("alumno_id") int alumno_id, @Param("name") String dia);

    @Query(value = "select concat (a.nombre, \" \", a.apellido) as alum, te.nombre as estilo, c.dia as dia, c.hora as hora from alumnoxclase as ac, alumno as a, clase as c, tipo_estilo as te where ac.alumno_id = a.id and ac.clase_id = c.id and c.tipo_estilo_id =te.id and c.profesor_id = :profesor_id", nativeQuery = true)
    Iterable<ReporteClaseProfe> getClaseProfeById(@Param("profesor_id") int profesor_id);

    @Query(value = "select concat (a.nombre, \" \", a.apellido) as alum, concat(p.nombre, \" \", p.apellido) as profe, te.nombre as estilo, c.dia as dia, c.hora as hora from alumnoxclase as ac, alumno as a, clase as c, profesor as p, tipo_estilo as te where ac.alumno_id=a.id and ac.clase_id=c.id and c.profesor_id = p.id and c.tipo_estilo_id= te.id and c.dia like %:name% order by 5 asc", nativeQuery = true)
    Iterable<ReporteDiasAlumnos> getClaseDiaByParam(@Param("name") String dia);




}