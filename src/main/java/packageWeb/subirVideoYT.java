package packageWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import uytube.CanalController.CanalController;
import uytube.CategoriaController.CategoriaController;
import uytube.UsuarioController.UsuarioController;
import uytube.VideoController.VideoController;
import uytube.models.Canal;
import uytube.models.Categoria;
import uytube.models.Video;

/**
 * Servlet implementation class subirVideo
 */
public class subirVideoYT extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private VideoController controllerVideo;
	private UsuarioController controllerUser;
	private CanalController controllerCanal;
	private Date fechaPub;
	private CategoriaController controllerCategoria;

	public subirVideoYT() {
		super();

		// TODO Auto-generated constructor stub
		controllerVideo = new VideoController();
		controllerUser = new UsuarioController();
		controllerCanal = new CanalController();
		controllerCategoria = new CategoriaController();
	}

	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("usuarioLogueado") != null) {
			request.getRequestDispatcher("uploadVideo.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String nombre_video = request.getParameter("titulo_video");
		String descripcion = request.getParameter("descripcion");
		String url_video = request.getParameter("url");
		String categoria = request.getParameter("categoria");
		String privacidad = request.getParameter("privacidad");

		String user_log = (String) request.getSession().getAttribute("usuarioLogueado");

		Video v = new Video();
		v.setNombre(nombre_video);
		v.setDescripcion(descripcion);

		v.setFecha(java.sql.Date.valueOf(LocalDate.now()));
		v.setUrl(url_video);
		v.setEs_publico(privacidad == "publico");

		System.out.println("Elegido: " + request.getParameter("select") + "USER: " + user_log);

		v.setCanal(controllerCanal.obtenerCanalUsuario(user_log));
		controllerVideo.altaVideo(v, user_log, categoria);

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}
}
