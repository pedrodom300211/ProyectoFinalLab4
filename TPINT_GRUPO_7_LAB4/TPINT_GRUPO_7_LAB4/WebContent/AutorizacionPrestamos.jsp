<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Prestamo"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autorizacion de prestamos</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#tablaPrestamos').DataTable({
                "paging": true,
                "pageLength": 10
            });
        });
    </script>
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
Bienvenido Admin a Autorizacion de prestamos<br>
<form action="servletsPrestamo" method="get">
<%ArrayList<Prestamo> Lista = null;
if(request.getAttribute("listaC")!=null){


	Lista = (ArrayList<Prestamo>) request.getAttribute("listaC");
}

%><% %> 
<% int filas = 0;
int filas2 = 0;
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		if (request.getAttribute("cantFilas2") != null) {
			filas2 = Integer.parseInt(request.getAttribute("cantFilas2").toString());
		}
		
		
 %>
 
 <% if(filas==1) 
	{
%>
		Prestamo autorizado con exito
<%} %><% else if(filas==-1)
	{
%> Error al autorizar prestamo
<%} %>
 <% if(filas2==1) 
	{
%>
		Prestamo Rechazado con exito
<%} %><% else if(filas2==-1)
	{
%> Error al Rechazar prestamo
<%} %>
<table border="1" id="tablaPrestamos" class="display">
<thead>
        <tr>
            <th>Numero de prestamo</th>
            <th>Nuemero de cuenta</th>
            <th>Monto solicitado</th>
            <th>Fecha</th>
            <th>Cuotas</th>
            <th>Aceptar</th>
            <th>Rechazar</th>
        </tr>
        </thead>
        <tbody>
        <%if(Lista!=null)
	for(Prestamo pres : Lista){

	 %>
        <tr><form action="servletsPrestamo" method="get">
            <td><%=pres.getNumeroPrestamo()%><input type="hidden" name="NumeroPrestamo" value="<%=pres.getNumeroPrestamo()%>"></td>
            <td><%=pres.getNumeroCuentaSolocita()%><input type="hidden" name="NumeroCuenta" value="<%=pres.getNumeroCuentaSolocita()%>"></td>
            <td><%=pres.getMontoPedido() %><input type="hidden" name="Monto" value="<%=pres.getMontoPedido()%>"></td>
			<td><%=pres.getFechaPrestamo() %></td>
			<td><%=pres.getCuotasPrestamo() %><input type="hidden" name="CuotasPrestamo" value="<%=pres.getCuotasPrestamo()%>"></td>
	
            <td><input type="submit" value="Aceptar" name="btnAceptarPrestamo"></td> 
           <td><input type="submit" value="Rechazar" name="btnRechazarPrestamo"></td> 
           </form>
            
            
            
            
        </tr>
       <%}%>
       </tbody>
    </table>
    </form>
</body>
</html>