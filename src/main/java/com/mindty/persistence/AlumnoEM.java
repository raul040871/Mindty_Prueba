package com.mindty.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindty.modelos.Curso;
import com.mindty.modelos.Modulo;
import com.mindty.modelos.Unidad;
import com.mindty.modelos.Usuario;

public class AlumnoEM extends EntityManager {

	private static AlumnoEM instance = null;

	public static final AlumnoEM getInstance() {
		if (instance == null)
			instance = new AlumnoEM();
		return instance;
	}

	protected AlumnoEM() {
		super();
	}
	/* Hibernate */
	

	/*localizando el usuaruio alumno conectado*/
	public Modulo getUnidades(int nIdModulo) {
		Modulo unModulo = new Modulo();
		
		try {
			/* Hibernate */
			System.out.println("Hola");
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();

			unModulo = session.createQuery("FROM Modulo WHERE idm:idModulo", Modulo.class)
					.setParameter("idModulo", nIdModulo).getSingleResult();
			
			t.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return unModulo;
	}
	public List<Curso> getUsuarioAlumnoCurso(int user) {
		
		List<Curso> listaCursoAlumno = new ArrayList<Curso>();

		int nId = 0;
		try {
			/* Hibernate */

			Session session = factory.openSession();

			Transaction t = session.beginTransaction();
			listaCursoAlumno = (List<Curso>) session.createQuery("FROM curso WHERE curso.idCurso = :uid")/*consigo el curso del alumno*/
					.setInteger("uid", user).getResultList();
//			"SELECT E.firstName FROM Employee E"
//			"SELECT U.nombreUsuario FROM usuario U = :uid\"
//			"from usuario WHERE idu = :uid"

			t.commit();
			session.close();
			/* Hibernate */
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaCursoAlumno;
	}
	
//	int userCurso = 0 ;


public List<Modulo> getAlumnoModulos(int userCurso)/*recoger id del curso*/ {
	
	List<Modulo> listaModuloAlumno = new ArrayList<Modulo>();

	int nId = 0;
	try {
		/* Hibernate */

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		listaModuloAlumno = (List<Modulo>) session.createQuery("from modulo WHERE modulo.idm = :mid")/*consigo los modulos del alumno*/
				.setInteger("mid", userCurso).getResultList();

		t.commit();
		session.close();
		/* Hibernate */
	} catch (Exception e) {
		e.printStackTrace();
	}

	return listaModuloAlumno;
}

//int userModulo =0;

public List<Unidad> getAlumnoUnidades(int userModulo)/*recoger id del modulo*/ {
	
	List<Unidad> listaUnidadAlumno = new ArrayList<Unidad>();

	int nId = 0;
	try {
		/* Hibernate */

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		listaUnidadAlumno = (List<Unidad>) session.createQuery("from unidad WHERE unidad.idUni = :unid")/*consigo las unidades del alumno*/
				.setInteger("unid", userModulo).getResultList();

		t.commit();
		session.close();
		/* Hibernate */
	} catch (Exception e) {
		e.printStackTrace();
	}

	return listaUnidadAlumno;
}
}
	
//	/*
//	 * cogiendo los curosso de un usuario alumno en concreto 
//	 */
//	public int getListaCursosAlumno(int user) {
//		int nombreCursoAlumno = 0;
//		try {
//			/* Hibernate */
//
//			Session session = factory.openSession();
//
//			Transaction t = session.beginTransaction();
//			// usuarios = session.createQuery("FROM usuario",
//			// Usuario.class).getResultList();
//			Usuario usr = (Usuario) session.createQuery("FROM curso_alumno us WHERE us.idAlumno = :idCurso")
//					.setString(user, "idCurso").uniqueResult();
//
//			nombreCursoAlumno = usr.getIdu();
//
//			t.commit();
//			session.close();
//			/* Hibernate */
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return nombreCursoAlumno;
//	}
//}
///*
// lista de modulos
// */
//public int getListamodulosAlumno(int user) {
//	int nombreCursoAlumno = 0;
//	try {
//		/* Hibernate */
//
//		Session session = factory.openSession();
//
//		Transaction t = session.beginTransaction();
//		// usuarios = session.createQuery("FROM usuario",
//		// Usuario.class).getResultList();
//		Usuario usr = (Usuario) session.createQuery("FROM curso_alumno us WHERE us.idAlumno = :idCurso")
//				.setString(user, "idCurso").uniqueResult();
//
//		nombreCursoAlumno = usr.getIdu();
//
//		t.commit();
//		session.close();
//		/* Hibernate */
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//
//	return nombreCursoAlumno;
//}
///*
//lista de unidades
//*/
//public int getListaunidadesAlumno(int user) {
//	int nombreCursoAlumno = 0;
//	try {
//		/* Hibernate */
//
//		Session session = factory.openSession();
//
//		Transaction t = session.beginTransaction();
//		// usuarios = session.createQuery("FROM usuario",
//		// Usuario.class).getResultList();
//		Usuario usr = (Usuario) session.createQuery("FROM curso_alumno us WHERE us.idAlumno = :idCurso")
//				.setString(user, "idCurso").uniqueResult();
//
//		nombreCursoAlumno = usr.getIdu();
//
//		t.commit();
//		session.close();
//		/* Hibernate */
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//
//	return nombreCursoAlumno;
//}
//}
//
//
//// public List<Usuario> getListaCursoAlumno(int iduH) {
//// List<Usuario> Cursos = null;
//// try {
//// Session session = factory.openSession();
//// Transaction t = session.beginTransaction();
////
////
////
//// Cursos = session.createQuery("SELECT idCurso FROM `curso_alumno` WHERE
//// idAlumno= ", Usuario.class).getResultList();
////
//// t.commit();
//// session.close();
//// /* Hibernate */
//// } catch (Exception e) {
//// e.printStackTrace();
//// }
////
//// return Cursos;