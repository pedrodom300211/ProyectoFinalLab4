
package servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entidad.Cliente;
import Entidad.Cuenta;
import Entidad.MovimientoCuentas;
import Excepciones.CuentaInvalidaException;
import daoImpl.MovimientosDaoImpl;
import daoImpl.clienteDaoImpl;
import daoImpl.cuentaDaoImpl;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class servletCuenta
 */
@WebServlet("/servletCuenta")
public class servletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, CuentaInvalidaException {
	
		 if(request.getParameter("btnElegirCuenta")!=null) {
			 cuentaDaoImpl cuentaDao = new cuentaDaoImpl();
			 
			 if ((request.getSession().getAttribute("sessionNombreCuenta"))==null) {
				 Cuenta C =cuentaDao.GetByNumeroCuenta(request.getParameter("NumeroCuenta"));
				 request.getSession().setAttribute("sessionNombreCuenta",Integer.toString(C.getNumeroDeCuenta()));
			 }
			 RequestDispatcher rd = request.getRequestDispatcher("/InicioCliente.jsp"); 
			 rd.forward(request, response);
	    	}
		 
		
		
		if (request.getParameter("Param") != null) {
			cuentaDaoImpl cuentaDao = new cuentaDaoImpl(); 
			ArrayList<Cuenta> lista = cuentaDao.obtenerCuenta();
			request.setAttribute("listaC", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoCuentas.jsp");
			rd.forward(request, response);
		}
		
		if (request.getParameter("Reporte") != null) {
			cuentaDaoImpl cuentaDao = new cuentaDaoImpl(); 
			ArrayList<Cuenta> lista = cuentaDao.obtenerCuenta();
			MovimientosDaoImpl MDao=new MovimientosDaoImpl();
			double PorcMenosMil=0;
			double PorcMenosDiezMil=0;
			double PorcMasDiezMil=0;
			
			ArrayList<MovimientoCuentas> listaMovTotal = MDao.obtenerMovimientosTotales();
			ArrayList<MovimientoCuentas> listaMenosMil = MDao.obtenerMovimientosMenosMil();
			ArrayList<MovimientoCuentas> listaMenosDiezMil = MDao.obtenerMovimientosMenosDiezMil();
			ArrayList<MovimientoCuentas> listaMasDiezMil = MDao.obtenerMovimientosMasDiezMil();
			int MovTotales=listaMovTotal.size();
			int MovMenosMil=listaMenosMil.size();
			int MovimientosMenosDiezMil=listaMenosDiezMil.size();
			int MovimientosmasDiezMil=listaMasDiezMil.size();
			if(MovTotales !=0) {
			 PorcMenosMil=((double)MovMenosMil/MovTotales)*100;
			 PorcMenosDiezMil=((double)MovimientosMenosDiezMil/MovTotales)*100;
			 PorcMasDiezMil=((double)MovimientosmasDiezMil/MovTotales)*100;
			}
			
			
			request.setAttribute("MenosMil", PorcMenosMil);
			request.setAttribute("MenosDiezMil", PorcMenosDiezMil);
			request.setAttribute("MasDiezMil", PorcMasDiezMil);
			request.setAttribute("Total", MovTotales);
			
			request.setAttribute("listaC", lista);
			
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");
			rd.forward(request, response);
		}
		
		
		int filas = 0; 
		if (request.getParameter("BotonAceptarAltaCuenta") != null) {
			if(request.getParameter("txtDniAltaCuenta")=="" || request.getParameter("txtCBUAltaCuenta")=="" || request.getParameter("ddlTiposCuentasAltaCuentas")=="" || (!request.getParameter("txtDniAltaCuenta").matches("[0-9]+")) ||(!request.getParameter("txtCBUAltaCuenta").matches("[0-9]+")))
			{
			filas=-1;	
				
			}	else {		
				cuentaDaoImpl cdao = new cuentaDaoImpl();
				ArrayList<Cuenta> Lista=cdao.obtenerCuentaByDNI(request.getParameter("txtDniAltaCuenta"));
				
				if(Lista.size()>=3) {
					
					filas=-2;
				}else {
				
				Cuenta c = new Cuenta(); 
			

	        LocalDate fechaActual = LocalDate.now();
			
			c.setDNICliente_Cuenta(request.getParameter("txtDniAltaCuenta"));
			c.setCBU(request.getParameter("txtCBUAltaCuenta"));
			c.setFechaDeCreacion(String.valueOf(fechaActual));
			c.setTipoDeCuenta(Integer.parseInt(request.getParameter("ddlTiposCuentasAltaCuentas")));
			//if(Float.parseFloat(request.getParameter("txtSaldoCuentaAltaCuenta"))!=0)
				//c.setSaldo(Float.parseFloat(request.getParameter("txtSaldoCuentaAltaCuenta")));
			//
				c.setSaldo(10000);
			//c.setEstado(true);
			
			
			 
			filas = cdao.agregarCuenta(c);
				}}
			request.setAttribute("cantFilas", filas);
			
			RequestDispatcher rd = request.getRequestDispatcher("/AltaCuenta.jsp");
			rd.forward(request, response);
		}
		
		
		if(request.getParameter("BotonFiltrarValorCuenta")!=null) {
			ArrayList<Cuenta> lista;
			if(request.getParameter("txtSegundoValorCuenta")==""||(!request.getParameter("txtSegundoValorCuenta").matches("[0-9]+"))) {
				lista=null;
	    
			}else {
			cuentaDaoImpl cuentaDao = new cuentaDaoImpl();
    		int num = Integer.parseInt(request.getParameter("txtSegundoValorCuenta"));
    		lista = cuentaDao.ObtenerCuentaFiltro(request.getParameter("txtValorCuenta"),request.getParameter("txtSimboloCuenta"),num);
    		
    		
			}
        	request.setAttribute("listaC", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoCuentas.jsp");
            rd.forward(request, response);
    		 
    		 
    	}
		
		
		if(request.getParameter("btnModificarCuenta")!=null)
		{
			
			String numCuenta = request.getParameter("NumeroCuenta");
			cuentaDaoImpl cDao = new cuentaDaoImpl();
			
			Cuenta cuenta = cDao.GetByNumeroCuenta(numCuenta);
			
			
			request.setAttribute("cuenta", cuenta);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModificacionCuenta.jsp");
            rd.forward(request, response);
		}
		 
		if(request.getParameter("BotonAceptarModificacionCuenta")!=null)
		{
			String numCuenta = request.getParameter("txtNumCuentaModificacionCuenta");
			Cuenta cuenta = new Cuenta();
			cuentaDaoImpl cDao = new cuentaDaoImpl();
			
			
			if(request.getParameter("txtDniModificacionCuenta")=="" || request.getParameter("txtCBUModificacionCuenta")=="" || request.getParameter("ddlTiposCuentasModificacionCuentas")=="" || request.getParameter("txtFechaCreacionModificacionCuenta")=="" || request.getParameter("txtSaldoCuentaModificacionCuenta")=="")
			{
			filas=-1;	
				
			} else {

				cuenta.setNumeroDeCuenta(Integer.parseInt(request.getParameter("txtNumCuentaModificacionCuenta")));
				cuenta.setDNICliente_Cuenta(request.getParameter("txtDniModificacionCuenta"));
				cuenta.setCBU(request.getParameter("txtCBUModificacionCuenta"));
				cuenta.setTipoDeCuenta(Integer.parseInt(request.getParameter("ddlTiposCuentasModificacionCuentas")));
				cuenta.setFechaDeCreacion(request.getParameter("txtFechaCreacionModificacionCuenta"));
				cuenta.setSaldo((Float.parseFloat(request.getParameter("txtSaldoCuentaModificacionCuenta"))));
				cuenta.setEstado(true);
				
				filas=0;
				filas=cDao.ActualizarCuenta(cuenta, request.getParameter("txtNumCuentaModificacionCuenta"));
				request.setAttribute("cantFilas", filas);
				request.setAttribute("cuenta", cuenta);
				cuentaDaoImpl cuentaDao = new cuentaDaoImpl(); 
				ArrayList<Cuenta> lista = cuentaDao.obtenerCuenta();
				
				request.setAttribute("listaC", lista);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/ListadoCuentas.jsp");
			    rd.forward(request, response);
			}
			
			if (filas == -1) {
				
				
				
				
				cDao = new cuentaDaoImpl();
				
				cuenta = cDao.GetByNumeroCuenta(numCuenta);
				
				request.setAttribute("cantFilas", filas);
				request.setAttribute("cuenta", cuenta);
				
				RequestDispatcher rd = request.getRequestDispatcher("/ModificacionCuenta.jsp");
	            rd.forward(request, response);
				
				
			}
			
			
		}
		
		 if(request.getParameter("BotonAceptarBajaCuenta")!=null)
			 try {
	                if (request.getParameter("txtCodBajaCuenta") != null && request.getParameter("txtCodBajaCuenta").matches("[0-9]+")) {
	                    cuentaDaoImpl cdao = new cuentaDaoImpl();
	                    filas = cdao.eliminarCuenta(request.getParameter("txtCodBajaCuenta"));
	                    request.setAttribute("cantFilas", filas);

	                    RequestDispatcher rd = request.getRequestDispatcher("/BajaCuenta.jsp");
	                    rd.forward(request, response);
	                } else {
	                    filas = -1;
	                    request.setAttribute("cantFilas", filas);

	                    RequestDispatcher rd = request.getRequestDispatcher("/BajaCuenta.jsp");
	                    rd.forward(request, response);

	                    throw new CuentaInvalidaException();
	                }
	            } catch (CuentaInvalidaException e) {

	                throw new CuentaInvalidaException();


	            }

		 
		 
		 if (request.getParameter("BotonAceptarTransferir") != null) {
			 cuentaDaoImpl cDao = new cuentaDaoImpl();
			 MovimientosDaoImpl MCDao=new MovimientosDaoImpl();
			  LocalDate fechaActual = LocalDate.now();
			 filas=0;
			 int filas2=0;
			 if(request.getParameter("txtCBUTransferir")=="" ||request.getParameter("txtCBUTransferir").equals(cDao.getCBUByNumCuenta(request.getSession().getAttribute("sessionNombreCuenta").toString())) || request.getParameter("txtMontoTransferir")=="" || request.getParameter("txtDetalleTransferencia")=="" || request.getParameter("txtTipoTransferencia")=="" ||  (!request.getParameter("txtCBUTransferir").matches("[0-9]+"))|| (!request.getParameter("txtMontoTransferir").matches("[0-9]+")))
			 {
				 filas=-1;
				 request.setAttribute("cantFilas", filas);
				
			 
			 }else
			 {	 
				 if(cDao.verificarEstado(Integer.parseInt(request.getParameter("txtCBUTransferir")))) {
				 
				 
				 if(cDao.verificarSaldo(Integer.parseInt(request.getSession().getAttribute("sessionNombreCuenta").toString()), Float.parseFloat(request.getParameter("txtMontoTransferir")))) 
				 {
				filas= cDao.TrasnferirDinero(request.getSession().getAttribute("sessionNombreCuenta").toString(), request.getParameter("txtCBUTransferir"), Integer.parseInt(request.getParameter("txtMontoTransferir")));
				
				request.setAttribute("cantFilas", filas);
				MovimientoCuentas MC= new MovimientoCuentas();
				MC.setNumeroCuentaEmisor(Integer.parseInt(request.getSession().getAttribute("sessionNombreCuenta").toString()));
				MC.setNumeroCunetaReceptor(cDao.GetNumCuentaByCBU(request.getParameter("txtCBUTransferir")));
				MC.setMonto(Integer.parseInt(request.getParameter("txtMontoTransferir")));
				MC.setFechaMovimiento(String.valueOf(fechaActual));
				MC.setDetalleMovimiento(request.getParameter("txtDetalleTransferencia"));
				MC.setTipoMovimiento(request.getParameter("txtTipoTransferencia"));
				filas2=MCDao.agregarMovimiento(MC);
				
				
				 }else {
				 filas=-2;
				 request.setAttribute("cantFilas", filas);
				
				 
				 }
				 
			 }else {
				 filas=-3;
			 request.setAttribute("cantFilas", filas);}
				 
				 
				 
			 }
			 RequestDispatcher rd = request.getRequestDispatcher("/Transferencias.jsp");
			 rd.forward(request, response);
			}
		 if(request.getParameter("BotonFiltrarCuenta")!=null) {
			 ArrayList<Cuenta> lista;
				if(request.getParameter("txtNumCuentaFiltrado")==""&&(!request.getParameter("txtNumCuentaFiltrado").matches("[0-9]+"))) {
					lista=null;
				}else {
			 cuentaDaoImpl sDao = new cuentaDaoImpl();
	    		int num = Integer.parseInt(request.getParameter("txtNumCuentaFiltrado"));
	        	 lista = sDao.ObtenerCuentasFiltrados(num);
				}
	        	
	        	request.setAttribute("listaC", lista);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoCuentas.jsp");
	            rd.forward(request, response);
	    		 
	    		 
	    	
		 }
		 
		 if(request.getParameter("BotonFiltrarCuentasFechaCreacion")!=null) {
			 ArrayList<Cuenta> lista;
				if(request.getParameter("txtFechaDesdeFiltrado")==""&&(request.getParameter("txtFechaHastaFiltrado")=="")) {
					cuentaDaoImpl sDao = new cuentaDaoImpl();
		        	lista = sDao.obtenerCuenta();
		        	
		        	request.setAttribute("listaC", lista);
		        	
		        	
				}else {
				cuentaDaoImpl sDao = new cuentaDaoImpl();
	    		String desde = (request.getParameter("txtFechaDesdeFiltrado"));
	    		String hasta = (request.getParameter("txtFechaHastaFiltrado"));
	    		
	    		String fechaDesdeStr = request.getParameter("txtFechaDesdeFiltrado");
	    		String fechaHastaStr = request.getParameter("txtFechaHastaFiltrado");

	    		
	    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    		LocalDate fechaDesde = LocalDate.parse(fechaDesdeStr, formatter);
	    		LocalDate fechaHasta = LocalDate.parse(fechaHastaStr, formatter);

	    		
	    		if (fechaDesde.isAfter(fechaHasta)) {
	    			
	    			request.setAttribute("listaC", null);
		        	
		        	RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");
		            rd.forward(request, response);
	    					
	    				}else {
	    					lista = sDao.ObtenerCuentasFiltradosPorFecha(desde,hasta);
	    		        	 request.setAttribute("listaC", lista);
	    			        	
	    			        	
	    				}
	        	 
				}
				cuentaDaoImpl sDao = new cuentaDaoImpl();
				
				ArrayList<Cuenta> listaEst = sDao.obtenerCuenta();
				MovimientosDaoImpl MDao=new MovimientosDaoImpl();
				double PorcMenosMil=0;
				double PorcMenosDiezMil=0;
				double PorcMasDiezMil=0;
				
				ArrayList<MovimientoCuentas> listaMovTotal = MDao.obtenerMovimientosTotales();
				ArrayList<MovimientoCuentas> listaMenosMil = MDao.obtenerMovimientosMenosMil();
				ArrayList<MovimientoCuentas> listaMenosDiezMil = MDao.obtenerMovimientosMenosDiezMil();
				ArrayList<MovimientoCuentas> listaMasDiezMil = MDao.obtenerMovimientosMasDiezMil();
				int MovTotales=listaMovTotal.size();
				int MovMenosMil=listaMenosMil.size();
				int MovimientosMenosDiezMil=listaMenosDiezMil.size();
				int MovimientosmasDiezMil=listaMasDiezMil.size();
				if(MovTotales !=0) {
				 PorcMenosMil=((double)MovMenosMil/MovTotales)*100;
				 PorcMenosDiezMil=((double)MovimientosMenosDiezMil/MovTotales)*100;
				 PorcMasDiezMil=((double)MovimientosmasDiezMil/MovTotales)*100;
				}
				
				
				request.setAttribute("MenosMil", PorcMenosMil);
				request.setAttribute("MenosDiezMil", PorcMenosDiezMil);
				request.setAttribute("MasDiezMil", PorcMasDiezMil);
				request.setAttribute("Total", MovTotales);
				
				//request.setAttribute("listaC", listaEst);
				
				
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");
				rd.forward(request, response);
	    		 
	    	
		 }
		 
		 if(request.getParameter("BotonMostrarTodo")!=null) {
			 cuentaDaoImpl sDao = new cuentaDaoImpl();
	        	ArrayList<Cuenta> lista = sDao.obtenerCuenta();
	        	
	        	request.setAttribute("listaC", lista);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoCuentas.jsp");
	            rd.forward(request, response);
	    		 
	    		 
	    	}
		 
		 if(request.getParameter("BotonMostrarTodoReporte")!=null) {
			 cuentaDaoImpl sDao = new cuentaDaoImpl();
	        	ArrayList<Cuenta> lista = sDao.obtenerCuenta();
	        	
	        	
				
				ArrayList<Cuenta> listaEst = sDao.obtenerCuenta();
				MovimientosDaoImpl MDao=new MovimientosDaoImpl();
				double PorcMenosMil=0;
				double PorcMenosDiezMil=0;
				double PorcMasDiezMil=0;
				
				ArrayList<MovimientoCuentas> listaMovTotal = MDao.obtenerMovimientosTotales();
				ArrayList<MovimientoCuentas> listaMenosMil = MDao.obtenerMovimientosMenosMil();
				ArrayList<MovimientoCuentas> listaMenosDiezMil = MDao.obtenerMovimientosMenosDiezMil();
				ArrayList<MovimientoCuentas> listaMasDiezMil = MDao.obtenerMovimientosMasDiezMil();
				int MovTotales=listaMovTotal.size();
				int MovMenosMil=listaMenosMil.size();
				int MovimientosMenosDiezMil=listaMenosDiezMil.size();
				int MovimientosmasDiezMil=listaMasDiezMil.size();
				if(MovTotales !=0) {
				 PorcMenosMil=((double)MovMenosMil/MovTotales)*100;
				 PorcMenosDiezMil=((double)MovimientosMenosDiezMil/MovTotales)*100;
				 PorcMasDiezMil=((double)MovimientosmasDiezMil/MovTotales)*100;
				}
				
				
				request.setAttribute("MenosMil", PorcMenosMil);
				request.setAttribute("MenosDiezMil", PorcMenosDiezMil);
				request.setAttribute("MasDiezMil", PorcMasDiezMil);
				request.setAttribute("Total", MovTotales);
	        	
	        	
	        	request.setAttribute("listaC", lista);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");
	            rd.forward(request, response);
	    		 
	    		 
	    	}
		 
		 if (request.getParameter("Param3") != null) {
			 HttpSession session = request.getSession();
		        session.removeAttribute("sessionNombreCuenta");
				cuentaDaoImpl cuentaDao = new cuentaDaoImpl(); 
				String DNI= cuentaDao.GetNumCuentaByUsuario(request.getSession().getAttribute("sessionNombre").toString());
			
				ArrayList<Cuenta> lista = cuentaDao.obtenerCuentaByDNI(DNI);
				
				request.setAttribute("listaC", lista);
				
				RequestDispatcher rd = request.getRequestDispatcher("/elegirCuenta.jsp");
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
