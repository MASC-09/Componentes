package correo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bitacora
 *
 */
@Entity
//@Table(name="Bitacora")

public class Bitacora implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int bitacoraID;
	private String accion;
    private LocalDateTime fechaHora;
    private String entidad;
    private int entidadID;

	public Bitacora() {
		super();
	}

	public int getBitacoraID() {
		return bitacoraID;
	}

	public void setBitacoraID(int bitacoraID) {
		this.bitacoraID = bitacoraID;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public int getEntidadID() {
		return entidadID;
	}

	public void setEntidadID(int entidadID) {
		this.entidadID = entidadID;
	}
	
	
   
}
