package entidades;

import java.io.Serializable;
import javax.persistence.*;



@Entity
public class Usuario implements Serializable {
 
 private static final long serialVersionUID = 1L;

 @Id
 @OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
 private int id;

 private String nombre;

 private int componente;

 private String correo;
 
 private String contrasena;



 public Usuario () {
 }

 public int getId() {
  return this.id;
 }

 public void setId (int id) {
  this.id = id;
 }

 public String getNombre () {
  return this.nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public int getComponente () {
  return this.componente;
 }

 public void setComponente(int componente) {
  this.componente = componente;
 }

 public String getCorreo () {
  return this.correo;
 }

 public void setCorreo(String correo) {
  this.correo = correo;
 }

 public String getContrasena() {
  return this.contrasena;
 }

 public void setContrasena(String contrasena) {
  this.contrasena = contrasena;
 }
 
}
