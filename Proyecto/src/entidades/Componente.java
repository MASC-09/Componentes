package entidades;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Componente
 * La identidad tiene los atributos: Id de tipo Int, nombreSistema de tipo String y Admin de tipo Int
 * 
 */
@Entity

public class Componente implements Serializable {

	//En un componente pueden haber MUCHOS Correos
	//Un componente puede tener muchos usuarios
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToMany(mappedBy="Correo")
	private int id;
	private String nombreSistema;
	@OneToMany(mappedBy="Componente", cascade = CascadeType.ALL)
	private List<Usuario> Usuarios;

	public Componente() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreSistema() {
		return nombreSistema;
	}

	public void setNombreSistema(String nombreSistema) {
		this.nombreSistema = nombreSistema;
	}

	public List<Usuario> getUsuarios() {
		return Usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		Usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Usuarios == null) ? 0 : Usuarios.hashCode());
		result = prime * result + id;
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
		Componente other = (Componente) obj;
		if (Usuarios == null) {
			if (other.Usuarios != null)
				return false;
		} else if (!Usuarios.equals(other.Usuarios))
			return false;
		if (id != other.id)
			return false;
		if (nombreSistema == null) {
			if (other.nombreSistema != null)
				return false;
		} else if (!nombreSistema.equals(other.nombreSistema))
			return false;
		return true;
	}
	
	

}
