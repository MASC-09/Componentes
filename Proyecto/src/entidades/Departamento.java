package entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Departamento
 *
 */
@Entity
//@Table(name="Departamento")

public class Departamento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDepartamento;
	private String nombreSistema;


	@ManyToMany (mappedBy="Evento", cascade=CascadeType.ALL)
	private Set<Evento> eventos;

	@OneToMany(mappedBy="Usuario", cascade=CascadeType.ALL)
	private Set<Usuario> usuarios;
	

	public Departamento() {
		super();
	}


	public int getIdDepartamento() {
		return idDepartamento;
	}


	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}


	public String getNombreSistema() {
		return nombreSistema;
	}


	public void setNombreSistema(String nombreSistema) {
		this.nombreSistema = nombreSistema;
	}


	public Set<Evento> getEventos() {
		return eventos;
	}


	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}


	public Set<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
   
}
