package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cliente;
import Entidad.Cuenta;
import Entidad.MovimientoCuentas;
import Entidad.Prestamo;
import daoImpl.MovimientosDaoImpl;
import daoImpl.PrestamosDaoImp;
import daoImpl.clienteDaoImpl;
import daoImpl.cuentaDaoImpl;

/**
 * Servlet implementation class servletsPrestamo
 */
@WebServlet("/servletsPrestamo")
public class servletsPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletsPrestamo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null) {
    		PrestamosDaoImp pDao = new PrestamosDaoImp();
        	ArrayList<Prestamo> lista = pDao.obtenerPrestamos();
        	
        	request.setAttribute("listaC", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/AutorizacionPrestamos.jsp");
            rd.forward(request, response);
    		 
    		 
    	}
		
		int filas = 0; 
		
		
		
		if(request.getParameter("BotonPagar")!=null)
		{	
			int numPrestamo = Integer.parseInt(request.getParameter("numeroPrestamo"));
			
			int cantidadCuotas=Integer.parseInt(request.getParameter("ddCantidadCuotas"));
			int cantidadTotales=Integer.parseInt(request.getParameter("CuotasTotales"));
			
			PrestamosDaoImp cDao = new PrestamosDaoImp();
			cuentaDaoImpl cuentaDao = new cuentaDaoImpl();
			
			filas=0;
			 int filas2=0;
			 float monto=Float.parseFloat(request.getParameter("Monto"));
			 float montoInt=(Float.parseFloat(request.getParameter("MontoInteres")));
			 float MontoxCuota=(Float.parseFloat(request.getParameter("MontoInteres")))/cantidadTotales;
			 
			MovimientosDaoImpl MCDao=new MovimientosDaoImpl();
			LocalDate fechaActual = LocalDate.now();
			if(cuentaDao.verificarSaldo(Integer.parseInt(request.getParameter("NumCuentaSolicita")), MontoxCuota*cantidadCuotas)){
			 
			
			filas= cuentaDao.TrasnferirDinero(request.getParameter("NumCuentaSolicita"),"1", MontoxCuota*cantidadCuotas);
			
			request.setAttribute("cantFilas", filas);
			
			
			if(cantidadCuotas==cantidadTotales) {
			MovimientoCuentas MC= new MovimientoCuentas();
			MC.setNumeroCuentaEmisor(Integer.parseInt(request.getParameter("NumCuentaSolicita")));
			MC.setNumeroCunetaReceptor(cuentaDao.GetNumCuentaByCBU("1"));
			MC.setMonto(Float.parseFloat(request.getParameter("MontoInteres")));
			MC.setFechaMovimiento(String.valueOf(fechaActual));
			MC.setDetalleMovimiento("Prestamo Pagado");
			MC.setTipoMovimiento("Prestamo");
			filas2=MCDao.agregarMovimiento(MC);
			cDao.ActualizarPrestamo(numPrestamo, Integer.parseInt(request.getParameter("NumCuentaSolicita")),monto ,(montoInt-(MontoxCuota*cantidadCuotas)), String.valueOf(fechaActual),cantidadTotales- cantidadCuotas,0);
			///
			

			String cuenta = request.getSession().getAttribute("sessionNombreCuenta").toString();
			
        	ArrayList<Prestamo> lista = cDao.obtenerPrestamoSegunCuenta(Integer.parseInt(cuenta));
        	
        	request.setAttribute("listaC", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/PagoPrestamos.jsp");
            rd.forward(request, response);
            
			}else {
            	MovimientoCuentas MC2= new MovimientoCuentas();
            	MC2.setNumeroCuentaEmisor(Integer.parseInt(request.getParameter("NumCuentaSolicita")));
            	MC2.setNumeroCunetaReceptor(cuentaDao.GetNumCuentaByCBU("1"));
            	MC2.setMonto((MontoxCuota*cantidadCuotas));
            	
            	MC2.setFechaMovimiento(String.valueOf(fechaActual));
            	MC2.setDetalleMovimiento(cantidadCuotas+" Cuotas Pagadas");
            	MC2.setTipoMovimiento("Prestamo");
    			filas2=MCDao.agregarMovimiento(MC2);
    			
    			cDao.ActualizarPrestamo(numPrestamo, Integer.parseInt(request.getParameter("NumCuentaSolicita")), monto ,(montoInt-(MontoxCuota*cantidadCuotas)), String.valueOf(fechaActual),cantidadTotales- cantidadCuotas,1);
            	
    			String cuenta = request.getSession().getAttribute("sessionNombreCuenta").toString();
    			
            	ArrayList<Prestamo> lista = cDao.obtenerPrestamoSegunCuenta(Integer.parseInt(cuenta));
            	
            	request.setAttribute("listaC", lista);
            	request.setAttribute("cantFilas", filas2);
            	
            	RequestDispatcher rd = request.getRequestDispatcher("/PagoPrestamos.jsp");
                rd.forward(request, response);
            	
            	
            	
            }
			}else {
				
				filas2=-1;
				String cuenta = request.getSession().getAttribute("sessionNombreCuenta").toString();
    			
            	ArrayList<Prestamo> lista = cDao.obtenerPrestamoSegunCuenta(Integer.parseInt(cuenta));
            	request.setAttribute("cantFilas", filas2);
            	
            	request.setAttribute("listaC", lista);
            	
            	RequestDispatcher rd = request.getRequestDispatcher("/PagoPrestamos.jsp");
                rd.forward(request, response);
				
				
			}
			
		}
		
		if (request.getParameter("Param2") != null) {
			PrestamosDaoImp sDao = new PrestamosDaoImp();
			
			String cuenta = request.getSession().getAttribute("sessionNombreCuenta").toString();
			
        	ArrayList<Prestamo> lista = sDao.obtenerPrestamoSegunCuenta(Integer.parseInt(cuenta));
        	
        	request.setAttribute("listaC", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/PagoPrestamos.jsp");
            rd.forward(request, response);
		}
		if (request.getParameter("BotonSolicitarPrestamo") != null) {
			Prestamo p = new Prestamo(); 
			
			if(request.getParameter("txtMontoPrestamo")=="" || request.getParameter("txtCuotasPrestamo")=="")
			{
				filas=-1;
				request.setAttribute("cantFilas", filas);
				
				RequestDispatcher rd = request.getRequestDispatcher("/SolicitarPrestamo.jsp");
				rd.forward(request, response);
				
			}else {

	        LocalDate fechaActual = LocalDate.now();
			
			p.setNumeroCuentaSolocita(Integer.parseInt(request.getSession().getAttribute("sessionNombreCuenta").toString()));
			p.setMontoPedido(Float.parseFloat(request.getParameter("txtMontoPrestamo")));
			p.setFechaPrestamo(String.valueOf(fechaActual));
			p.setCuotasPrestamo(Integer.parseInt(request.getParameter("txtCuotasPrestamo")));
			p.setEstadoPrestamo(2);
			
			
			PrestamosDaoImp pdao = new PrestamosDaoImp(); 
			filas = pdao.agregarPrestamo(p);
			request.setAttribute("cantFilas", filas);
			
			RequestDispatcher rd = request.getRequestDispatcher("/SolicitarPrestamo.jsp");
			rd.forward(request, response);
			}
		}
		
		if(request.getParameter("btnAceptarPrestamo")!=null)
		{
			int filas3=0;
			int filas2=0;
			int numeroPrestamo = Integer.parseInt(request.getParameter("NumeroPrestamo"));
			
			float Monto = Float.parseFloat(request.getParameter("Monto"));
			
			PrestamosDaoImp pDao = new PrestamosDaoImp();
			filas3=pDao.AceptarPrestamo(1,numeroPrestamo);
			
			
			cuentaDaoImpl cDao = new cuentaDaoImpl();
			MovimientosDaoImpl MCDao=new MovimientosDaoImpl();
			LocalDate fechaActual = LocalDate.now();
			 
			 String CBU= cDao.getCBUByNumCuenta(pDao.GetNumCuentaByNumPrestamo(Integer.parseInt(request.getParameter("NumeroPrestamo"))));
			filas= cDao.TrasnferirDinero("1",CBU, Float.parseFloat(request.getParameter("Monto")));
			
			request.setAttribute("cantFilas", filas);
			MovimientoCuentas MC= new MovimientoCuentas();
			MC.setNumeroCuentaEmisor(1);
			MC.setNumeroCunetaReceptor(cDao.GetNumCuentaByCBU(CBU));
			MC.setMonto(Float.parseFloat(request.getParameter("Monto")));
			MC.setFechaMovimiento(String.valueOf(fechaActual));
			MC.setDetalleMovimiento("Prestamo Aceptado");
			MC.setTipoMovimiento("Prestamo");
			filas2=MCDao.agregarMovimiento(MC);
			
			PrestamosDaoImp pDao2 = new PrestamosDaoImp();
        	ArrayList<Prestamo> lista = pDao2.obtenerPrestamos();
        	
        	request.setAttribute("listaC", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/AutorizacionPrestamos.jsp");
            rd.forward(request, response);
			
		
			
			
			
			
		}
		if(request.getParameter("btnRechazarPrestamo")!=null)
		{
			int filas3=0;
			int filas2=0;
			int numeroPrestamo = Integer.parseInt(request.getParameter("NumeroPrestamo"));
			PrestamosDaoImp pDao = new PrestamosDaoImp();
			filas3=pDao.AceptarPrestamo(-1,numeroPrestamo);
			
			
			cuentaDaoImpl cDao = new cuentaDaoImpl();
			MovimientosDaoImpl MCDao=new MovimientosDaoImpl();
			LocalDate fechaActual = LocalDate.now();
			 
			 String CBU= cDao.getCBUByNumCuenta(pDao.GetNumCuentaByNumPrestamo(Integer.parseInt(request.getParameter("NumeroPrestamo"))));
			
			
			
			MovimientoCuentas MC= new MovimientoCuentas();
			MC.setNumeroCuentaEmisor(1);
			MC.setNumeroCunetaReceptor(cDao.GetNumCuentaByCBU(CBU));
			MC.setMonto(Float.parseFloat(request.getParameter("Monto")));
			MC.setFechaMovimiento(String.valueOf(fechaActual));
			MC.setDetalleMovimiento("Prestamo Rechazado");
			MC.setTipoMovimiento("Prestamo");
			filas2=MCDao.agregarMovimiento(MC);
			request.setAttribute("cantFilas2", filas2);
			
			PrestamosDaoImp pDao2 = new PrestamosDaoImp();
        	ArrayList<Prestamo> lista = pDao2.obtenerPrestamos();
        	
        	request.setAttribute("listaC", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/AutorizacionPrestamos.jsp");
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
