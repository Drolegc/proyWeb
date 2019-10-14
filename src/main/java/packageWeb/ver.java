package packageWeb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytube.CanalController.CanalController;
import uytube.ListaController.ListaController;
import uytube.UsuarioController.UsuarioController;
import uytube.ValoracionController.ValoracionController;
import uytube.VideoController.VideoController;
import uytube.models.Canal;
import uytube.models.Lista;
import uytube.models.ValoracionVideo;
import uytube.models.Video;

/**
 * Servlet implementation class ver
 */
public class ver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private UsuarioController controllerUser;
	private VideoController controllerVideo;
	private CanalController controllerCanal;
	private ListaController controllerLista;
	private ValoracionController controllerValoracion;
	
    public ver() {
        super();
        // TODO Auto-generated constructor stub
        controllerUser = new UsuarioController();
		controllerVideo = new VideoController();
		controllerCanal = new CanalController();
		controllerLista = new ListaController();
		controllerValoracion = new ValoracionController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usuario_logeado = (String) request.getSession().getAttribute("usuarioLogeado");
		
		/*
		 * Consulta lista
		 * 
		 * Para el caso de uso de consulta lista es necesario 
		 * mostrar el video en conjunto a la lista de reproduccion
		 * 
		 * */
			
		String id_lista = (String) request.getParameter("id_lista");
		Lista lista = controllerLista.obtenerListaPorId(Integer.parseInt(id_lista));
		
		String id_video = (String) request.getParameter("id_video");
		Video video = controllerVideo.consultaVideoPorID(Integer.parseInt(id_video));

		if (request.getSession().getAttribute("usuarioLogeado") == null) {
			request.setAttribute("siguiendo", "false");
		} else {
			// OBTENER SI SIGUE EL USUARIO

			if (this.loSigue(video.getCanal().getNombre(),
					controllerUser.listCanalesSeguidos(usuario_logeado))) {
				request.setAttribute("siguiendo", "true");
			} else {

				request.setAttribute("siguiendo", "false");
			}

		}

		/*
		 * Datos del video
		 * 
		 * Titulo
		 * 
		 * Canal
		 * 
		 * nickname (Para dejar de seguir o seguir)
		 * 
		 * Link
		 * 
		 * 
		 */

		request.setAttribute("titulo", video.getNombre());
		request.setAttribute("canal_nombre", video.getCanal().getNombre());
		request.setAttribute("nickname", video.getCanal().getUsuario().getNickname());
		request.setAttribute("link", video.getUrl());
		request.setAttribute("descripcion", video.getDescripcion());
		
		/*
		 * Datos de la lista
		 * 
		 * */
		
		request.setAttribute("lista_videos", lista);
		
		/*
		 * Valoracion del video
		 * 
		 * */
		
		List<ValoracionVideo> likes = controllerValoracion.listaValoracionesVideo(Integer.parseInt(id_video));

		int like = 0;
		int dislike = 0;
		
		for(ValoracionVideo vv:likes) {
			if(vv.getValoracion()==1) {
				like++;
			}else {
				dislike++;
			}
		}
		
		//Si el usuario logeado ya le dio like
		
		
		//Si el usuario no esta logeado la accion es nula
		request.setAttribute("accion", "null");
		
		if(usuario_logeado != null) {
			if(controllerValoracion.existeValoracion(Integer.parseInt(id_video), usuario_logeado)) {
				
				ValoracionVideo val = controllerValoracion.traerValoracion(Integer.parseInt(id_video), usuario_logeado);
				
				if(val.getValoracion()==1) {
					request.setAttribute("accion", "like");
				}else {
					request.setAttribute("accion", "dislike");
				}
				
			}
		}
		
		request.setAttribute("likes", like);
		request.setAttribute("dislikes", dislike);
		
		// Despachar
		request.getRequestDispatcher("verVideo.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean loSigue(String nombreCanal, List<Canal> canales) {
		/*
		 * Si el usuario logeado sigue a String usuario Tabla relacionada a Seguir
		 * usuario
		 * 
		 * usuario_nickname | canal_nombre
		 */
		for (Canal c : canales) {
			if (c.getNombre().equals(nombreCanal)) {
				return true;
			}
		}
		return false;
	}

}
