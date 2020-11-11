package tester;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.*;

public class tester {
	
	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager em = null; 	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            startEntityManagerFactory();

            Correo co = new Correo();
            Usuario usuario = new Usuario();
            String titulo = "Correo de Prueba";
            String cuerpo = "Este corre o tiene como proposito hacer una prueba de las entidades";
            List<Adjunto> listaAdjuntos = new ArrayList();
            //listaAdjuntos.add();
            //listaAdjuntos.add(2);
            //listaAdjuntos.add(3);
            //listaAdjuntos.add(4);
            
            //List<String> receptores = Usuario.all();
            //receptores.add("hola@gmail.com");
            //receptores.add("donare_es_facil@gamil.com");
            //receptores.add("blueCore0220@gamil.com");
            
            //co.setCorreoID();
            //co.setEmisor(usuario);
            //co.setTitulo(titulo);
            //co.setCuerpo(cuerpo);
            //co.setAdjuntos(listaAdjuntos);
            //co.setEstado(false);
            //co.setComponente(new Integer("4"));
            //co.setReceptores(receptores);	
		
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
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
