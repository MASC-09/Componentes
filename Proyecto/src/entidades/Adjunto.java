package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Adjunto
 *
 */
@Entity
@Table(name="Adjunto")
public class Adjunto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
    @ManyToOne
	@JoinColumn(name = "idEvento")
	private Evento evento;
	
	private String nombreAdjunto;
	
	public Adjunto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getNombreAdjunto() {
		return nombreAdjunto;
	}

	public void setNombreAdjunto(String nombreAdjunto) {
		this.nombreAdjunto = nombreAdjunto;
	}
	
	
	
   
}
