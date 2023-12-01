<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Cliente</title>
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
<form action="servletCliente" method="get">
	<br>
	Bienvenido Admin a Alta Cliente<br>
	DNI: <input type="text" name="txtDniAltaCLiente"><br>
	Nombre: <input type="text" name="txtNombreAltaCLiente"><br>
	Apellido: <input type="text" name="txtApellidoAltaCliente"><br>
	Tipo de cliente: <select name="txtTipoClienteAltaCliente" id="TiposCliente">
	<option value="0">Cliente</option>
	<option value="1">Banco</option>
	</select><br>
	Sexo: <select name="txtSexoAltaCLiente" id="Sexo">
	<option value="M">Masculino</option>
	<option value="F">Femenino</option>
	</select><br>
	Correo Electronico: <input type="text" name="txtCorreoElectronicoAltaCLiente"><br>
	Nacionalidad: <input type="text" name="txtNacionalidadAltaCLiente"><br>
	Fecha de Nacimiento: <input type="date" name="txtFechaNacimientoAltaCliente"><br>
	Direccion: <input type="text" name="txtDireccionAltaCLiente"><br>
	Localidad: <input type="text" name="txtLocalidadAltaCLiente"><br>
	Provincia: <select name="txtprovinciaAltaCLiente" id="Provincia">
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
	Telefono: <input type="text" name="txtTelefonoAltaCLiente"><br>
	Nombre Usuario: <input type="text" name="txtNombreUsuarioAltaCLiente"><br>
	Contraseña Usuario: <input type="password" name="txtContrasenaUsuarioAltaCLiente"><br>
	Confirmar Contraseña: <input type="password" name="txtConfirmarSContrasenaUsuarioAltaCLiente"><br>
	<input type="submit" name="BotonAceptarAltaCliente" value="Aceptar" >
</form>



<% int filas = 0; 
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		
		
 %>
<% if (filas == 1) { %>
    Cliente agregado con éxito
<% } else if (filas == -1) { %>
    Cliente no agregado,hay campos invalidos
<% } else if (filas == -2) { %>
    DNI invalido, ya existe cliente con ese DNI
<% }else if (filas == -4) { %>
Las Contraseñas no son iguales
<% } %>
</body>
</body>
</html>