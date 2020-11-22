package tester;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.*;

public class tester {

    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager em = null;

    public static void main(String[] args) {
		// TODO Auto-generated method stub

        Set<Usuario> usuarios = new HashSet<Usuario>();
		try {
            startEntityManagerFactory();
            em.getTransaction().begin();
            Departamento dpto = new Departamento();
            dpto.setNombreSistema("Just whatever");

            for (int i=0; i<10; i++) {
                Usuario user = new Usuario();
                user.setNombre("test");
                user.setContrasena("test");
                user.setCorreo("correo@email.com");
                usuarios.add(user);
            }
            dpto.setUsuarios(usuarios);

			em.persist(dpto);
			em.flush();
			em.getTransaction().commit();

            System.out.println(dpto);


		} catch(Exception e) {
			e.printStackTrace();
			
		}
        finally {
			stopEntityManagerFactory();
		}

	}

    // Metodo que se encarga de crear la entidad.
    public static void startEntityManagerFactory() {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("EmailComponente");
                em = entityManagerFactory.createEntityManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo que se encarga de detener el entity manager
    public static void stopEntityManagerFactory() {
        if (entityManagerFactory != null) {
            if (entityManagerFactory.isOpen()) {
                try {
                    entityManagerFactory.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            em.close();
            entityManagerFactory = null;
        }
    }

}
