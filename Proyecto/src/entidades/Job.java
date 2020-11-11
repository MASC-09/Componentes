package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import entidades.Correo;

/**
 * Entity implementation class for Entity: Correos
 *
 */
@Entity
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private Date now;
    private Date next_run;
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

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Date getNext_run() {
        return next_run;
    }

    public void setNext_run(Date next_run) {
        this.next_run = next_run;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }
}
