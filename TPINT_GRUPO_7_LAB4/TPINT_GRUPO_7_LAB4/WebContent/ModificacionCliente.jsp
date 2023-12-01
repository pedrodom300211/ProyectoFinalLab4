<%@page import="Entidad.Cliente"%>   

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Modificacion Cliente</title>
</head>
<body>
<h3>Usuario Logueado:  <%=request.getSession().getAttribute("sessionNombre").toString()%></h3><br>
<a href="AltaCliente.jsp" >Agregar Cliente</a>
<a href="AltaCuenta.jsp" >Agregar Cuenta</a>
<a href="servletCliente?Param=1" >Listar Cliente</a>
<a href="servletCuenta?Param=1" >Listar Cuenta</a>
<a href="BajaCliente.jsp" >Baja Cliente</a>
<a href="BajaCuenta.jsp" >Baja Cuenta</a>
<a href="servletsPrestamo?Param=1" >Autorizar Prestamos</a>
<a href="servletCuenta?Reporte=1" >Reportes/Estadisticas</a>
<a href="CerrarSesion">Cerrar sesión</a><br>

 <script>
        function borrarCampoTexto() {
            document.getElementsByName("txtNombreModificacionCLiente")[0].value = "";
            document.getElementsByName("txtApellidoModificacionCliente")[0].value = "";
            document.getElementsByName("txtTipoUsuarioModificacionCliente")[0].value = "";
            document.getElementsByName("txtSexoModificacionCLiente")[0].value = "";
            document.getElementsByName("txtCorreoModificacionCLiente")[0].value = "";
            document.getElementsByName("txtNacionalidadModificacionCLiente")[0].value = "";
            document.getElementsByName("txtFechaNacimientoModificacionCLiente")[0].value = "";
            document.getElementsByName("txtDireccionModificacionCLiente")[0].value = "";
            document.getElementsByName("txtLocalidadModificacionCLiente")[0].value = "";
            document.getElementsByName("txtProvinciaModificacionCLiente")[0].value = "";
            document.getElementsByName("txtTelefonoModificacionCLiente")[0].value = "";
            document.getElementsByName("txtNombreUsuarioModificacionCLiente")[0].value = "";
            document.getElementsByName("txtContrasenaModificacionCLiente")[0].value = "";
            
        }
    </script>
Bienvenido Admin a Modificacion Cliente<br>
<%
	Cliente cliente = null;
	if(request.getAttribute("cliente")!=null){
	
		cliente  = (Cliente)request.getAttribute("cliente");
	}
%>

	<% if (cliente != null) { %>
	<form action="servletCliente" method="get">
    	Dni de Cliente:  <%= cliente.getDNICliente()%>
    	<input type="hidden" name="txtDniModificacionCLiente" value="<%=cliente.getDNICliente()%>">
		<br>
		Nombre: <input type="text" name="txtNombreModificacionCLiente" value="<%=cliente.getNombre()%>"><br>
		Apellido: <input type="text" name="txtApellidoModificacionCliente" value="<%=cliente.getApellido()%>"><br>
		Tipo Usuario:<select name="txtTipoUsuarioModificacionCliente" id="TiposCliente">
		<option value="0">Cliente</option>
		<option value="1">Banco</option>
	
	</select><br>
		Sexo: <select name="txtSexoModificacionCLiente" id="Sexo">
	<option value="M">Masculino</option>
	<option value="F">Femenino</option>
	</select><br>
		Correo<input type="text" name="txtCorreoModificacionCLiente" value="<%=cliente.getCorreoElectronico()%>"><br>
		Nacionalidad<input type="text" name="txtNacionalidadModificacionCLiente" value="<%=cliente.getNacionalidad()%>"><br>
		Fecha de Nacimiento<input type="date" name="txtFechaNacimientoModificacionCLiente" value="<%=cliente.getFechaNacimiento()%>"><br>
		Direccion<input type="text" name="txtDireccionModificacionCLiente" value="<%=cliente.getDireccion()%>"><br>
		Localidad<input type="text" name="txtLocalidadModificacionCLiente" value="<%=cliente.getLocalidad()%>"><br>
		Provincia
		<select name="txtProvinciaModificacionCLiente" id="Provincia">
	<option value="Buenos Aires">Buenos Aires</option>
	<option value="Ciudad Autónoma de Buenos Aires">Ciudad Autónoma de Buenos Aires</option>
	<option value="Catamarca">Catamarca</option>
	<option value="Catamarca">Catamarca</option>
	<option value="Chaco">Chaco</option>
	<option value="Chubut">Chubut</option>
	<option value="Córdoba">Córdoba</option>
	<option value="Corrientes">Corrientes</option>
	<option value="Entre Ríos">Entre Ríos</option>
	<option value="Formosa">Formosa</option>
	<option value="Jujuy">Jujuy</option>
	<option value="La Pampa">La Pampa</option>
	<option value="La Rioja">La Rioja</option>
	<option value="Mendoza">Mendoza</option>
	<option value="Misiones">Misiones</option>
	<option value="Neuquén">Neuquén</option>
	<option value="Río Negro">Río Negro</option>
	<option value="Salta">Salta</option>
	<option value="San Juan">San Juan</option>
	<option value="San Luis">San Luis</option>
	<option value="Santa Cruz">Santa Cruz</option>
	<option value="Santa Fe">Santa Fe</option>
	<option value="Santiago del Estero">Santiago del Estero</option>
	<option value="Tierra del Fuego, Antártida e Islas del Atlántico Sur">Tierra del Fuego, Antártida e Islas del Atlántico Sur</option>
	<option value="Tucumán">Tucumán</option>
	</select><br>
		Telefono<input type="text" name="txtTelefonoModificacionCLiente" value="<%=cliente.getTelefono()%>"><br>
		Nombre de Usuario: <%=cliente.getNombreUsuario()%><br>
		Contraseña: <input type="text" name="txtContrasenaModificacionCLiente" value="<%=cliente.getContrasenaUsuario()%>"><br>
		<input type="submit" name="BotonAceptarModificacionCliente" value="Aceptar" >
	<% }%>
	
</form>

<% int filas = 0; 
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		
		
		
 %>
 
  <% if(filas==-1) 
	{
%>
		
		
		Hay campos vacios
		
	
<%} %>
 
 
 <% if(filas==1) 
	{
%>
		
		
		Cliente actualizado con éxito
		<script>
            borrarCampoTexto();
        </script>
		
	
<%} %>
</body>
   
</body>

</html>
