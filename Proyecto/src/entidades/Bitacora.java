package entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/*
 * Entity implementation class for Entity: Correos
 */
@Entity

public class Bitacora implements Serializable {
	
	@Id
	private int bitacoraID;
	private String accion;
    private Date fechaHora;
    private String entidad;
    private int entidadID;

	private static final long serialVersionUID = 1L;

	public Bitacora() {
		super();
	}

	public int getBitacoraID() {
		return bitacoraID;
	}

	public void setBitacoraID(int bitacoraID) {
		this.bitacoraID = bitacoraID;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

    public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accion == null) ? 0 : accion.hashCode());
		result = prime * result + bitacoraID;
		result = prime * result + ((entidad == null) ? 0 : entidad.hashCode());
		result = prime * result + entidadID;
		result = prime * result + ((fechaHora == null) ? 0 : fechaHora.hashCode());
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
		Bitacora other = (Bitacora) obj;
		if (accion == null) {
			if (other.accion != null)
				return false;
		} else if (!accion.equals(other.accion))
			return false;
		if (bitacoraID != other.bitacoraID)
			return false;
		if (entidad == null) {
			if (other.entidad != null)
				return false;
		} else if (!entidad.equals(other.entidad))
			return false;
		if (entidadID != other.entidadID)
			return false;
		if (fechaHora == null) {
			if (other.fechaHora != null)
				return false;
		} else if (!fechaHora.equals(other.fechaHora))
			return false;
		return true;
	}
	
	
}
