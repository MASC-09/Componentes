package entidades;
/**
 * Entity implementation class for Entity: Adjunto
 *
 */
@Entity

public class Adjunto implements Serializable {

	@Id
	private int id;
	
    @ManyToOne
	@JoinColumn(name = "idCorreo")	
	private Correo correo;
	
	private Stream adjunto;
	private static final long serialVersionUID = 1L;

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
   
	
	
}
