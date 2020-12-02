package facturacion;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the individuo database table.
 * 
 */
@Entity
@NamedQuery(name="Individuo.findAll", query="SELECT i FROM Individuo i")
public class Individuo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int individuoID;

	private String numeroLic;

	//bi-directional many-to-one association to Tipocliente
	@ManyToOne
	@JoinColumn(name="tipoClienteID")
	private Tipocliente tipocliente;

	public Individuo() {
	}

	public int getIndividuoID() {
		return this.individuoID;
	}

	public void setIndividuoID(int individuoID) {
		this.individuoID = individuoID;
	}

	public String getNumeroLic() {
		return this.numeroLic;
	}

	public void setNumeroLic(String numeroLic) {
		this.numeroLic = numeroLic;
	}

	public Tipocliente getTipocliente() {
		return this.tipocliente;
	}

	public void setTipocliente(Tipocliente tipocliente) {
		this.tipocliente = tipocliente;
	}

}