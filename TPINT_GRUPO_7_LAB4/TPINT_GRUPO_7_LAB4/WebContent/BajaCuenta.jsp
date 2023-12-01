<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baja Cuenta</title>

<script>
        function confirmarEliminar() {
            return confirm("¿Estás seguro de que quieres eliminar esta cuenta?");
        }
    </script>

</head>
<body>
<form action="servletCuenta" method="get">
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
Bienvenido Admin a Baja Cuenta<br>

Ingrese numero de cuenta a eliminar <input type="text" name="txtCodBajaCuenta"><br>
<input type="submit" name="BotonAceptarBajaCuenta" value="Aceptar" onclick="return confirmarEliminar();">
</form>
<% int filas = 0; 
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		
		
 %>
 
 
 <% if(filas==1) 
	{
%>
		Cuenta eliminada con éxito
<%}
 else if(filas==-1){%>
 
         Código inválido
<%}
 %>
</body>
</html>