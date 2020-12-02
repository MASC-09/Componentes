package facturacion;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the orden database table.
 * 
 */
@Entity
@NamedQuery(name="Orden.findAll", query="SELECT o FROM Orden o")
public class Orden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int ordenID;

	@Temporal(TemporalType.DATE)
	private Date fechaOrden;

	private double totalOrden;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="clienteID")
	private Cliente cliente;

	//bi-directional many-to-one association to Itemorden
	@ManyToOne
	@JoinColumn(name="itemOrdenID")
	private Itemorden itemorden;

	public Orden() {
	}

	public int getOrdenID() {
		return this.ordenID;
	}

	public void setOrdenID(int ordenID) {
		this.ordenID = ordenID;
	}

	public Date getFechaOrden() {
		return this.fechaOrden;
	}

	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public double getTotalOrden() {
		return this.totalOrden;
	}

	public void setTotalOrden(double totalOrden) {
		this.totalOrden = totalOrden;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Itemorden getItemorden() {
		return this.itemorden;
	}

	public void setItemorden(Itemorden itemorden) {
		this.itemorden = itemorden;
	}

}