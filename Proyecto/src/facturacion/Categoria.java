package facturacion;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int categoriaID;

	private String descripcion;

	private String nombreCategoria;

	//bi-directional many-to-one association to Hardware
	@OneToMany(mappedBy="categoria")
	private Set<Hardware> hardwares;

	//bi-directional many-to-one association to Manual
	@OneToMany(mappedBy="categoria")
	private Set<Manual> manuals;

	//bi-directional many-to-many association to Producto
	@ManyToMany(mappedBy="categorias")
	private Set<Producto> productos;

	//bi-directional many-to-one association to Software
	@OneToMany(mappedBy="categoria")
	private Set<Software> softwares;

	public Categoria() {
	}

	public int getCategoriaID() {
		return this.categoriaID;
	}

	public void setCategoriaID(int categoriaID) {
		this.categoriaID = categoriaID;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Set<Hardware> getHardwares() {
		return this.hardwares;
	}

	public void setHardwares(Set<Hardware> hardwares) {
		this.hardwares = hardwares;
	}

	public Hardware addHardware(Hardware hardware) {
		getHardwares().add(hardware);
		hardware.setCategoria(this);

		return hardware;
	}

	public Hardware removeHardware(Hardware hardware) {
		getHardwares().remove(hardware);
		hardware.setCategoria(null);

		return hardware;
	}

	public Set<Manual> getManuals() {
		return this.manuals;
	}

	public void setManuals(Set<Manual> manuals) {
		this.manuals = manuals;
	}

	public Manual addManual(Manual manual) {
		getManuals().add(manual);
		manual.setCategoria(this);

		return manual;
	}

	public Manual removeManual(Manual manual) {
		getManuals().remove(manual);
		manual.setCategoria(null);

		return manual;
	}

	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Set<Software> getSoftwares() {
		return this.softwares;
	}

	public void setSoftwares(Set<Software> softwares) {
		this.softwares = softwares;
	}

	public Software addSoftware(Software software) {
		getSoftwares().add(software);
		software.setCategoria(this);

		return software;
	}

	public Software removeSoftware(Software software) {
		getSoftwares().remove(software);
		software.setCategoria(null);

		return software;
	}

}