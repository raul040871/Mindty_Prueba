package com.mindty.persistence;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.mindty.modelos.Curso;
import com.mindty.modelos.Usuario;

public class CursoEM extends EntityManager {

	private static CursoEM instance = null;

	public static final CursoEM getInstance() {
		if (instance == null)
			instance = new CursoEM();
		return instance;
	}

	public List<Curso> getListaCursos() {
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Curso.class).setProjection(Projections.projectionList()
				.add(Projections.property("idCurso"), "idCurso").add(Projections.property("nombreCurso"), "nombreCurso")
				.add(Projections.property("codCurso"), "codCurso").add(Projections.property("horasCurso"), "horasCurso")
				.add(Projections.property("formador"), "formador"))
				.setResultTransformer(Transformers.aliasToBean(Curso.class));
		List<Curso> list = cr.list();
		session.close();
		return list;
	}

	public Curso getCurso(int idc) {

		/* unCurso es el objeto importado de MySQL */
		Curso unCurso = new Curso();

		/*
		 * elCurso es el objeto que configuramos a raiz de unCurso con los parametros
		 * que queremos
		 */
		Curso elCurso = new Curso();

		/* Hibernate */
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("probando conexión");
		unCurso = (Curso) session.createQuery("FROM Curso WHERE idCurso=:id", Curso.class).setInteger("id", idc)
				.getSingleResult();
		tx.commit();
		session.close();

		/* Configuramos el objeto que retornamos con los paranmetros */
		elCurso.setIdCurso(unCurso.getIdCurso());
		elCurso.setNombreCurso(unCurso.getNombreCurso());
		elCurso.setCodCurso(unCurso.getCodCurso());
		elCurso.setHorasCurso(unCurso.getHorasCurso());
		elCurso.setFormador(unCurso.getFormador());

		return elCurso;
	}

	public int addCurso(Curso nuevoCurso) {
		int newId = 0;
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		newId = (Integer) session.save(nuevoCurso);

		t.commit();
		session.close();

		return newId;
	}
}
