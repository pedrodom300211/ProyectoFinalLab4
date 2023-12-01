<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Cliente"%>   
<%@ page import="Entidad.Cuenta"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Reportes</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#tabla').DataTable({
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
    Bienvenido Admin a Reportes/Estadisticas<br><br>
    <h1>REPORTE: Creacion de cuentas por fecha</h1>
    <form action="servletCuenta" method="get">
	    Desde 
        <input type="date" name="txtFechaDesdeFiltrado">
        Hasta 
        <input type="date" name="txtFechaHastaFiltrado">
        <input type="submit" value="Filtrar" name="BotonFiltrarCuentasFechaCreacion">
        <input type="submit" value="Mostrar todos" name="BotonMostrarTodoReporte">
        <br>
        <%--faltan filtros--%> 
        

        <% 
        ArrayList<Cuenta> Lista = null;
        if(request.getAttribute("listaC")!=null){
            Lista = (ArrayList<Cuenta>) request.getAttribute("listaC");
        }else{%>
        	LA FECHA DESDE ES DESPUES QUE LA DEL HASTA <br>
        <%}%>
        <% int filas = 0; 
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		
		
 %>
 
 <% if(filas==1) 
	{
%>
		
		
		
		<script>
            
        </script>
		
	
<%} %>

        <table border="1" id="tabla" class="display">
            <thead>
                <tr> 
	                <th>numeroDeCuenta</th>
	                <th>DNI</th>
	                <th>CBU</th>
	                <th>Tipo de cuenta</th>
	                <th>Fecha de creacion</th>
	                <th>Saldo</th>
	                <th>Estado</th>
                </tr>
            </thead>
            <tbody>
                <% 
                if (Lista != null) {
                    for (Cuenta cuenta : Lista) {
            %>
                        <tr>
                            <form action="servletCuenta" method="get">
                                <td><%= cuenta.getNumeroDeCuenta() %><input type="hidden" name="NumeroCuenta" value="<%= cuenta.getNumeroDeCuenta() %>"></td>
                                </form>
                                <td><%= cuenta.getDNICliente_Cuenta() %></td>
                                <td><%= cuenta.getCBU() %></td>
                                <td><%= cuenta.getTipoDeCuenta() %></td>
                                <td><%= cuenta.getFechaDeCreacion() %></td>
                                <td><%= cuenta.getSaldo() %></td>
                                <td><%= cuenta.isEstado() %></td>
                        </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </form>
    <br><br>
    <form action="servletMovimientoCuentas" method="get">
   <h3>ESTADISTICA</h3>
   <p>Movimientos Totales: </p><%=request.getAttribute("Total") %><br>
   <p> Movimientos de 0 a 1000</p><%=request.getAttribute("MenosMil") %>%<br>
   <p> Movimientos de 1001 a 10000</p><%=request.getAttribute("MenosDiezMil") %>%<br>
   <p> Movimientos Mayores a 10000</p><%=request.getAttribute("MasDiezMil") %>%<br>
   </form>
</body>
</html>