package packageWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytube.CategoriaController.CategoriaController;
import uytube.ListaController.ListaController;
import uytube.VideoController.VideoController;
import uytube.models.Categoria;
import uytube.models.Lista;
import uytube.models.Video;

/**
 * Servlet implementation class listasReproduccion
 */
public class listasReproduccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoController controllerVideo;
	private CategoriaController controllerCategoria;
	private ListaController controllerLista;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listasReproduccion() {
        super();
        // TODO Auto-generated constructor stub
        controllerVideo = new VideoController();
        controllerCategoria = new CategoriaController();
        controllerLista = new ListaController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getSession().getAttribute("usuarioLogueado") != null) {

		int idLista = Integer.parseInt(request.getParameter("idLista"));
				
		Lista listaRepro = controllerLista.obtenerListaPorId(idLista);
		
		List<Video> videos = new ArrayList<Video>();
		videos = listaRepro.getVideosLista();
		String nombreL = listaRepro.getNombre_lista();
		request.setAttribute("nombreLista", nombreL);
		request.setAttribute("listaRepro", videos);
				
		
		request.getRequestDispatcher("listaReproduccion.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
