package packageWeb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytube.CanalController.CanalController;
import uytube.UsuarioController.UsuarioController;
import uytube.VideoController.VideoController;
import uytube.models.Canal;
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
	
    public ver() {
        super();
        // TODO Auto-generated constructor stub
        controllerUser = new UsuarioController();
		controllerVideo = new VideoController();
		controllerCanal = new CanalController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * Necesito el video dado un id
		 */
			
		String id_video = (String) request.getParameter("id_video");
		Video video = controllerVideo.consultaVideoPorID(Integer.parseInt(id_video));

		if (request.getSession().getAttribute("usuarioLogeado") == null) {
			request.setAttribute("siguiendo", "false");
		} else {
			// OBTENER SI SIGUE EL USUARIO

			if (this.loSigue(video.getCanal().getNombre(),
					controllerUser.listCanalesSeguidos((String) request.getSession().getAttribute("usuarioLogeado")))) {
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
