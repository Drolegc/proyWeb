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
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usuario_logeado = (String)request.getSession().getAttribute("usuarioLogeado");
		
		//Testing AJAX 
		System.out.println("Ajax por post");
		System.out.println("User: "+usuario_logeado);
		//El estado de la subscripcion
		// true o false
		String subscribe = (String)request.getParameter("subscribe");
		System.out.println(subscribe);
		
		//nombre del usuario a Seguir
		String nickname = (String)request.getParameter("nickname");
		System.out.println(nickname);
		
		//el nombre del canal a dejar de seguir
		String canal_nombre = (String)request.getParameter("canal_nombre");
		System.out.println(canal_nombre);
		
		response.setContentType("text/plain");
		
		if(subscribe.equals("true")) {
			controllerUser.seguirUsuario(usuario_logeado, nickname);
			response.getWriter().print("Ahora sigues a "+nickname);
		}else {
			controllerUser.dejarDeSeguir(usuario_logeado, canal_nombre);
			response.getWriter().print("Dejaste de seguir a "+canal_nombre);
		}
		
		
		
	}

}
