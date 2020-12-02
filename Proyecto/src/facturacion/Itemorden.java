package facturacion;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the itemorden database table.
 * 
 */
@Entity
@NamedQuery(name="Itemorden.findAll", query="SELECT i FROM Itemorden i")
public class Itemorden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int itemOrdenID;

	private int cantidad;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="productoID")
	private Producto producto;

	//bi-directional many-to-one association to Orden
	@OneToMany(mappedBy="itemorden")
	private Set<Orden> ordens;

	public Itemorden() {
	}

	public int getItemOrdenID() {
		return this.itemOrdenID;
	}

	public void setItemOrdenID(int itemOrdenID) {
		this.itemOrdenID = itemOrdenID;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Set<Orden> getOrdens() {
		return this.ordens;
	}

	public void setOrdens(Set<Orden> ordens) {
		this.ordens = ordens;
	}

	public Orden addOrden(Orden orden) {
		getOrdens().add(orden);
		orden.setItemorden(this);

		return orden;
	}

	public Orden removeOrden(Orden orden) {
		getOrdens().remove(orden);
		orden.setItemorden(null);

		return orden;
	}

}