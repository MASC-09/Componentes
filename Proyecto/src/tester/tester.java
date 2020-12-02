package tester;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import correo.*;

public class tester {

    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager em = null;

    public static void main(String[] args) {
		// TODO Auto-generated method stub

        Set<Usuario> usuarios = new HashSet<Usuario>();
        Set<Adjunto> adjuntos = new HashSet<Adjunto>();
		try {
            startEntityManagerFactory();
            em.getTransaction().begin();

            System.out.println("Creando Departamento");

            Departamento dpto = new Departamento();
            

            dpto.setNombreSistema("Just whatever");
            System.out.println("==== Agregando usuarios ====");
            for (int i=0; i<10; i++) {
                Usuario user = new Usuario();
                user.setNombre("test");
                user.setContrasena("test");
                user.setCorreo("correo@email.com");
                usuarios.add(user);
                System.out.println("Usuario: "+ user.toString());
            }


            dpto.setUsuarios(usuarios);
			em.persist(dpto);
			em.flush();
			em.getTransaction().commit();

            System.out.println("Departamento: " + dpto.toString());


            System.out.println("CREANDO CORREO");
            em.getTransaction().begin();
            
            java.sql.Date date = new java.sql.Date((new java.util.Date()).getTime());

            Correo correo = new Correo();
            correo.setDate(date);
            correo.setEmisor(dpto.getUsuarios().iterator().next());
            correo.setDepto(dpto);
            correo.setCuerpo("Cuerpo");


            System.out.println("==== Creando Adjuntos ====");
            for (int i=0; i<10; i++) {
                Adjunto adjunto = new Adjunto();
                adjunto.setNombreAdjunto("test");
                System.out.println("Adjunto: "+ adjunto.toString());
                adjuntos.add(adjunto);
            }
            correo.setAdjuntos(adjuntos);

			em.persist(correo);
			em.flush();
			em.getTransaction().commit();

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
