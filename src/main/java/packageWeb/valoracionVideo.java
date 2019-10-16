package packageWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytube.UsuarioController.UsuarioController;
import uytube.ValoracionController.ValoracionController;
import uytube.VideoController.VideoController;
import uytube.models.Usuario;
import uytube.models.ValoracionVideo;

/**
 * Servlet implementation class valoracionVideo
 */
public class valoracionVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private ValoracionController controllerValoracion;
	private UsuarioController controllerUsuario;
	private VideoController controllerVideo;
	
    public valoracionVideo() {
        super();
        // TODO Auto-generated constructor stub
        controllerValoracion = new ValoracionController();
        controllerUsuario = new UsuarioController();
        controllerVideo = new VideoController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_logueado = (String)request.getSession().getAttribute("usuarioLogueado");
		int id_video = Integer.parseInt(request.getParameter("id_video"));
		int nueva_valoracion = Integer.parseInt(request.getParameter("valoracion"));// 1 o -1
		
		// Primero saber si es una valoracion a actualizar
		ValoracionVideo valoracion;
		try {
			valoracion = controllerValoracion.traerValoracion(id_video, user_logueado);
			//En este punto, si el usuairo no habia valorado antes el video, saltara una excepcion
			valoracion.setValoracion(nueva_valoracion);
			
			System.out.println("Usuario de valoracion: "+valoracion.getUsuario().getNickname());
			
			controllerValoracion.valorarVideo(valoracion);
		}catch(Exception e) {
			System.out.println("Except valoration!");
			//Nueva valoracion
			Usuario user = controllerUsuario.consultarUsuario(user_logueado);
			valoracion = new ValoracionVideo();
			valoracion.setVideo(controllerVideo.consultaVideoPorID(id_video));
			valoracion.setUsuario(user);
			valoracion.setValoracion(nueva_valoracion);
			controllerValoracion.valorarVideo(valoracion);
		}
		
		response.getWriter().print("Valoracion hecha "+nueva_valoracion);

	}

}
