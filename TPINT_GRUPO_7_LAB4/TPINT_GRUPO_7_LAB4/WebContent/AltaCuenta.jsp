<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Cuenta</title>
</head>
<body>
<h3>Usuario Logueado:  <%=request.getSession().getAttribute("sessionNombre").toString()%></h3><br>

<form action="servletCuenta" method="get">
<a href="AltaCliente.jsp" >Agregar Cliente</a>
<a href="AltaCuenta.jsp" >Agregar Cuenta</a>
<a href="servletCliente?Param=1" >Listar Cliente</a>
<a href="servletCuenta?Param=1" >Listar Cuenta</a>
<a href="BajaCliente.jsp" >Baja Cliente</a>
<a href="BajaCuenta.jsp" >Baja Cuenta</a>
<a href="servletsPrestamo?Param=1" >Autorizar Prestamos</a>
<a href="servletCuenta?Reporte=1" >Reportes/Estadisticas</a>
<a href="CerrarSesion">Cerrar sesión</a><br>
Bienvenido Admin a Alta de cuentas<br>

Numero de cuenta:<br>
DNI: <input type="text" name="txtDniAltaCuenta"><br>
CBU: <input type="text" name="txtCBUAltaCuenta"><br>
Tipo de Cuenta: <select name="ddlTiposCuentasAltaCuentas" id="TiposCuentas">
<option value=1>Caja de ahorro</option>
<option value=2>Cuenta corriente</option>
</select><br>
        
Saldo inicial: $10.000<br><br>
<input type="submit" name="BotonAceptarAltaCuenta" value="Aceptar" >
</form>

<% int filas = 0; 
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		
		
 %>
 
 <% if(filas==1) 
	{
%>
		Cuenta agregada con éxito
<%} %><% else if(filas==-1)
	{
%> Cuenta no agregada,Hay campos invalidos
<%} %><% else if(filas==-2)
	{
%> Cuenta no agregada,Cliente Ya tiene maximo de cuentas posibles
<%} %>
</body>
</html>