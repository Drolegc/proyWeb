package packageWeb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytube.CanalController.CanalController;
import uytube.UsuarioController.*;
import uytube.VideoController.*;
import uytube.models.Canal;
import uytube.models.Video;

/**
 * Servlet implementation class seguir
 */
public class seguir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	UsuarioController controllerUser;
	VideoController controllerVideo;
	CanalController controllerCanal;

	public seguir() {
		super();
		controllerUser = new UsuarioController();
		controllerVideo = new VideoController();
		controllerCanal = new CanalController();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String usuario_logeado = (String) request.getSession().getAttribute("usuarioLogeado");

		if (usuario_logeado != null) {

			// Obtener el canal a seguir
			String nickname = (String) request.getParameter("nickname");
			String canal = (String) request.getParameter("canal_nombre");
			System.out.println(canal);
			//Buscar el canal por que se necesita el nickname del usuario
			if (request.getParameter("subscribe").equals("true")) {
				this.controllerUser.seguirUsuario(usuario_logeado, nickname);
			} else {
				this.controllerUser.dejarDeSeguir(usuario_logeado, canal);
			}
		}
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
