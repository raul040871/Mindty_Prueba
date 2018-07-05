package com.mindty.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.mindty.modelos.Curso;
import com.mindty.modelos.Usuario;

public class CoordinadorEM extends EntityManager {

	private static CoordinadorEM instance = null;

	public static final CoordinadorEM getInstance() {
		if (instance == null)
			instance = new CoordinadorEM();
		return instance;
	}

	protected CoordinadorEM() {
		super();
	}

	public List<Usuario> getListaUsuario(int tipo) {
		List<Usuario> usuarios = null;
		try {
			/* Hibernate */

			Session session = factory.openSession();

			Transaction t = session.beginTransaction();

			usuarios = session.createQuery("FROM Usuario WHERE tipo=" + tipo, Usuario.class).getResultList();
			t.commit();
			session.close();
			/* Hibernate */
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public Usuario getProfe(int idU) {
		Usuario profe = new Usuario();
		try {
			/* Hibernate */

			Session session = factory.openSession();

			Transaction t = session.beginTransaction();
			profe = session.get(Usuario.class, idU);
			t.commit();
			session.close();
			/* Hibernate */
		} catch (Exception e) {
			e.printStackTrace();
		}

		return profe;

	}

	public Usuario getUsuarioPorId(int idu) {

		/* unCurso es el objeto importado de MySQL */
		Usuario unUsuario = new Usuario();

		/*
		 * elCurso es el objeto que configuramos a raiz de unCurso con los parametros
		 * que queremos
		 */
		Usuario elUsuario = new Usuario();

		/* Hibernate */
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("probando conexion");
		unUsuario = (Usuario) session.createQuery("FROM Usuario WHERE idu=:id", Usuario.class).setInteger("id", idu)
				.getSingleResult();
		tx.commit();
		session.close();

		/* Configuramos el objeto que retornamos con los parametros que nos interesa */
		elUsuario.setIdu(unUsuario.getIdu());
		elUsuario.setNombreUsuario(unUsuario.getNombreUsuario());
		elUsuario.setPassword(unUsuario.getPassword());
		elUsuario.setEmail(unUsuario.getEmail());
		elUsuario.setTelefono(unUsuario.getTelefono());
		elUsuario.setTipo(unUsuario.getTipo());

		return elUsuario;
	}

	public int inserta(Usuario nuevoUsuario) throws Exception {
		int idu = 0;

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		idu = (Integer) session.save(nuevoUsuario);

		t.commit();
		session.close();

		return idu;
	}

	public List<Usuario> getListaUsuario() {
		List<Usuario> usuarios = null;
		try {
			// /* Hibernate */
			//
			// Session session = factory.openSession();
			//
			// Transaction t = session.beginTransaction();
			//
			// usuarios = session.createQuery("FROM Usuario",
			// Usuario.class).getResultList();
			// t.commit();
			// session.close();
			// /* Hibernate */

			Session session = factory.openSession();
			Criteria cr = session.createCriteria(Usuario.class).setProjection(Projections.projectionList()
					.add(Projections.property("idu"), "idu").add(Projections.property("nombreUsuario"), "nombreUsuario")
					.add(Projections.property("password"), "password").add(Projections.property("email"), "email")
					.add(Projections.property("telefono"), "telefono").add(Projections.property("tipo"), "tipo"))
					.setResultTransformer(Transformers.aliasToBean(Usuario.class));
			List<Usuario> list = cr.list();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}
}