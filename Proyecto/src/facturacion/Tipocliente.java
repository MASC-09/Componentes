package facturacion;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipocliente database table.
 * 
 */
@Entity
@NamedQuery(name="Tipocliente.findAll", query="SELECT t FROM Tipocliente t")
public class Tipocliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int tipoClienteID;

	private String descripcion;

	private String nombreTipoCliente;

	//bi-directional many-to-many association to Cliente
	@ManyToMany(mappedBy="tipoclientes")
	private Set<Cliente> clientes;

	//bi-directional many-to-one association to Compania
	@OneToMany(mappedBy="tipocliente")
	private Set<Compania> companias;

	//bi-directional many-to-one association to Individuo
	@OneToMany(mappedBy="tipocliente")
	private Set<Individuo> individuos;

	public Tipocliente() {
	}

	public int getTipoClienteID() {
		return this.tipoClienteID;
	}

	public void setTipoClienteID(int tipoClienteID) {
		this.tipoClienteID = tipoClienteID;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreTipoCliente() {
		return this.nombreTipoCliente;
	}

	public void setNombreTipoCliente(String nombreTipoCliente) {
		this.nombreTipoCliente = nombreTipoCliente;
	}

	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Set<Compania> getCompanias() {
		return this.companias;
	}

	public void setCompanias(Set<Compania> companias) {
		this.companias = companias;
	}

	public Compania addCompania(Compania compania) {
		getCompanias().add(compania);
		compania.setTipocliente(this);

		return compania;
	}

	public Compania removeCompania(Compania compania) {
		getCompanias().remove(compania);
		compania.setTipocliente(null);

		return compania;
	}

	public Set<Individuo> getIndividuos() {
		return this.individuos;
	}

	public void setIndividuos(Set<Individuo> individuos) {
		this.individuos = individuos;
	}

	public Individuo addIndividuo(Individuo individuo) {
		getIndividuos().add(individuo);
		individuo.setTipocliente(this);

		return individuo;
	}

	public Individuo removeIndividuo(Individuo individuo) {
		getIndividuos().remove(individuo);
		individuo.setTipocliente(null);

		return individuo;
	}

}