package com.mindty.controler;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;

import com.mindty.modelos.Curso;
import com.mindty.modelos.Modulo;
import com.mindty.modelos.Usuario;
import com.mindty.persistence.ProfesorEM;

@WebServlet("/profesor")

public class ProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Se inicia sesión */
		HttpSession session = request.getSession();
		/* Se obtiene el usuario de la sesión */
		String user;// = (String) request.getSession().getAttribute("usuario");
		user="email4@email.com";
		/* Se obtiene la info del profesor con la función idUsuario */
		int nid=0;
		try {
			 nid= ProfesorEM.getInstance().idUsuario(user);
			 System.out.println(nid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* Se crea una lista de los cursos asignados al profesor con la función ConsultarCursos y se le añade al request como listaCursos*/
		List<Curso> listaCursos=null;
		try {
			listaCursos = ProfesorEM.getInstance().getListaCurso(nid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//null;// BBDD.getInstance().ConsultaCursos(nid);
		request.setAttribute("listaCursos", listaCursos);
		
		
		 /* REVISAR!!!!!!!!!!!!! */
		if (session.getAttribute("usuario") != null) {
			/* Si el usuario es profesor se le genera la vista descrita en profesor.jsp */
			Usuario elUser = null;// BBDD.getUsuarioByUsuario((String) session.getAttribute("usuario"));
			request.setAttribute("usuario", elUser);
			request.getRequestDispatcher("profesor.jsp").forward(request, response);
		} else {
			/* Si el usuario no existe se llama al servlet login */
			//response.sendRedirect("login");
			Usuario elUser = null;
			request.setAttribute("usuario", elUser);
			request.getRequestDispatcher("profesor.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Cursos")!=null)
		{
			String strId=request.getParameter("Cursos");
		
			int nIdCurso=Integer.parseInt(strId);
		
			System.out.println("nIdCurso :" + nIdCurso);
		
			List<Modulo> listaModulo=null;
			listaModulo = ProfesorEM.getInstance().getListaModulos(nIdCurso);
			System.out.println("Lista de modulos :" + listaModulo);
			request.setAttribute("listaModulo", listaModulo);
		}
		
		//System.out.println("Modulosss " + request.getParameter("ModuloCurso"));
		
		if(request.getParameter("ModuloCurso")!=null)
		{
			int nIdmodulo=Integer.parseInt(request.getParameter("ModuloCurso"));
		
			List<Usuario> listaAlumnos=null;
			listaAlumnos= ProfesorEM.getInstance().getListaAlumnos(nIdmodulo);
			System.out.println(listaAlumnos);
			
			request.setAttribute("listaAlumnos", listaAlumnos);
		}
		
		
		
		
		
		doGet(request, response);
	}
}