package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cliente;
import Entidad.Cuenta;
import Entidad.TipoCliente;
import Excepciones.DniIncorrectoException;
import dao.ClienteDao;
import daoImpl.MovimientosDaoImpl;
import daoImpl.clienteDaoImpl;
import daoImpl.cuentaDaoImpl;



/**
 * Servlet implementation class servletCliente
 */
@WebServlet("/servletCliente")
public class servletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DniIncorrectoException {

    	
		if(request.getParameter("BotonAceptarLogin")!=null)
		 {
			int bandera=4;
			 clienteDaoImpl usuario = new clienteDaoImpl();
			 bandera = usuario.ObtenerUsuario(request.getParameter("txtContrasenaLogIn"), request.getParameter("txtUsuarioLogIn"));
			 request.setAttribute("bandera", bandera);
			 
			 
			 if(bandera !=4) {
			 if ((request.getSession().getAttribute("sessionNombre"))==null) {
				 request.getSession().setAttribute("sessionNombre", request.getParameter("txtUsuarioLogIn").toString());
				 //System.out.println(request.getSession().getAttribute("sessionNombre"));
				 String sess = request.getSession().getAttribute("sessionNombre").toString();
				
			 }
			 }
			 if(bandera==0) {
				 
				 cuentaDaoImpl cuentaDao = new cuentaDaoImpl(); 
					String DNI= cuentaDao.GetNumCuentaByUsuario(request.getSession().getAttribute("sessionNombre").toString());
				
					ArrayList<Cuenta> lista = cuentaDao.obtenerCuentaByDNI(DNI);
					
					request.setAttribute("listaC", lista);
					
					RequestDispatcher rd = request.getRequestDispatcher("/elegirCuenta.jsp");
					rd.forward(request, response);
			 }else {
				 RequestDispatcher rd = request.getRequestDispatcher("/LogIn.jsp");
			     rd.forward(request, response);
			 }
			 
			  
			 
			 
			 
		 }
	 
