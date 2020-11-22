package entidades;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Usuario implements Serializable {
 
 private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long idUsuario;
 private String nombre;
 private String correo;
 private String contrasena;

 @ManyToOne
 @JoinColumn(name="idDepartamento")
 private Departamento departamento;

 public Departamento getDepartamento() {
     return departamento;
 }

 public void setDepartamento(Departamento departamento) {
     this.departamento = departamento;
 }

 public Usuario () {
 }

 public Long getIdUsuario() {
  return this.idUsuario;
 }

 public void setIdUsuario(Long idUsuario) {
  this.idUsuario = idUsuario;
 }

 public String getNombre () {
  return this.nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
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

//@Override
//public int hashCode() {
//	final int prime = 31;
//	long result = 1;
//	result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
//	result = prime * result + ((correo == null) ? 0 : correo.hashCode());
//	result = prime * result + (Long idUsuario);
//	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
//	return result;
//}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Usuario other = (Usuario) obj;
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
	if (idUsuario != other.idUsuario)
		return false;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	return true;
}
 
 
}
