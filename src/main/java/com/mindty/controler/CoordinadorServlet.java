package com.mindty.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.mindty.persistence.CoordinadorEM;

@WebServlet("/coordinador")
public class CoordinadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Se inicia sesión */
		List<Usuario> profes = (CoordinadorEM.getInstance().getListaUsuario(2));

		request.setAttribute("profes", profes);
		request.getRequestDispatcher("coordinador.jsp").forward(request, response);
		// HttpSession session = request.getSession();
		//
		// /* Instanciamos la lista de profes */
		// List<Usuario> profes =null; //BBDD.getInstance().getProfes();
		// /* Se añade la lista de profes al request */
		// request.setAttribute("profes", profes);
		// /* REVISAR!!!!!!!!!!!!! */
		// if (session.getAttribute("usuario") != null) {
		// /* Si el usuario es coordinar se le genera la vista descrita en
		// coordinador.jsp */
		// Usuario elUser = null;// BBDD.getUsuarioByUsuario((String)
		// session.getAttribute("usuario"));
		// request.setAttribute("usuario", elUser);
		//
		// } else {
		// /* Si el usuario no existe se llama al servlet login */
		// response.sendRedirect("login");
		// }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CoordinadorEM.getInstance().getProfe(Integer.parseInt(request.getParameter("profes")));
		
		Modulo nuevoModulo = new Modulo();
		List<Modulo> nuevaListaModulo = new ArrayList<>();	
		
		response.setContentType("text/html");

		// Listado de modulos //
		Map m = request.getParameterMap();
		Set s = m.entrySet();
		Iterator it = s.iterator();
		int numeroDeModulos = 0;
		int numeroDeUnidades = 0;

		while (it.hasNext()) {
			Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it.next();
			String key = entry.getKey();
			String[] value = entry.getValue();
			if (value.length > 1) {
				for (int i = 0; i < value.length; i++) {
					 value[i].toString();
				}
			} else {
				value[0].toString();
				
				if (key.equals("modulos")) {
					numeroDeModulos = Integer.parseInt(value[0]);
				}
				if (key.startsWith("modul"+String.valueOf(numeroDeModulos))) {
					
					nuevoModulo.setNombreModulo(value[0]);
					
					System.out.println("key = "+key +" :: value = "+ value[0] +" :: MODULO!!!!!");
					System.out.println(" ");
					numeroDeModulos--;
					numeroDeUnidades = 1;
					nuevaListaModulo=null;
				} 
				
				if (key.endsWith("u"+String.valueOf(numeroDeUnidades))) {
					//nuevaListaModulo.add(new Unidad(value[0]));
					numeroDeUnidades++;
				}
			}
		}
		
		
		
		

		// new
		// Curso(request.getParameter("codigoCurso"),request.getParameter("nombreCurso"),Integer.parseInt(request.getParameter("profes")),Integer.parseInt(request.getParameter("modulos")),Integer.parseInt(request.getParameter("horas")));
		// BBDD.getInstance().newCurso(nuevoCurso);
		/* Se regresa de nuevo a la página haciendo un nuevo doGet */
		
		List<Usuario> alumnos = CoordinadorEM.getInstance().getListaUsuario(3);
		
		Curso nuevoCurso = new Curso();

		nuevoCurso.setCodCurso(request.getParameter("codigoCurso"));
		nuevoCurso.setNombreCurso(request.getParameter("nombreCurso"));
		//nuevoCurso.setModulo(listaModulo);
		nuevoCurso.setHorasCurso(Integer.parseInt(request.getParameter("horas")));
		nuevoCurso.setAlumnos(alumnos);
		nuevoCurso.setFormador(CoordinadorEM.getInstance().getProfe(Integer.parseInt(request.getParameter("profes"))));

		doGet(request, response);
	}
}