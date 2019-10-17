package packageWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytube.CategoriaController.CategoriaController;
//import uytube.CanalController.CanalController;
import uytube.ListaController.ListaController;
import uytube.UsuarioController.UsuarioController;
//import uytube.ValoracionController.ValoracionController;
import uytube.VideoController.VideoController;
import uytube.CategoriaController.CategoriaController;
import uytube.models.Canal;
import uytube.models.Categoria;
import uytube.models.Lista;
import uytube.models.Video;

/**
 * Servlet implementation class categorias
 */
public class categorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private VideoController controllerVideo;
	private CategoriaController categoriaController;
	//private CanalController controllerCanal;
	private ListaController controllerLista;
	//private ValoracionController controllerValoracion;
	
    public categorias() {
        super();
        // TODO Auto-generated constructor stub
        controllerVideo = new VideoController();
        categoriaController = new CategoriaController();
        controllerLista = new ListaController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String nombreCategoria = (String) request.getParameter("nombreCategoria");
		Categoria categoria = categoriaController.obtenerCategoria(nombreCategoria);
		
		List<Video> videos = new ArrayList<Video>();
		            videos = controllerVideo.videoPorCategoria(categoria);
		
		            for(Video v: controllerVideo.videoPorCategoria(categoria)) {
		            	videos.add(v);
		    		}            
		            
		request.setAttribute("Categoria", categoria.getNombre());
		request.setAttribute("listaVideos", videos);
				
		
				//for(Video v: List<Video>request.getAttribute("listaDeVideos")
		
		// Despachar
		request.getRequestDispatcher("categorias.jsp").forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
