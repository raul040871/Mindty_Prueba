package com.mindty.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindty.modelos.Alumno;
import com.mindty.modelos.Curso;
import com.mindty.modelos.Modulo;
import com.mindty.modelos.Nota;
import com.mindty.modelos.Unidad;
import com.mindty.modelos.Usuario;

public class DemoDataEM extends EntityManager {
	
	private static DemoDataEM instance = null;

	public static final DemoDataEM getInstance() {
		if (instance == null)
			instance = new DemoDataEM();
		return instance;
	}

	protected DemoDataEM() {
	}
	
	public boolean updateDemoData() {
		boolean isOK = false;

		/* Creamos las lista de Unidades del M1C1*/
		List<Unidad> unidadesModulo1= new ArrayList<Unidad>();
		unidadesModulo1.add(new Unidad("Arquitectura de las aplicaciones web y tecnologías disponibles")); 
		unidadesModulo1.add(new Unidad("Gestión del software y de los proyectos de desarrollo"));
		unidadesModulo1.add(new Unidad("Fundamentos UX y de tecnologías frontend"));
		unidadesModulo1.add(new Unidad("Fundamentos de desarrollo orientado a objetos"));
		
		/* Creamos las lista de Unidades del M2C1*/
		List<Unidad> unidadesModulo2= new ArrayList<Unidad>();
		unidadesModulo2.add(new Unidad("Servidores de aplicación JEE"));
		unidadesModulo2.add(new Unidad("Aplicaciones web y MVC"));
		unidadesModulo2.add(new Unidad("Testing de aplicaciones y aseguramiento de calidad"));
		
		/* Creamos las lista de Unidades del M3C1*/
		List<Unidad> unidadesModulo3= new ArrayList<Unidad>();
		unidadesModulo3.add(new Unidad("Patrones de diseño y la capa de Business Logic"));
		unidadesModulo3.add(new Unidad("Aplicaciones basadas en JSF y Struts"));
		unidadesModulo3.add(new Unidad("Aplicaciones basadas en framework Spring"));
		unidadesModulo3.add(new Unidad("Persistencia basada en JPA e Hibernate"));
		
		/* Creamos las lista de Unidades del M1C2*/
		List<Unidad> unidadesModulo4= new ArrayList<Unidad>();
		unidadesModulo4.add(new Unidad("Crear una tabla e insertar datos"));
		unidadesModulo4.add(new Unidad("Consultar la tabla"));
		unidadesModulo4.add(new Unidad("Agregar datos"));
		
		/* Creamos las lista de Unidades del M2C2*/
		List<Unidad> unidadesModulo5= new ArrayList<Unidad>();
		unidadesModulo5.add(new Unidad("Consultas más complicadas"));
		unidadesModulo5.add(new Unidad("Restringir resultados"));
		unidadesModulo5.add(new Unidad("cálculo de resultados"));

		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/* Creamos el M1C1 */
		Modulo modulo1 = new Modulo();
		modulo1.setNombreModulo("Preparación previa");
		modulo1.setUnidad(unidadesModulo1);
		
		/* Creamos el M2C1 */
		Modulo modulo2 = new Modulo();
		modulo2.setNombreModulo("Implementación de aplicaciones web");
		modulo2.setUnidad(unidadesModulo2);
		
		/* Creamos el M3C1 */
		Modulo modulo3 = new Modulo();
		modulo3.setNombreModulo("Desarrollo avanzado");
		modulo3.setUnidad(unidadesModulo3);
		
		/* Listamos los Modulos con sus Unidades del curso 1 */
		List<Modulo> modulosCurso1 = new ArrayList<Modulo>();
		modulosCurso1.add(modulo1);
		modulosCurso1.add(modulo2);
		modulosCurso1.add(modulo3);
		
		
		
		
		
		/* Creamos el M1C2 */
		Modulo modulo4 = new Modulo();
		modulo4.setNombreModulo("Conceptos básicos de SQL");
		modulo4.setUnidad(unidadesModulo1);
		
		/* Creamos el M2C2 */
		Modulo modulo5 = new Modulo();
		modulo5.setNombreModulo("Consultas de SQL más avanzadas");
		modulo5.setUnidad(unidadesModulo2);		
		
		
		List<Modulo> modulosCurso2 = new ArrayList<Modulo>();
		modulosCurso2.add(modulo4);
		modulosCurso2.add(modulo5);
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/* Creación de los Alumnos */
		Alumno alumno1 = new Alumno();
		alumno1.setNombreUsuario("Héctor Torres");
		alumno1.setPassword("Password");
		alumno1.setEmail("ht@ht.com");
		alumno1.setTelefono("93-555-75-54");
		alumno1.setTipo(3);
		
		Alumno alumno2 = new Alumno();
		alumno2.setNombreUsuario("Ivan Synytsya");
		alumno2.setPassword("Password");
		alumno2.setEmail("is@is.com");
		alumno2.setTelefono("93-555-75-54");
		alumno2.setTipo(3);
		
		Alumno alumno3 = new Alumno();
		alumno3.setNombreUsuario("Youssef Ait");
		alumno3.setPassword("Password");
		alumno3.setEmail("ya@ya.com");
		alumno3.setTelefono("93-555-75-54");
		alumno3.setTipo(3);
		
		Alumno alumno4 = new Alumno();
		alumno4.setNombreUsuario("David Guarch");
		alumno4.setPassword("Password");
		alumno4.setEmail("dg@dg.com");
		alumno4.setTelefono("93-555-75-54");
		alumno4.setTipo(3);
		
		/* Creación de los Profesores */
		Usuario profe1 = new Usuario();
		profe1.setNombreUsuario("Ricardo Ahumada");
		profe1.setPassword("Password");
		profe1.setEmail("ra@ra.com");
		profe1.setTelefono("93-555-75-55");
		profe1.setTipo(2);
		
		Usuario profe2 = new Usuario();
		profe2.setNombreUsuario("Ángel M. Rayo");
		profe2.setPassword("Password");
		profe2.setEmail("am@am.com");
		profe2.setTelefono("93-555-75-55");
		profe2.setTipo(2);
		
		Usuario profe3 = new Usuario();
		profe3.setNombreUsuario("Silvia Perez");
		profe3.setPassword("Password");
		profe3.setEmail("sp@sp.com");
		profe3.setTelefono("93-555-75-55");
		profe3.setTipo(2);
		
		/* Creación del Coordinador */
		Usuario coordi1 = new Usuario();
		coordi1.setNombreUsuario("Aina Llorens");
		coordi1.setPassword("Password");
		coordi1.setEmail("al@al.com");
		coordi1.setTelefono("93-555-75-56");
		coordi1.setTipo(1);	
		
		
		/* Lista de usuarios para los cursos */
		List<Usuario> usuariosCurso1 = new ArrayList<Usuario>();
		usuariosCurso1.add(alumno1);
		usuariosCurso1.add(alumno2);
		usuariosCurso1.add(alumno3);
		
		List<Usuario> usuariosCurso2 = new ArrayList<Usuario>();
		usuariosCurso2.add(alumno4);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/* Creamos los Ccursos */
		Curso curs1 = new Curso();
		curs1.setCodCurso("WEB 65823");
		curs1.setNombreCurso("Desarrollo de aplicaciones con tecnologías web");
		curs1.setFormador(profe1);
		curs1.setAlumnos(usuariosCurso1);
		curs1.setHorasCurso(50);
		curs1.setModulo(modulosCurso1);
		
		Curso curs2 = new Curso();
		curs2.setCodCurso("UXP 12578");
		curs2.setNombreCurso("Introducción a SQL");
		curs2.setFormador(profe2);
		curs2.setAlumnos(usuariosCurso2);
		curs2.setHorasCurso(255);
		curs2.setModulo(modulosCurso2);
		
		/* Relacionamos Alumnos + Modulo + Nota */
		List<Nota> notasAlmuno1= new ArrayList<Nota>();
		notasAlmuno1.add(new Nota(alumno1,modulo1,5.5));
		notasAlmuno1.add(new Nota(alumno1,modulo2,6));
		
		List<Nota> notasAlmuno2= new ArrayList<Nota>();
		notasAlmuno2.add(new Nota(alumno2,modulo1,9.5));
		notasAlmuno2.add(new Nota(alumno2,modulo2,10));
		
		List<Nota> notasAlmuno3= new ArrayList<Nota>();
		notasAlmuno3.add(new Nota(alumno3,modulo1,8));
		notasAlmuno3.add(new Nota(alumno3,modulo2,8.5));
		
		List<Nota> notasAlmuno4= new ArrayList<Nota>();
		notasAlmuno4.add(new Nota(alumno3,modulo4,5));
		notasAlmuno4.add(new Nota(alumno3,modulo4,4.5));
		
		alumno1.setListaNota(notasAlmuno1);
		alumno2.setListaNota(notasAlmuno2);
		alumno3.setListaNota(notasAlmuno3);
		alumno4.setListaNota(notasAlmuno4);

		try {
		/* Hibernate */
			
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		session.save(alumno1);
		session.save(alumno2);
		session.save(alumno3);
		session.save(alumno4);
		session.save(profe1);
		session.save(profe2);
		session.save(profe3);
		session.save(coordi1);
		session.save(curs1);
		session.save(curs2);
		t.commit();
		session.close();
		/*Hibernate*/
		isOK = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isOK;
	}
}