package packageWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytube.ListaController.ListaController;

/**
 * Servlet implementation class crearLista
 */


public class crearLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private ListaController controllerLista;
    public crearLista() {
        super();
        controllerLista = new ListaController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre_lista = (String)request.getParameter("nombre_lista");
		
		String categoria = (String)request.getParameter("categoria");
		System.out.println(categoria);
		
		//Privado chequeado = on else null
		boolean privado;
		if(request.getParameter("privado") != null) {
			privado = true;
		}else {
			privado = false;
		}
		
		String user_logueado = (String)request.getSession().getAttribute("usuarioLogueado");
		controllerLista.crearLista(nombre_lista, "Sin Categoria",user_logueado, privado, false);
		
		
		doGet(request, response);
	}

}
