package correo;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TesterEntidad {
	
	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager em = null; 	

	public static void main(String[] args) {

		try {
			startEntityManagerFactory();
			Departamento Consultoria = new Departamento();
			Consultoria.setNombreSistema("Consultoria en Teconolog�as Emergentes");
			
			Set<Departamento> deptos = new HashSet<Departamento>();
			
			Usuario u = new Usuario();
			u.setCorreo("msoto095@gmial.com");
			u.setContrasena("1234");
			u.setDepartamento(Consultoria);
			
			deptos.add(Consultoria);
			
//			ArrayList<String> invitados = new ArrayList();
//			invitados.add("hola@gmail.com");
//			
//			Evento event = new Evento();
//			event.set(u);
//			event.setTitulo("Dia de Accion de Gracias");
//			event.setDescripcion("Realizacion de comida con el fin de celebrar el dia de Accion de gracias! Yay nos cagamos ne los indios");
//			event.setCompletado(false);
//			event.setDeptos(deptos);
//			event.setParticipantes(invitados);
//			
//			event.setTiempoInicio(LocalDateTime.of(2020, Month.NOVEMBER, 27, 18, 30));
//			event.setTiempoFin(LocalDateTime.of(2020, Month.NOVEMBER, 27, 18, 30));
//			
//			Alerta alerta = new Alerta();
//			alerta.setEvento(event);
//			alerta.setFechaFinal(event.getTiempoInicio());
//			alerta.setNombreAlerta("Una vez a la semana");
//			alerta.setIntervalo(7);
//			alerta.setFechaProx(alerta.getFechaFinal().minusDays(Long.valueOf(alerta.getIntervalo())));
//			
//			Set<Usuario> miembros = new HashSet<Usuario>();
//			miembros.add(u);
//			
//			event.setTipoAlerta(alerta);
//			Consultoria.setUsuarios(miembros);
//			
//					
//			
//			Estudiante est = new Estudiante();
//			est.setId(new Integer("2"));
//			est.setNombre("Bernal");
//	
//			Curso curso = new Curso();
//			curso.setIdCurso(new Integer("2"));
//			curso.setNombre("Matematica");
//			
//			est.setCursos(new HashSet<Curso>());
////			est.getCursos().add(curso);
//		
//			em.getTransaction().begin();
//			em.persist(event);
//			em.persist(u);
//			em.persist(Consultoria);
//			em.persist(alerta);
//			em.getTransaction().commit();
//			System.out.println("********************************");
			
			stopEntityManagerFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void startEntityManagerFactory() {
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence
						.createEntityManagerFactory("EmailComponente");
				em = entityManagerFactory.createEntityManager();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
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
