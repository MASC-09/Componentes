package entidades;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Departamento
 * La identidad tiene los atributos: Id de tipo Int, nombreSistema de tipo String y Admin de tipo Int
 * 
 */
@Entity

public class Departamento implements Serializable {

	//En un componente pueden haber MUCHOS Correos
	//Un componente puede tener muchos usuarios
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDepartamento;
	private String nombreSistema;

	@OneToMany(mappedBy="correoID")
	private Set<Correo> correos;

	@OneToMany(mappedBy="idUsuario", cascade=CascadeType.ALL)
	private Set<Usuario> Usuarios;


	public Departamento() {
		super();
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombreSistema() {
		return nombreSistema;
	}

	public void setNombreSistema(String nombreSistema) {
		this.nombreSistema = nombreSistema;
	}

	public Set<Usuario> getUsuarios() {
		return Usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		Usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Usuarios == null) ? 0 : Usuarios.hashCode());
		result = prime * result + idDepartamento;
		result = prime * result + ((nombreSistema == null) ? 0 : nombreSistema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (Usuarios == null) {
			if (other.Usuarios != null)
				return false;
		} else if (!Usuarios.equals(other.Usuarios))
			return false;
		if (idDepartamento != other.idDepartamento)
			return false;
		if (nombreSistema == null) {
			if (other.nombreSistema != null)
				return false;
		} else if (!nombreSistema.equals(other.nombreSistema))
			return false;
		return true;
	}
	
	

}
