package facturacion;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the compania database table.
 * 
 */
@Entity
@NamedQuery(name="Compania.findAll", query="SELECT c FROM Compania c")
public class Compania implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int companiaID;

	private String contacto;

	private int descuente;

	//bi-directional many-to-one association to Tipocliente
	@ManyToOne
	@JoinColumn(name="tipoClienteID")
	private Tipocliente tipocliente;

	public Compania() {
	}

	public int getCompaniaID() {
		return this.companiaID;
	}

	public void setCompaniaID(int companiaID) {
		this.companiaID = companiaID;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public int getDescuente() {
		return this.descuente;
	}

	public void setDescuente(int descuente) {
		this.descuente = descuente;
	}

	public Tipocliente getTipocliente() {
		return this.tipocliente;
	}

	public void setTipocliente(Tipocliente tipocliente) {
		this.tipocliente = tipocliente;
	}

}