package packageWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytube.VideoController.VideoController;
import uytube.models.Video;

/**
 * Servlet implementation class modificarVideo
 */
public class modificarVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private VideoController ControllerVideo;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarVideo() {
        super();
        // TODO Auto-generated constructor stub
        ControllerVideo = new VideoController();
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String usuarioLogueado = (String)request.getSession().getAttribute("usuarioLogueado");
		
		ArrayList<Video> ListaVideos = ControllerVideo.obtenerVideosUsuario("cachilas");
		
		System.out.println((String)request.getSession().getAttribute("usuarioLogueado"));
		request.setAttribute("ListaConVideos", ListaVideos);
		request.getRequestDispatcher("ModificarVideo.jsp").forward(request, response);
		System.out.println("puto1");
		for(Video V: ListaVideos) {
			System.out.println(V.getNombre()+"puto");
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
