<%@page import="Entidad.Cuenta"%>   

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Modificacion Cuenta</title>
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
            document.getElementsByName("txtDniModificacionCuenta")[0].value = "";
            document.getElementsByName("txtCBUModificacionCuenta")[0].value = "";
            document.getElementsByName("txtFechaCreacionModificacionCuenta")[0].value = "";
            document.getElementsByName("txtSaldoCuentaModificacionCuenta")[0].value = "";
        }
    </script>

Bienvenido Admin a Modificacion Cuenta<br>
<%
	Cuenta cuenta = null;
	if(request.getAttribute("cuenta")!=null){
	
		cuenta  = (Cuenta)request.getAttribute("cuenta");
	}
%>

<form action="servletCuenta" method="get">
	<% if (cuenta != null) { %>
		Numero de cuenta:<%= cuenta.getNumeroDeCuenta()%>
		<input type="hidden" name="txtNumCuentaModificacionCuenta" value="<%=cuenta.getNumeroDeCuenta()%>">
		
		<br>
		DNI: <%=cuenta.getDNICliente_Cuenta()%><br>
		CBU: <input type="text" name="txtCBUModificacionCuenta" value="<%=cuenta.getCBU()%>"><br>
		Tipo de Cuenta: <select name="ddlTiposCuentasModificacionCuentas" id="TiposCuentas">
								<option value=1>Caja de ahorro</option>
								<option value=2>Cuenta corriente</option>
						</select><br>
		Fecha de Creacion: <input type="date" name="txtFechaCreacionModificacionCuenta" value="<%=cuenta.getFechaDeCreacion()%>"><br>
		        
		Saldo: <input type="text" name="txtSaldoCuentaModificacionCuenta"value="<%=cuenta.getSaldo()%>"><br>
		<input type="submit" name="BotonAceptarModificacionCuenta" value="Modificar" >
	<% }%>
</form>

<% int filas = 0; 
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		
		
 %>
 
  <%
  if(filas==-1) 
	{
%>
		Datos vacios
<%} %>
 
 <% if(filas==1) 
	{
%>
		Cuenta actualizada con éxito
		<script>
            borrarCampoTexto();
        </script>
<%} %>

</body>
</html>