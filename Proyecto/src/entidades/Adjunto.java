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
	
}
