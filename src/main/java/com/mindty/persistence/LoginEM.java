package com.mindty.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.Transaction;
import com.mindty.modelos.Usuario;

public class LoginEM extends EntityManager {
	private static LoginEM instance = null;

	public static final LoginEM getInstance() {
		if (instance == null)
			instance = new LoginEM();
		return instance;
	}

	protected LoginEM() {

	}

	public Usuario login(String usuario, String contrasena) {

		Usuario us = new Usuario();
		;
		Session session = null;
		try {
			session = factory.openSession();
			Transaction tx = session.beginTransaction();
			System.out.println("probando conexión");
			us = (Usuario) session
					.createQuery("FROM Usuario WHERE nombreUsuario=:usuario AND password=:contra",
							Usuario.class)
					.setString("usuario", usuario).setString("contra", contrasena).getSingleResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("us Nombre: " + us.getNombreUsuario());
		System.out.println("us Password: " + us.getPassword());
		return us;
	}
}