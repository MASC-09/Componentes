package tester;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import entidades.*;

public class tester {
	
	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager em = null; 	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            startEntityManagerFactory();

			// Create Componente

            Componente componente = new Componente();
            Set<Usuario> usuarios = new HashSet<>();

			for(int i=0; i<10;i++) {
				em.getTransaction().begin();
				Usuario user = new Usuario();
				user.setNombre("test"+ i);
				user.setContrasena("test"+ i);
				user.setCorreo("correo"+ i+"@email.com");
				em.persist(user);
				em.flush();
				em.getTransaction().commit();
				usuarios.add(user);
			}

			componente.setUsuarios(usuarios);
			Job job = new Job();

			em.getTransaction().begin();
			em.persist(componente);
			em.persist(job);
			em.flush();
            em.getTransaction().commit();

		}catch(Exception e) {
			e.printStackTrace();
			
		}
        finally {
			stopEntityManagerFactory();
		}

	}
	
	//Metodo que se encarga de crear la entidad.
	public static void startEntityManagerFactory() {
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence.createEntityManagerFactory("EmailComponente");
				em = entityManagerFactory.createEntityManager();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Metodo que se encarga de detener el entity manager
	public static void stopEntityManagerFactory() {
		if (entityManagerFactory != null) {
			if (entityManagerFactory.isOpen()) {
				try {
					entityManagerFactory.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			em.close();
			entityManagerFactory = null;
		}
	}

}
