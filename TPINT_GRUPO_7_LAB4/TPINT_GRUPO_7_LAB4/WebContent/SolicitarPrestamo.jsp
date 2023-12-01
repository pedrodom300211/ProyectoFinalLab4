<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitar Prestamo</title>

</head>
<form action="servletsPrestamo" method="get">
<body>
<h3>Usuario Logueado:  <%=request.getSession().getAttribute("sessionNombre").toString()%></h3><br>
<h3>Esta en la cuenta:  <%=request.getSession().getAttribute("sessionNombreCuenta").toString()%></h3><br>
<a href="PagoPrestamos.jsp" >Pago prestamos</a>
<a href="Transferencias.jsp" >Transferencias</a>
<a href="SolicitarPrestamo.jsp" >Solicitar prestamo</a>
<a href="servletMovimientoCuentas?Param5=1" >Movimientos de la cuenta</a>
<a href="servletCliente?Param2=1" >Datos personales</a>
<a href="servletCuenta?Param3=1">Cambiar de cuenta</a>
<a href="CerrarSesion">Cerrar sesión</a><br>
Solicitar Prestamo<br>
Numero cuenta: <%=request.getSession().getAttribute("sessionNombreCuenta").toString()%><br>
Ingrese monto del prestamo <input type="text" name="txtMontoPrestamo"><br>
Ingrese la cantidad de cuotas del prestamo <input type="text" name="txtCuotasPrestamo"><br>
<input type="submit" name="BotonSolicitarPrestamo" value="Solicitar Prestamo" ><br>

<% int filas = 0; 
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		
		
 %>
<%if(filas==1) 
	{
%>
		Prestamo agregado con éxito
<%}else if (filas == -1) { %>
Prestamo no registrado,hay campos invalidos
<% }%>

</body>
</form>
</html>