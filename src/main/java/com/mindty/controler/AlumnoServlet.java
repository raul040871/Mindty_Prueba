package com.mindty.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.mindty.modelos.Curso;
import com.mindty.modelos.Modulo;
import com.mindty.modelos.Unidad;
import com.mindty.modelos.Usuario;
import com.mindty.persistence.AlumnoEM;

@WebServlet("/alumno")
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Se verifica la sesión para el usuario tipo usuario */
//		HttpSession session = request.getSession();
//		if (session.getAttribute("usuario") != null) {
//			Usuario elUser = null;// BBDD.getUsuarioByUsuario((String) session.getAttribute("usuario"));
//			request.setAttribute("usuario", elUser);
		
		List<Unidad> listaUnidad;
		List<Curso> listaCurso;
		List<Modulo> listaModulo;
		
		try {
			
			listaModulo = AlumnoEM.getInstance().getAlumnoModulos(1);
			request.setAttribute("listaModulo", listaModulo);
			
			
		 listaCurso = AlumnoEM.getInstance().getUsuarioAlumnoCurso(1);
			request.setAttribute("listaCurso", listaCurso);
			
			
			listaUnidad = AlumnoEM.getInstance().getAlumnoUnidades(3);
			request.setAttribute("listaUnidad", listaUnidad);
			request.getRequestDispatcher("alumno.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("alumno.jsp").forward(request, response);
	}
			
		
		
		

//		} else {
//			response.sendRedirect("login");
//		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
