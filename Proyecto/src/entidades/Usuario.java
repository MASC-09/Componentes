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
 
 @ManyToOne
 @JoinColumn(name="idComponente")
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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + componente;
	result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
	result = prime * result + ((correo == null) ? 0 : correo.hashCode());
	result = prime * result + id;
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Usuario other = (Usuario) obj;
	if (componente != other.componente)
		return false;
	if (contrasena == null) {
		if (other.contrasena != null)
			return false;
	} else if (!contrasena.equals(other.contrasena))
		return false;
	if (correo == null) {
		if (other.correo != null)
			return false;
	} else if (!correo.equals(other.correo))
		return false;
	if (id != other.id)
		return false;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	return true;
}
 
 
}
