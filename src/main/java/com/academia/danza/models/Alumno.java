package com.academia.danza.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "alumno")
public class Alumno {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String nombre;
 private String apellido;

@OneToOne
@JoinColumn(name = "tipo_doc_id", referencedColumnName = "id")
 private TipoDoc tipoDoc;

 private int numDoc;

 @OneToOne
 @JoinColumn(name = "genero_id", referencedColumnName = "id")
 private Genero genero;

 private Date fechaNac;
 private int edad;
 private String email;
 private int telefono;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getNombre() {
  return nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public String getApellido() {
  return apellido;
 }

 public void setApellido(String apellido) {
  this.apellido = apellido;
 }

 public TipoDoc getTipoDoc() {
  return tipoDoc;
 }

 public void setTipoDoc(TipoDoc tipoDoc) {
  this.tipoDoc = tipoDoc;
 }

 public int getNumDoc() {
  return numDoc;
 }

 public void setNumDoc(int numDoc) {
  this.numDoc = numDoc;
 }

 public Genero getGenero() {
  return genero;
 }

 public void setGenero(Genero genero) {
  this.genero = genero;
 }

 public Date getDate() {
  return fechaNac;
 }

 public void setDate(Date date) {
  this.fechaNac = date;
 }

 public int getEdad() {
  return edad;
 }

 public void setEdad(int edad) {
  this.edad = edad;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public int getTelefono() {
  return telefono;
 }

 public void setTelefono(int telefono) {
  this.telefono = telefono;
 }
}
