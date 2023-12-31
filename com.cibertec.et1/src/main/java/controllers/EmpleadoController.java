package controllers;
//Importando las clases necesarias de Hibernate
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Importando el modelo de Empleados
import models.Empleado;

public class EmpleadoController {
	
public String createEmpleado(String apellido ,String nombre,int edad,String sexo,double salario) {
		
		// Creando una instancia de SessionFactory de Hibernate
		SessionFactory sessionFactory ;
		
		// Configurando la SessionFactory con el archivo de configuración de Hibernate y añadiendo la clase anotada Empleado
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session;
		// Abriendo una nueva sesión de Hibernate
		session = sessionFactory.openSession();
		
		try {
			// Creando una nueva instancia del modelo Empleado
			Empleado empleado;
			empleado = new Empleado(apellido,nombre,edad,sexo,salario);
			
			// Iniciando una nueva transacción en la sesión de Hibernate
			session.beginTransaction();
			
			// Guardando el nuevo Empleado en la base de datos
			session.save(empleado);
			
			// Confirmando y finalizando la transacción en la base de datos
			session.getTransaction().commit();
			
			// Cerrando la SessionFactory para liberar recursos
			sessionFactory.close();
			
			return "Empleado Creado";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al crear Empleado "+e.getMessage();
		}
	}
	
public String deleteEmpleado(int idEmpleado) {
	SessionFactory sessionFactory;
	sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
	
	Session session;
	session = sessionFactory.openSession();
	
	try {
		session.beginTransaction();
		Empleado empleado = session.get(Empleado.class, idEmpleado);
		session.delete(empleado);
		session.getTransaction().commit();
		sessionFactory.close();
		return "Empleado eliminado correctamente";
	} catch (Exception e) {
		e.printStackTrace();
		return "Error al eliminar Empleado "+e.getMessage();
	}
}

public String updateEmpleado(int idEmpleado, String apellidos) {
	SessionFactory sessionFactory;
	sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
	
	Session session;
	session = sessionFactory.openSession();
	
	try {
		session.beginTransaction();
		
		Empleado empleado = session.get(Empleado.class,idEmpleado);
		empleado.setApellidos(apellidos);
		session.update(empleado);
		
		session.getTransaction().commit();
		sessionFactory.close();
		
		sessionFactory.close();
		return "Empleado actualizado correctamente";
	}catch (Exception e) {
		e.printStackTrace();
		return "Error al actualizar Empleado "+e.getMessage();
	}
}
	
	public String getEmpleado(int idEmpleado) {
		SessionFactory sessionFactory ;
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session;
		session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idEmpleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return empleado.toString();
		}catch (Exception e) {
			e.printStackTrace();
			return "Empleado no existe " + e.getMessage(); 
		
	}
	
}

}
