package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int correoID;
	private Date date;


	@OneToOne
	private Usuario emisor;

	private String titulo;
	private String cuerpo;

    @ManyToOne
    @JoinColumn(name="idDepartamento")
    private Departamento depto;

	@OneToMany(mappedBy="adjunto", cascade = CascadeType.ALL)
	private Set<Adjunto> adjuntos;
	private boolean estado;

	public Correo() {
		super();
	}



	public int getCorreoID() {
		return correoID;
	}

	public void setCorreoID(int correoID) {
		this.correoID = correoID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Set<Adjunto> getAdjuntos() {
		return adjuntos;
	}

	public void setAdjuntos(Set<Adjunto> adjuntos) {
		this.adjuntos = adjuntos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}



    public Departamento getDepto() {
        return depto;
    }



    public void setDepto(Departamento depto) {
        this.depto = depto;
    }
}
