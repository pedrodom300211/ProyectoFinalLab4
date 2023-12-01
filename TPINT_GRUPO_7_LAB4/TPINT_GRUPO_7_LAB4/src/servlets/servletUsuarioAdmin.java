package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.clienteDaoImpl;
import daoImpl.usuarioAdminDaoImpl;

/**
 * Servlet implementation class servletUsuarioAdmin
 */
@WebServlet("/servletUsuarioAdmin")
public class servletUsuarioAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletUsuarioAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean bandera = false; 
		if(request.getParameter("BotonAceptarLogin")!=null)
		 {
			 
			 usuarioAdminDaoImpl usuarioAdminDao = new usuarioAdminDaoImpl();
			 bandera = usuarioAdminDao.obtenerUsuarioAdmin(request.getParameter("txtUsuarioLogIn"), request.getParameter("txtContraseñaLogIn"));
			 request.setAttribute("bandera", bandera);
			 
			 RequestDispatcher rd = request.getRequestDispatcher("/LogIn.jsp");
		     rd.forward(request, response);
			 
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
