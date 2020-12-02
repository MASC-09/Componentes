package correo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int eventoID;

	private byte completado;

	private String descripcion;

	private String participantes;

	@Temporal(TemporalType.DATE)
	private Date tiempoFin;

	@Temporal(TemporalType.DATE)
	private Date tiempoInicio;

	private String titulo;

	//bi-directional many-to-one association to Alerta
	@ManyToOne
	@JoinColumn(name="tipoAlerta")
	private Alerta alerta;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="departamento")
	private Departamento departamentoBean;

	//bi-directional many-to-one association to DocumentosEvento
	@ManyToOne
	@JoinColumn(name="documetos")
	private DocumentosEvento documentosEvento;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="creador")
	private Usuario usuario;

	//bi-directional many-to-many association to Departamento
	@ManyToMany
	@JoinTable(
		name="evento_departamento"
		, joinColumns={
			@JoinColumn(name="eventoID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="departamentoID")
			}
		)
	private Set<Departamento> departamentos;

	public Evento() {
	}

	public int getEventoID() {
		return this.eventoID;
	}

	public void setEventoID(int eventoID) {
		this.eventoID = eventoID;
	}

	public byte getCompletado() {
		return this.completado;
	}

	public void setCompletado(byte completado) {
		this.completado = completado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(String participantes) {
		this.participantes = participantes;
	}

	public Date getTiempoFin() {
		return this.tiempoFin;
	}

	public void setTiempoFin(Date tiempoFin) {
		this.tiempoFin = tiempoFin;
	}

	public Date getTiempoInicio() {
		return this.tiempoInicio;
	}

	public void setTiempoInicio(Date tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Alerta getAlerta() {
		return this.alerta;
	}

	public void setAlerta(Alerta alerta) {
		this.alerta = alerta;
	}

	public Departamento getDepartamentoBean() {
		return this.departamentoBean;
	}

	public void setDepartamentoBean(Departamento departamentoBean) {
		this.departamentoBean = departamentoBean;
	}

	public DocumentosEvento getDocumentosEvento() {
		return this.documentosEvento;
	}

	public void setDocumentosEvento(DocumentosEvento documentosEvento) {
		this.documentosEvento = documentosEvento;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Departamento> getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

}