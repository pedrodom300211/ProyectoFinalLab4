<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transferencias</title>

<script>
        function confirmarTransferir() {
            return confirm("¿Estás seguro de que quieres transferir a esta cuenta?");
        }
    </script>

</head>
<form action="servletCuenta" method="get">
<body>

<%/*System.out.println(request.getSession().getAttribute("sessionNombre").toString())*/%>
<h3>Usuario Logueado:  <%=request.getSession().getAttribute("sessionNombre").toString()%></h3><br>
<h3>Esta en la cuenta:  <%=request.getSession().getAttribute("sessionNombreCuenta").toString()%></h3><br>
<a href="PagoPrestamos.jsp" >Pago prestamos</a>
<a href="Transferencias.jsp" >Transferencias</a>
<a href="SolicitarPrestamo.jsp" >Solicitar prestamo</a>
<a href="servletMovimientoCuentas?Param5=1" >Movimientos de la cuenta</a>
<a href="servletCliente?Param2=1" >Datos personales</a>
<a href="servletCuenta?Param3=1">Cambiar de cuenta</a>
<a href="CerrarSesion">Cerrar sesión</a><br>
Bienvenido Transferencias<br>
Numero de cuenta: <%=request.getSession().getAttribute("sessionNombreCuenta").toString()%><br>
Ingrese numero de CBU a transferir <input type="text" name="txtCBUTransferir"><br>
Ingrese monto a transferir <input type="text" name="txtMontoTransferir"><br>
Ingrese el detalle: <input type="text" name="txtDetalleTransferencia"><br>
Ingrese Tipo de Tranferencia <input type="text" name="txtTipoTransferencia"><br>
<input type="submit" name="BotonAceptarTransferir" value="Aceptar" onclick="return confirmarTransferir();">
</form>
<% int filas = 0; 
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		
		
 %>
 
<% if (filas == 1) { %>
    Transferencia realizada con éxito
<% } else if (filas == -1) { %>
    Transferencia no realizada, hay campos invalidos
<% } else if (filas == -2) { %>
    Transferencia no realizada, saldo insuficiente
<% } else if (filas == -3) { %>
    Transferencia no realizada,No Existe ese CBU
<% } %>
</body>

</html>