package facturacion;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int productoID;

	private String descripcion;

	private String nombre;

	private double precioPorMenor;

	//bi-directional many-to-one association to Itemorden
	@OneToMany(mappedBy="producto")
	private Set<Itemorden> itemordens;

	//bi-directional many-to-many association to Categoria
	@ManyToMany
	@JoinTable(
		name="producto_categoria"
		, joinColumns={
			@JoinColumn(name="productoID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="categoriaID")
			}
		)
	private Set<Categoria> categorias;

	public Producto() {
	}

	public int getProductoID() {
		return this.productoID;
	}

	public void setProductoID(int productoID) {
		this.productoID = productoID;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioPorMenor() {
		return this.precioPorMenor;
	}

	public void setPrecioPorMenor(double precioPorMenor) {
		this.precioPorMenor = precioPorMenor;
	}

	public Set<Itemorden> getItemordens() {
		return this.itemordens;
	}

	public void setItemordens(Set<Itemorden> itemordens) {
		this.itemordens = itemordens;
	}

	public Itemorden addItemorden(Itemorden itemorden) {
		getItemordens().add(itemorden);
		itemorden.setProducto(this);

		return itemorden;
	}

	public Itemorden removeItemorden(Itemorden itemorden) {
		getItemordens().remove(itemorden);
		itemorden.setProducto(null);

		return itemorden;
	}

	public Set<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

}