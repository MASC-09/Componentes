package facturacion;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the manual database table.
 * 
 */
@Entity
@NamedQuery(name="Manual.findAll", query="SELECT m FROM Manual m")
public class Manual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int manualID;

	private String autor;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoriaID")
	private Categoria categoria;

	public Manual() {
	}

	public int getManualID() {
		return this.manualID;
	}

	public void setManualID(int manualID) {
		this.manualID = manualID;
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