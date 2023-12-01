package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cuenta;
import Entidad.MovimientoCuentas;
import daoImpl.MovimientosDaoImpl;
import daoImpl.cuentaDaoImpl;

/**
 * Servlet implementation class servletMovimientoCuentas
 */
@WebServlet("/servletMovimientoCuentas")
public class servletMovimientoCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletMovimientoCuentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("Param5") != null) {
			MovimientosDaoImpl MovDao = new MovimientosDaoImpl(); 
			ArrayList<MovimientoCuentas> lista = MovDao.obtenerMovimientos(Integer.parseInt(request.getSession().getAttribute("sessionNombreCuenta").toString()));
			
			request.setAttribute("listaM", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/MovimientosCuenta.jsp");
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
