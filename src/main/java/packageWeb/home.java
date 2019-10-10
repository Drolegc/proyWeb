package packageWeb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uytube.CategoriaController.CategoriaController;
import uytube.CategoriaController.ICategoria;
import uytube.ListaController.ILista;
import uytube.ListaController.ListaController;
import uytube.models.Categoria;
import uytube.models.Lista;
import uytube.models.Usuario;

/**
 * Servlet implementation class home
 */
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	private ILista controllerLista;
	private ICategoria controllerCategoria;

	public home() {
		super();
		// TODO Auto-generated constructor stub
		controllerLista = new ListaController();
		controllerCategoria = new CategoriaController();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession sessiones = request.getSession();
		System.out.println("PATH:"+request.getRequestURI().substring(request.getContextPath().length()));
		
		/*
		 * Si el usuario esta logeado Cargar las listas
		 */

		// request.setAttribute(name, o) existe unicamente en ese request
		if (sessiones.getAttribute("categorias") == null) {
			List<Categoria> categorias = controllerCategoria.listarCategorias();
			sessiones.setAttribute("categorias", categorias);
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
