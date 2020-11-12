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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + id;
		result = prime * result + ((next_run == null) ? 0 : next_run.hashCode());
		result = prime * result + ((now == null) ? 0 : now.hashCode());
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
		Job other = (Job) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (id != other.id)
			return false;
		if (next_run == null) {
			if (other.next_run != null)
				return false;
		} else if (!next_run.equals(other.next_run))
			return false;
		if (now == null) {
			if (other.now != null)
				return false;
		} else if (!now.equals(other.now))
			return false;
		return true;
	}
    
    
}
