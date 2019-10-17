package packageWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytube.ListaController.ListaController;

/**
 * Servlet implementation class agregarQuitar
 */
public class agregarQuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ListaController controllerLista;
    public agregarQuitar() {
        super();
        // TODO Auto-generated constructor stub
        controllerLista = new ListaController();
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
		
		
		int idvid = Integer.parseInt((String)request.getParameter("id_video"));
		int idList = Integer.parseInt((String)request.getParameter("id_lista"));
		
		if(request.getParameter("accion") != null) {
		
			try {
			controllerLista.agregarVideo(idvid, idList);
			response.getWriter().print("Video agregado a lista");
			}catch(Exception e) {
				response.getWriter().print("El video ya esta agregado a esa lista");
			}
		}else {
			try {
				controllerLista.quitarVideo(idvid, idList);
				response.getWriter().print("Video fuera de la lista");
			}catch(Exception e) {
				response.getWriter().print("El video no esta en la lista video a lista");
			}
		}
		
	}

}
