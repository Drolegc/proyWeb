package packageWeb;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytube.ComentarioController.ComentarioController;
import uytube.UsuarioController.UsuarioController;
import uytube.VideoController.VideoController;
import uytube.models.Comentario;
import uytube.models.Video;

/**
 * Servlet implementation class comentar
 */
public class comentar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private UsuarioController controllerUser;
	private VideoController controllerVideo;
	private ComentarioController controllerComentario;
	
    public comentar() {
        super();
        // TODO Auto-generated constructor stub
        
        controllerUser = new UsuarioController();
        controllerVideo = new VideoController();
        controllerComentario = new ComentarioController();
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
		
		
		int id_video = Integer.parseInt(request.getParameter("id_video"));
		String comentario = (String) request.getParameter("comentario");
		
		if(request.getParameter("id_comentario") != null) {
			int id_comentario = Integer.parseInt(request.getParameter("id_comentario"));
			
			//Respuesta a un comentario

			Comentario respuesta = new Comentario();
			
			respuesta.setComentario(comentario);
			respuesta.setFecha(new Date());
			respuesta.setVid(null);
			
			respuesta.setUsuario(
					controllerUser.consultarUsuario((String)request.getSession().getAttribute("usuarioLogueado"))
					);
			
			controllerComentario.AgregarRespuesta((long) id_comentario, respuesta);
		}else {
			
			Video vid = controllerVideo.consultaVideoPorID(id_video);
			Comentario com = new Comentario();
			
			com.setComentario(comentario);
			com.setFecha(new Date());
			com.setVid(vid);
			
			com.setUsuario(
					controllerUser.consultarUsuario((String)request.getSession().getAttribute("usuarioLogueado"))
					);
			
			controllerComentario.AgregarComentario(com);
			
		}
		
		response.getWriter().print("Listo!");
	}

}
