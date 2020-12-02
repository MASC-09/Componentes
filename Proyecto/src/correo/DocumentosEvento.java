package correo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the documentos_evento database table.
 * 
 */
@Entity
@Table(name="documentos_evento")
@NamedQuery(name="DocumentosEvento.findAll", query="SELECT d FROM DocumentosEvento d")
public class DocumentosEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int grupoID;

	//bi-directional many-to-one association to Adjunto
	@ManyToOne
	@JoinColumn(name="adjuntoID")
	private Adjunto adjunto;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="documentosEvento")
	private Set<Evento> eventos;

	public DocumentosEvento() {
	}

	public int getGrupoID() {
		return this.grupoID;
	}

	public void setGrupoID(int grupoID) {
		this.grupoID = grupoID;
	}

	public Adjunto getAdjunto() {
		return this.adjunto;
	}

	public void setAdjunto(Adjunto adjunto) {
		this.adjunto = adjunto;
	}

	public Set<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setDocumentosEvento(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setDocumentosEvento(null);

		return evento;
	}

}