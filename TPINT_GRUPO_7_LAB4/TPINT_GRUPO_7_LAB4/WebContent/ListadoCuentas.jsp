<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Entidad.Cuenta"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listado de Cuentas</title>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {
            $('#tablaCuentas').DataTable();
        });
    </script>
</head>
<body>
    <h3>Usuario Logueado: <%= request.getSession().getAttribute("sessionNombre").toString() %></h3><br>

 <a href="AltaCliente.jsp" >Agregar Cliente</a>
<a href="AltaCuenta.jsp" >Agregar Cuenta</a>
<a href="servletCliente?Param=1" >Listar Cliente</a>
<a href="servletCuenta?Param=1" >Listar Cuenta</a>
<a href="BajaCliente.jsp" >Baja Cliente</a>
<a href="BajaCuenta.jsp" >Baja Cuenta</a>
<a href="servletsPrestamo?Param=1" >Autorizar Prestamos</a>
<a href="servletCuenta?Reporte=1" >Reportes/Estadisticas</a>
<a href="CerrarSesion">Cerrar sesión</a><br>

    Bienvenido Admin a listado de Cuentas<br><br>
    Ingrese el numero de cuenta que desea buscar:
    <form action="servletCuenta" method="get">
        <input type="text" name="txtNumCuentaFiltrado">
        <input type="submit" value="Filtrar" name="BotonFiltrarCuenta">
        <input type="submit" value="Mostrar todos" name="BotonMostrarTodo">
        
        
        &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
       &nbsp;
   
        
        
         <select name="txtValorCuenta" id="Valor1">
		<option value="numeroDeCuenta">Numero de Cuenta</option>
		<option value="DNICliente_Cuenta">DNI Cliente</option>
		<option value="CBU">CBU</option>
		<option value="saldo">Saldo</option>
	
		
	</select>
         <select name="txtSimboloCuenta" id="Cuenta">
		<option value="=">=</option>
		<option value=">">></option>
		<option value=">=">>=</option>
		<option value="<"><</option>
		<option value="<="> <= </option>
	</select>
	<input type="text" name="txtSegundoValorCuenta">
        <input type="submit" value="Filtrar" name="BotonFiltrarValorCuenta">
        <input type="submit" value="Mostrar todos" name="BotonMostrarTodo">
        
        <br>
    </form>

    <% 
        ArrayList<Cuenta> Lista = null;
        if (request.getAttribute("listaC") != null) {
            Lista = (ArrayList<Cuenta>) request.getAttribute("listaC");
        }
    %>

    <br>
<% int filas = 0; 
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		
		
 %>
 
 <% if(filas==1) 
	{
%>
		Cuenta actualizada con éxito
		<script>
            
        </script>
<%} %>
    <table border="1" id="tablaCuentas" class="display">
        <thead>
            <tr>
                <th>numeroDeCuenta</th>
                <th>DNI</th>
                <th>CBU</th>
                <th>Tipo de cuenta</th>
                <th>Fecha de creacion</th>
                <th>Saldo</th>
                <th>Estado</th>
                <th>Modificar</th>
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
                            	<td>
		                            <form action="servletCuenta" method="get">
		                                <input type="hidden" name="NumeroCuenta" value="<%=cuenta.getNumeroDeCuenta()%>">
		                                <input type="submit" value="Modificar" name="btnModificarCuenta">
                            </form>
                            </td>
                        </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>