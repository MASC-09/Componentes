package facturacion;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hardware database table.
 * 
 */
@Entity
@NamedQuery(name="Hardware.findAll", query="SELECT h FROM Hardware h")
public class Hardware implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int hardwareID;

	private String autor;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoriaID")
	private Categoria categoria;

	public Hardware() {
	}

	public int getHardwareID() {
		return this.hardwareID;
	}

	public void setHardwareID(int hardwareID) {
		this.hardwareID = hardwareID;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}