<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Cliente"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listado de Clientes</title>
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
    Bienvenido Admin a listado de Clientes<br><br>
    Ingrese el dni del usuario que desea: 
    <form action="servletCliente" method="get">
        <input type="text" name="txtDNIFiltrado">
        <input type="submit" value="Filtrar" name="BotonFiltrarDocumento">
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
   
        
        
         <select name="txtValor" id="Valor1">
		<option value="DNI_CL">Dni</option>
		<option value="Telefono_CL">Telefono</option>
		
	</select>
         <select name="txtSimbolo" id="Simbolo">
		<option value="=">=</option>
		<option value=">">></option>
		<option value=">=">>=</option>
		<option value="<"><</option>
		<option value="<="> <= </option>
	</select>
	<input type="text" name="txtSegundoValor">
        <input type="submit" value="Filtrar" name="BotonFiltrarValor">
        <input type="submit" value="Mostrar todos" name="BotonMostrarTodo">
        
        <br>

        <% 
        ArrayList<Cliente> Lista = null;
        if(request.getAttribute("listaC")!=null){
            Lista = (ArrayList<Cliente>) request.getAttribute("listaC");
        }%>
        <% int filas = 0; 
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		
		
 %>
 
 <% if(filas==1) 
	{
%>
		
		
		Cliente actualizado con éxito
		<script>
            
        </script>
		
	
<%} %>

        <table border="1" id="tabla" class="display">
            <thead>
                <tr> 
                    <th>DNI</th>  
                    <th>Nombre</th>  
                    <th>Apellido</th> 
                    <th>Tipo de Usuario</th>
                    <th>Sexo</th> 
                    <th>Correo Electronico</th> 
                    <th>Nacionalidad</th> 
                    <th>Fecha de nacimiento</th> 
                    <th>Direccion</th> 
                    <th>Localidad</th> 
                    <th>Provincia</th> 
                    <th>Telefono</th> 
                    <th>Nombre Usuario</th> 
                    <th>Contraseña Usuario</th> 
                    <th>Estado</th> 
                    <th>Modificar</th>
                </tr>
            </thead>
            <tbody>
                <%if(Lista != null)
                    for(Cliente cliente : Lista){ %>
                    <tr>
                  	  <form action="servletCliente" method="get">
                        <td><%=cliente.getDNICliente()%> <input type="hidden" name="dniCliente" value="<%=cliente.getDNICliente()%>"> </td>
                        </form>
                        <td><%=cliente.getNombre()%></td>
                        <td><%=cliente.getApellido()%></td>
                        <td><%=cliente.getTipoCliente().getDescripcionTipoCliente()%></td>
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
                        <td><%=cliente.isEstado()%></td> 
                        <td>
                            	<form action="servletCliente" method="get">
                                <input type="hidden" name="dniCliente" value="<%=cliente.getDNICliente()%>">
                                <input type="submit" value="Modificar" name="btnModificarCliente">
                            </form>
                        </td> 
                    </tr>
                <% } %>
            </tbody>
        </table>
    </form>
</body>
</html>