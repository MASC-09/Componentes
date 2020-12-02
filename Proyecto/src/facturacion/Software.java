package facturacion;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the software database table.
 * 
 */
@Entity
@NamedQuery(name="Software.findAll", query="SELECT s FROM Software s")
public class Software implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int softwareID;

	private String licencia;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoriaID")
	private Categoria categoria;

	public Software() {
	}

	public int getSoftwareID() {
		return this.softwareID;
	}

	public void setSoftwareID(int softwareID) {
		this.softwareID = softwareID;
	}

	public String getLicencia() {
		return this.licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}