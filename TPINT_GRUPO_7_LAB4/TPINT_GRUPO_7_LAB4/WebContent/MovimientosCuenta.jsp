<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList"%>
<%@page import="Entidad.MovimientoCuentas"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movimientos Cuenta</title>

</head>
<body>
<h3>Usuario Logueado:  <%=request.getSession().getAttribute("sessionNombre").toString()%></h3><br>
<h3>Numero de cuenta: <%=request.getSession().getAttribute("sessionNombreCuenta").toString()%></h3>
<a href="servletsPrestamo?Param2=1" >Pago prestamos</a>
<a href="Transferencias.jsp" >Transferencias</a>
<a href="SolicitarPrestamo.jsp" >Solicitar prestamo</a>
<a href="servletMovimientoCuentas?Param5=1" >Movimientos de la cuenta</a>
<a href="servletCliente?Param2=1" >Datos personales</a>
<a href="servletCuenta?Param3=1">Cambiar de cuenta</a>
<a href="CerrarSesion">Cerrar sesión</a><br>
Bienvenido a Movimientos Cuenta<br>
<br>
<%


ArrayList<MovimientoCuentas> Lista = null;
if(request.getAttribute("listaM")!=null){


	Lista = (ArrayList<MovimientoCuentas>) request.getAttribute("listaM");
}
 %>
<form action="servletMovimientoCuentas" method="get">
Numero de cuenta:  <%=request.getSession().getAttribute("sessionNombreCuenta").toString()%><br>
<h1>Esta en la cuenta:  <%=request.getSession().getAttribute("sessionNombreCuenta").toString()%></h1><br>
<br>

<br>
<br>

	<table border="1">
        <tr>
        	<th>Numero de Movimiento</th>
            <th>Numero de cuenta</th>
            <th>Cuenta a la que se envio</th>
            <th>Monto </th>
            <th>Fecha</th>
            <th>Detalle</th>
            <th>Tipo de movimiento</th>
            <%if(Lista!=null)
		for(MovimientoCuentas MovCuenta : Lista){
	
		 %>
		 	<tr> 
		 	
			 	<td><%=MovCuenta.getNumeroMovimiento() %><input type="hidden" name="NumeroMovimiento" value="<%=MovCuenta.getNumeroMovimiento()%>"></td>
			 	<td><%=MovCuenta.getNumeroCuentaEmisor()%></td>
			 	<td><%=MovCuenta.getNumeroCunetaReceptor()%></td>
			 	<td><%=MovCuenta.getMonto()%></td>
			 	<td><%=MovCuenta.getFechaMovimiento()%></td>
			 	<td><%=MovCuenta.getDetalleMovimiento()%></td>
			 	<td><%=MovCuenta.getTipoMovimiento()%></td>
		 		
		 	
 		<%}%>
           
            
        </tr>
        
       
	</table>

</body>
</form>
</html>