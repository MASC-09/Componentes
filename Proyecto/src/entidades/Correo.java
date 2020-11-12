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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adjuntos == null) ? 0 : adjuntos.hashCode());
		result = prime * result + componente;
		result = prime * result + correoID;
		result = prime * result + ((cuerpo == null) ? 0 : cuerpo.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + emisor;
		result = prime * result + (estado ? 1231 : 1237);
		result = prime * result + ((receptores == null) ? 0 : receptores.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Correo other = (Correo) obj;
		if (adjuntos == null) {
			if (other.adjuntos != null)
				return false;
		} else if (!adjuntos.equals(other.adjuntos))
			return false;
		if (componente != other.componente)
			return false;
		if (correoID != other.correoID)
			return false;
		if (cuerpo == null) {
			if (other.cuerpo != null)
				return false;
		} else if (!cuerpo.equals(other.cuerpo))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (emisor != other.emisor)
			return false;
		if (estado != other.estado)
			return false;
		if (receptores == null) {
			if (other.receptores != null)
				return false;
		} else if (!receptores.equals(other.receptores))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	
	
	
   
}
