package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import entidades.Evento;

/**
 * Entity implementation class for Entity: Alerta
 *
 */
@Entity
@Table(name="Alerta")
public class Alerta implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int alertaID;
    
    private String nombreAlerta;
    private LocalDateTime fechaFinal;
    private LocalDateTime fechaProx;
    private int intervalo;

	@OneToOne(mappedBy = "alertaID")
	private Evento evento;


	public Alerta() {
		super();
	}


	public int getAlertaID() {
		return alertaID;
	}


	public void setAlertaID(int alertaID) {
		this.alertaID = alertaID;
	}


	public String getNombreAlerta() {
		return nombreAlerta;
	}


	public void setNombreAlerta(String nombreAlerta) {
		this.nombreAlerta = nombreAlerta;
	}


	public LocalDateTime getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(LocalDateTime fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	public LocalDateTime getFechaProx() {
		return fechaProx;
	}


	public void setFechaProx(LocalDateTime fechaProx) {
		this.fechaProx = fechaProx;
	}


	public int getIntervalo() {
		return intervalo;
	}


	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}


	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
}
