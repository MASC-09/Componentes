package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Correos
 *
 */
@Entity
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String cronString;

    @OneToOne
    private Correo correo;

    public Job() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCronString() {
        return cronString;
    }

    public void setCronString(String cronString) {
        this.cronString = cronString;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }
}
