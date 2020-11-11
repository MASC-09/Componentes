package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Correos
 * Tiene los atributos correoId, date, emisor, titulo, cuerpo, adjuntos, estado, componente,receptores
 *
 */
@Entity

public class Correo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private int correoID;
	private String date;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private int emisor;
	private String titulo;
	private String cuerpo;	
	@OneToMany(mappedBy="adjunto", cascade = CascadeType.ALL)
	private List<Adjunto> adjuntos;
	private boolean estado;
	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable(name = "Correo_Componente", 
	   joinColumns = { @JoinColumn(name = "idCorreo") }, 
	   inverseJoinColumns = { @JoinColumn(name = "idComponente") })
	private int componente;
	private List<String> receptores;
	
	public Correo() {
		super();
	}

	public int getCorreoID() {
		return correoID;
	}

	public void setCorreoID(int correoID) {
		this.correoID = correoID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getEmisor() {
		return emisor;
	}

	public void setEmisor(int emisor) {
		this.emisor = emisor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public List<Adjunto> getAdjuntos() {
		return adjuntos;
	}

	public void setAdjuntos(List<Adjunto> adjuntos) {
		this.adjuntos = adjuntos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getComponente() {
		return componente;
	}

	public void setComponente(int componente) {
		this.componente = componente;
	}

	public List<String> getReceptores() {
		return receptores;
	}

	public void setReceptores(List<String> receptores) {
		this.receptores = receptores;
	}
	
	
	
	
	
   
}
