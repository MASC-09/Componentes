package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.Set;

/**
 * Entity implementation class for Entity: Evento
 *
 */
@Entity
//@Table(name="Evento")
public class Evento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int eventoID; 
	
	private LocalDateTime tiempoInicio;
    private LocalDateTime tiempoFin;
    
    @OneToOne
    private Usuario creador;
    
    private String titulo;
	private String descripcion;

    //ManyToMany?
    @ManyToOne
    @JoinColumn(name="idDepartamento")
    private Departamento depto;
    
    @JoinTable(name = "Evento_Departamento", 
    		   joinColumns = { @JoinColumn(name = "idEvento") }, 
    		   inverseJoinColumns = { @JoinColumn(name = "idDepartamento") })
    		private Set<Departamento> departamentos;
    

	@OneToMany(mappedBy="adjunto", cascade = CascadeType.ALL)
    private Set<Adjunto> adjuntos;
    
    private boolean completado;
    private ArrayList<String> participantes;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="alertaID")
    private Alerta tipoAlerta;
	
	public Evento() {
		super();
	}

	public int getEventoID() {
		return eventoID;
	}

	public void setEventoID(int eventoID) {
		this.eventoID = eventoID;
	}

	public LocalDateTime getTiempoInicio() {
		return tiempoInicio;
	}

	public void setTiempoInicio(LocalDateTime tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}

	public LocalDateTime getTiempoFin() {
		return tiempoFin;
	}

	public void setTiempoFin(LocalDateTime tiempoFin) {
		this.tiempoFin = tiempoFin;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Departamento getDepto() {
		return depto;
	}

	public void setDepto(Departamento depto) {
		this.depto = depto;
	}

	public Set<Adjunto> getAdjuntos() {
		return adjuntos;
	}

	public void setAdjuntos(Set<Adjunto> adjuntos) {
		this.adjuntos = adjuntos;
	}

	public boolean isCompletado() {
		return completado;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	public ArrayList<String> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<String> participantes) {
		this.participantes = participantes;
	}

	public Alerta getTipoAlerta() {
		return tipoAlerta;
	}

	public void setTipoAlerta(Alerta tipoAlerta) {
		this.tipoAlerta = tipoAlerta;
	}
	
	
	
	
   
}