		if(request.getParameter("Param")!=null) {
    		clienteDaoImpl sDao = new clienteDaoImpl();
        	ArrayList<Cliente> lista = sDao.ObtenerClientes();
        	
        	
        	request.setAttribute("listaC", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoClientes.jsp");
            rd.forward(request, response);
    		 
    		 
    	}
		if(request.getParameter("Param2")!=null) {
    		clienteDaoImpl sDao = new clienteDaoImpl();
    		cuentaDaoImpl cuenta = new cuentaDaoImpl();
    		String DNI=cuenta.GetDNIByNumeroCuenta(request.getSession().getAttribute("sessionNombreCuenta").toString());
    		Cliente c = sDao.GetByDni2(DNI);///Aca va variable session
    		
        	ArrayList<Cliente> lista = new ArrayList<>();
        	lista.add(c);
        	
        	request.setAttribute("listaCL", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/DatosPersonales.jsp");
            rd.forward(request, response);
    		 
    		 
    	}
		
		if(request.getParameter("BotonMostrarTodo")!=null) {
    		clienteDaoImpl sDao = new clienteDaoImpl();
        	ArrayList<Cliente> lista = sDao.ObtenerClientes();
        	
        	request.setAttribute("listaC", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoClientes.jsp");
            rd.forward(request, response);
    		 
    		 
    	}
		
		if(request.getParameter("BotonFiltrarDocumento")!=null) {
			ArrayList<Cliente> lista;
			if(request.getParameter("txtDNIFiltrado")==""||(!request.getParameter("txtDNIFiltrado").matches("[0-9]+"))) {
				lista=null;
	    throw new DniIncorrectoException();
			}else {
    		clienteDaoImpl sDao = new clienteDaoImpl();
    		int num = Integer.parseInt(request.getParameter("txtDNIFiltrado"));
    		lista = sDao.ObtenerClientesFiltrados(num);
			}
        	request.setAttribute("listaC", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoClientes.jsp");
            rd.forward(request, response);
    		 
    		 
    	}
		
		
		if(request.getParameter("BotonFiltrarValor")!=null) {
			ArrayList<Cliente> lista;
			if(request.getParameter("txtSegundoValor")==""||(!request.getParameter("txtSegundoValor").matches("[0-9]+"))) {
				lista=null;
	    
			}else {
    		clienteDaoImpl sDao = new clienteDaoImpl();
    		int num = Integer.parseInt(request.getParameter("txtSegundoValor"));
    		lista = sDao.ObtenerClientesFiltro(request.getParameter("txtValor"),request.getParameter("txtSimbolo"),Integer.parseInt(request.getParameter("txtSegundoValor")));
    		
    		
			}
        	request.setAttribute("listaC", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoClientes.jsp");
            rd.forward(request, response);
    		 
    		 
    	}
		
		
		
		if(request.getParameter("btnModificarCliente")!=null)
		{
			String Dni = request.getParameter("dniCliente");
			clienteDaoImpl cDao = new clienteDaoImpl();
			
			Cliente cliente = cDao.GetByDni(Dni);			
			
			request.setAttribute("cliente", cliente);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModificacionCliente.jsp");
            rd.forward(request, response);
		}
		
		if(request.getParameter("BotonAceptarModificacionCliente")!=null)
		{
			String Dni = request.getParameter("txtDniModificacionCLiente");
			Cliente cliente = new Cliente();
			clienteDaoImpl cDao = new clienteDaoImpl();
			int filas = 0; 
			if((!request.getParameter("txtDniModificacionCLiente").matches("[0-9]+")) ||(request.getParameter("txtNacionalidadModificacionCLiente").matches("[0-9]+"))||(!request.getParameter("txtTelefonoModificacionCLiente").matches("[0-9]+"))  ||(request.getParameter("txtLocalidadModificacionCLiente").matches("[0-9]+"))|| request.getParameter("txtDniModificacionCLiente")=="" || request.getParameter("txtNombreModificacionCLiente")=="" || request.getParameter("txtApellidoModificacionCliente")=="" || request.getParameter("txtCorreoModificacionCLiente")==""|| request.getParameter("txtNacionalidadModificacionCLiente")=="" || request.getParameter("txtFechaNacimientoModificacionCLiente") ==null || request.getParameter("txtDireccionModificacionCLiente")=="" || request.getParameter("txtLocalidadModificacionCLiente")==""||request.getParameter("txtTelefonoModificacionCLiente")=="" || request.getParameter("txtContrasenaModificacionCLiente" )=="")
			 {filas=-1;
				 
			 } else {
				 
				 	TipoCliente tC=new TipoCliente();
					tC.setNumeroTipoCliente(Integer.parseInt(request.getParameter("txtTipoUsuarioModificacionCliente")));
					if(tC.getNumeroTipoCliente()==1)
					{
						tC.setDescripcionTipoCliente("Admin");
						
					}else{tC.setDescripcionTipoCliente("Cliente");}
										
					cliente.setDNICliente(request.getParameter("txtDniModificacionCLiente"));
					cliente.setNombre(request.getParameter("txtNombreModificacionCLiente"));
					cliente.setApellido(request.getParameter("txtApellidoModificacionCliente"));
					cliente.setTipoCliente(tC);
					cliente.setSexo(request.getParameter("txtSexoModificacionCLiente"));
					cliente.setCorreoElectronico(request.getParameter("txtCorreoModificacionCLiente"));
					cliente.setNacionalidad(request.getParameter("txtNacionalidadModificacionCLiente"));
					cliente.setFechaNacimiento(request.getParameter("txtFechaNacimientoModificacionCLiente"));
					cliente.setDireccion(request.getParameter("txtDireccionModificacionCLiente"));
					cliente.setLocalidad(request.getParameter("txtLocalidadModificacionCLiente"));
					cliente.setProvincia(request.getParameter("txtProvinciaModificacionCLiente"));
					cliente.setTelefono(request.getParameter("txtTelefonoModificacionCLiente"));
					cliente.setNombreUsuario(request.getParameter("txtNombreUsuarioModificacionCLiente"));
					cliente.setContrasenaUsuario(request.getParameter("txtContrasenaModificacionCLiente"));
			 
					filas=0;
					
					filas=cDao.ActualizarCliente(cliente, request.getParameter("txtDniModificacionCLiente"));
					request.setAttribute("cantFilas", filas);
					request.setAttribute("cliente", cliente);
					
					clienteDaoImpl sDao = new clienteDaoImpl();
		        	ArrayList<Cliente> lista = sDao.ObtenerClientes();
		        	request.setAttribute("listaC", lista);
		        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoClientes.jsp");
				    rd.forward(request, response);
			 }
			
			if (filas == -1) {
				
				
				cliente = cDao.GetByDni(Dni);
				
				request.setAttribute("cliente", cliente);
				request.setAttribute("cantFilas", filas);
				RequestDispatcher rd = request.getRequestDispatcher("/ModificacionCliente.jsp");
	            rd.forward(request, response);
				
				
			}
			
			
		}
		
		
		int filas = 0;
	 if(request.getParameter("BotonAceptarAltaCliente")!=null)
	 {	Cliente c = new Cliente();
	
	 TipoCliente tC=new TipoCliente();
	 clienteDaoImpl cDao = new clienteDaoImpl();
	 
		 if(request.getParameter("txtDniAltaCLiente")=="" ||(!request.getParameter("txtDniAltaCLiente").matches("[0-9]+"))|| (!request.getParameter("txtDniAltaCLiente").matches("[0-9]+"))|| (request.getParameter("txtNombreAltaCLiente").matches("[0-9]+"))||(request.getParameter("txtApellidoAltaCliente").matches("[0-9]+"))|| request.getParameter("txtNombreAltaCLiente")=="" || request.getParameter("txtApellidoAltaCliente")=="" || request.getParameter("txtTipoClienteAltaCliente")=="" || request.getParameter("txtSexoAltaCLiente")==""|| request.getParameter("txtCorreoElectronicoAltaCLiente")==""|| request.getParameter("txtNacionalidadAltaCLiente")=="" || request.getParameter("txtFechaNacimientoAltaCliente") =="" || request.getParameter("txtDireccionAltaCLiente")=="" || request.getParameter("txtLocalidadAltaCLiente")==""||request.getParameter("txtprovinciaAltaCLiente")==""||request.getParameter("txtTelefonoAltaCLiente")=="" || request.getParameter("txtNombreUsuarioAltaCLiente")=="" || request.getParameter("txtContrasenaUsuarioAltaCLiente" )=="")
		 {filas=-1;
		 }else if(!request.getParameter("txtContrasenaUsuarioAltaCLiente").equals( request.getParameter("txtConfirmarSContrasenaUsuarioAltaCLiente"))) {
			 filas=-4;
		 } 
		 else { 
		 
			tC.setNumeroTipoCliente(Integer.parseInt(request.getParameter("txtTipoClienteAltaCliente")));
		c.setDNICliente(request.getParameter("txtDniAltaCLiente"));
		c.setNombre(request.getParameter("txtNombreAltaCLiente"));
		c.setApellido(request.getParameter("txtApellidoAltaCliente"));
		c.setTipoCliente(tC);
		c.setSexo(request.getParameter("txtSexoAltaCLiente"));
		c.setCorreoElectronico(request.getParameter("txtCorreoElectronicoAltaCLiente"));
		c.setNacionalidad(request.getParameter("txtNacionalidadAltaCLiente"));
		c.setFechaNacimiento(request.getParameter("txtFechaNacimientoAltaCliente"));
		c.setDireccion(request.getParameter("txtDireccionAltaCLiente"));
		c.setLocalidad(request.getParameter("txtLocalidadAltaCLiente"));
		c.setProvincia(request.getParameter("txtprovinciaAltaCLiente"));
		c.setTelefono(request.getParameter("txtTelefonoAltaCLiente"));
		c.setNombreUsuario(request.getParameter("txtNombreUsuarioAltaCLiente"));
		c.setContrasenaUsuario(request.getParameter("txtContrasenaUsuarioAltaCLiente"));
		 
		
		
		 
		 filas=cDao.agregarCliente(c);
	 }
		 request.setAttribute("cantFilas", filas);
		 
		 RequestDispatcher rd = request.getRequestDispatcher("/AltaCliente.jsp");
	     rd.forward(request, response);
	 }
	 
	 if(request.getParameter("BotonAceptarBajaCliente")!=null)
	 {
		 
		 if(request.getParameter("txtDNIBajaCliente")!=null&&request.getParameter("txtDNIBajaCliente").matches("[0-9]+")) {	
		 clienteDaoImpl clDao = new clienteDaoImpl();
		 filas=clDao.eliminarCliente(request.getParameter("txtDNIBajaCliente"));
		 request.setAttribute("cantFilas", filas);
		 
		 RequestDispatcher rd = request.getRequestDispatcher("/BajaCliente.jsp");
	     rd.forward(request, response);
	     
		 }
		 else {
			 if(request.getParameter("txtDNIBajaCliente")==null||(!request.getParameter("txtDNIBajaCliente").matches("[0-9]+"))) {
				 
				 filas=-1;
				 request.setAttribute("cantFilas", filas);
				 
				 RequestDispatcher rd = request.getRequestDispatcher("/BajaCliente.jsp");
			     rd.forward(request, response);
			 }
				 
		 }
		 
	 }
	 
	 
	 

	 
	 
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*if(request.getParameter("btnFiltrar")!=null) {
        	clienteDaoImpl sDao = new clienteDaoImpl();
        	ArrayList<Cliente> lista = sDao.ObtenerClientes();
        	
        	request.setAttribute("listaC", lista);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
            rd.forward(request, response);
        }*/
	}

}