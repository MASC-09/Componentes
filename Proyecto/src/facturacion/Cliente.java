package facturacion;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int clienteID;

	private String direccion;

	private String nombre;

	private String telefono;

	//bi-directional many-to-many association to Tipocliente
	@ManyToMany
	@JoinTable(
		name="cliente_tipocliente"
		, joinColumns={
			@JoinColumn(name="clienteID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="tipoClienteID")
			}
		)
	private Set<Tipocliente> tipoclientes;

	//bi-directional many-to-one association to Orden
	@OneToMany(mappedBy="cliente")
	private Set<Orden> ordens;

	public Cliente() {
	}

	public int getClienteID() {
		return this.clienteID;
	}

	public void setClienteID(int clienteID) {
		this.clienteID = clienteID;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Tipocliente> getTipoclientes() {
		return this.tipoclientes;
	}

	public void setTipoclientes(Set<Tipocliente> tipoclientes) {
		this.tipoclientes = tipoclientes;
	}

	public Set<Orden> getOrdens() {
		return this.ordens;
	}

	public void setOrdens(Set<Orden> ordens) {
		this.ordens = ordens;
	}

	public Orden addOrden(Orden orden) {
		getOrdens().add(orden);
		orden.setCliente(this);

		return orden;
	}

	public Orden removeOrden(Orden orden) {
		getOrdens().remove(orden);
		orden.setCliente(null);

		return orden;
	}

}