package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.*;

import entidades.Correo;

/**
 * Entity implementation class for Entity: Adjunto
 *
 */
@Entity

public class Adjunto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
    @ManyToOne
	@JoinColumn(name = "idCorreo")	
	private Correo correo;
	
	private Stream adjunto;
	public Adjunto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Stream getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(Stream adjunto) {
		this.adjunto = adjunto;
	}

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adjunto == null) ? 0 : adjunto.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + id;
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
		Adjunto other = (Adjunto) obj;
		if (adjunto == null) {
			if (other.adjunto != null)
				return false;
		} else if (!adjunto.equals(other.adjunto))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
    
}
