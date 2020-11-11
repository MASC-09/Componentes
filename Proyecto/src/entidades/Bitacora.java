package entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/*
 * Entity implementation class for Entity: Correos
 */
@Entity

public class Bitacora implements Serializable {
	
	@Id
	private int bitacoraID;
	private String accion;
    private String fechaHora;
    private String entidad;
    private int entidadID;

	// @ManyToOne
	// @JoinColumn(name = "idUsuario")
	// private int emisor;
	// private String titulo;
	// private String cuerpo;	
	// @OneToMany(mappedBy="adjuntos", cascade = CascadeType.ALL)
	// private List<Integer> adjuntos;
	// private boolean estado;
	// @ManyToMany (cascade = CascadeType.ALL)
	// @JoinTable(name = "Correo_Componente", 
	//    joinColumns = { @JoinColumn(name = "idCorreo") }, 
	//    inverseJoinColumns = { @JoinColumn(name = "idComponente") })
	// private int componente;
	// private List<String> receptores;
	
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

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

    public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
}
