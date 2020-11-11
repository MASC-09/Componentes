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

}
