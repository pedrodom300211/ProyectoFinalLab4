<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Cliente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Usuario Logueado:  <%=request.getSession().getAttribute("sessionNombre").toString()%></h3><br>
<h3>Esta en la cuenta:  <%=request.getSession().getAttribute("sessionNombreCuenta").toString()%></h3><br>
<form action="servletCliente" method="get">
<a href="PagoPrestamos.jsp" >Pago prestamos</a>
<a href="Transferencias.jsp" >Transferencias</a>
<a href="SolicitarPrestamo.jsp" >Solicitar prestamo</a>
<a href="servletMovimientoCuentas?Param5=1" >Movimientos de la cuenta</a>
<a href="servletCliente?Param2=1" >Datos personales</a>
<a href="servletCuenta?Param3=1">Cambiar de cuenta</a>
<a href="CerrarSesion">Cerrar sesión</a><br>
Bienvenido a los datos personales del cliente<br>
<%--faltan filtros--%> 
<%


ArrayList<Cliente> Lista = null;
if(request.getAttribute("listaCL")!=null){


	Lista = (ArrayList<Cliente>) request.getAttribute("listaCL");
}
 %>
<table border="1">
        <tr>
            <th>DNI</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Sexo</th>
            <th>Correo electronico</th>
            <th>Nacionalidad</th>
            <th>Fecha nacimiento</th>
            <th>Direccion</th>
            <th>Localidad</th>
            <th>Provincia</th>
            <th>Telefnono</th>
            <th>Nombre de usuario</th>
            <th>Contraseña</th>
        </tr>
        <tr>
            <%if(Lista!=null)
	for(Cliente cliente : Lista){

	 %>
 		<tr> 
 			
 				<td><%=cliente.getDNICliente()%> <input type="hidden" name="dniCliente" value="<%=cliente.getDNICliente()%>"> </td>
 				<td><%=cliente.getNombre()%></td>
 				<td><%=cliente.getApellido()%></td>
 				<td><%=cliente.getSexo()%></td>
 				<td><%=cliente.getCorreoElectronico()%></td>
 				<td><%=cliente.getNacionalidad()%></td>
 				<td><%=cliente.getFechaNacimiento()%></td>
 				<td><%=cliente.getDireccion()%></td>
 				<td><%=cliente.getLocalidad()%></td>
 				<td><%=cliente.getProvincia()%></td>
 				<td><%=cliente.getTelefono()%></td>
 				<td><%=cliente.getNombreUsuario()%></td>
 				<td><%=cliente.getContrasenaUsuario()%></td>
 				
 			
 		</tr>
 	<%}%>
       
       
    </table>
</form>
</body>
</html>