
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import entidades.Correos;

/**
 * Entity implementation class for Entity: Correos
 *
 */
@Entity
public class Job implements Serializable {

  @Id
  private int id;
  private Date now;
  private Date next_run;
  private Correos correo;

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

    public Correos getCorreo() {
        return correo;
    }

    public void setCorreo(Correos correo) {
        this.correo = correo;
    }
}
