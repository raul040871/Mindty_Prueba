package com.mindty.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mindty.modelos.Usuario;
import com.mindty.persistence.LoginEM;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Se inicia sesión */
		HttpSession session = request.getSession();

		if (session.getAttribute("usuario") != null) {
			/* Si existe el usuario se llama al servlet logout para cerrar sesión */
			request.getSession().invalidate();
			response.sendRedirect("logout");
		} else {
			/* Enviamos al navegador la vista generada por login.jsp */
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		/* Recogemos los parámetros introducidos en los campos usuario y contrasena */
		String user = request.getParameter("usuario");
		String pass = request.getParameter("contrasena");

		/* Convocamos la función Login() */
		Usuario unUsuarioEncontrado = LoginEM.getInstance().login(user, pass);// BBDD.Login(user, pass);

		System.out.println("Usuario: " + user + " :: Pasword: " + pass);

		if (unUsuarioEncontrado != null) {
			System.out.println(
					"tipo Usuario:" + unUsuarioEncontrado.getTipo() + ":" + unUsuarioEncontrado.getNombreUsuario());
			// Se obtiene la sesión iniciada y su usuario
			HttpSession session = request.getSession();
			session.setAttribute("usuario", unUsuarioEncontrado.getNombreUsuario());
			String muro = null;
			switch (unUsuarioEncontrado.getTipo()) {
			// Si el usuario es coordinador
			case 1:
				muro = "./coordinador";
				break;
			// Si el usuario es profesor
			case 2:
				muro = "./profesor";
				break;
			// Si el usuario es alumno
			case 3:
				muro = "./alumno";
				break;
			}
			/* Enviamos a cada usuario a la dirección definida según su tipo */
			response.sendRedirect(muro);
		} else {
			/* Sacamos por pantalla el mensaje de error si el usuario no es válido */
			request.setAttribute("error", "Los datos son incorrectos!!!");
			this.doGet(request, response);
		}
	}
}