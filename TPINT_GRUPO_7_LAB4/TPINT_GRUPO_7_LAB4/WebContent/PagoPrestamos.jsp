<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Prestamo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
    document.getElementById('ddlCuotas').addEventListener('change', function() {
        var selectedValue = this.value;
        document.getElementById('cantidadCuotas').value = selectedValue;
    });
</script>
</head>
<body>

<a href="servletsPrestamo?Param2=1" >Pago prestamos</a>
<a href="Transferencias.jsp" >Transferencias</a>
<a href="SolicitarPrestamo.jsp" >Solicitar prestamo</a>
<a href="servletMovimientoCuentas?Param5=1" >Movimientos de la cuenta</a>
<a href="servletCliente?Param2=1" >Datos personales</a>
<a href="servletCuenta?Param3=1">Cambiar de cuenta</a>
<a href="CerrarSesion">Cerrar sesión</a><br>
<h3>Usuario Logueado:  <%=request.getSession().getAttribute("sessionNombre").toString()%></h3><br>
<h3>Esta en la cuenta:  <%=request.getSession().getAttribute("sessionNombreCuenta").toString()%></h3><br>
Bienvenido a pago de prestamos<br>
<form action="servletsPrestamo" method="get">
<%--faltan filtros--%> 
<table border="1">
<%


ArrayList<Prestamo> Lista = null;
if(request.getAttribute("listaC")!=null){


	Lista = (ArrayList<Prestamo>) request.getAttribute("listaC");
}
 %> 

		
        
        
        <tr>
            <th>Numero de prestamo</th>
            <th>Nuemero de cuenta</th>
            <th>Total Original</th>
            <th>Total a Abonar con interes</th>
            <th>Cuotas</th>
            <th>Monto a pagar por mes</th>
            <th>Elegir Cantidad Coutas</th>
            <th>Pagar</th>
            
        </tr>
        <tr>
           <%if(Lista!=null)
	for(Prestamo prestamo : Lista){

			
	 %> </form>
 		<tr> 
 			<form action="servletsPrestamo" method="get"> 
 				<td><%=prestamo.getNumeroPrestamo()%><input type="hidden" name=numeroPrestamo value="<%=prestamo.getNumeroPrestamo()%>"></td>
 				<td><%= prestamo.getNumeroCuentaSolocita() %><input type="hidden" name="NumCuentaSolicita" value="<%= prestamo.getNumeroCuentaSolocita() %>"></td>
 				<td><%=prestamo.getMontoPedido()%><input type="hidden" name="Monto" value="<%= prestamo.getMontoPedido() %>"></td>
 				<td><%=prestamo.getMontoConInteres()%><input type="hidden" name="MontoInteres" value="<%= prestamo.getMontoConInteres()%>"></td>
 				<td><%=prestamo.getCuotasPrestamo()%><input type="hidden" name="CuotasTotales" value="<%= prestamo.getCuotasPrestamo() %>"></td>
 				<td><%=prestamo.getMontoConInteres()/prestamo.getCuotasPrestamo()%><input type="hidden" name="Cuotas" value="<%= prestamo.getMontoConInteres()/prestamo.getCuotasPrestamo()%>"></td>
 				<td>
			   <select name="ddCantidadCuotas" id="ddlCuotas">
			    <% for(int i=1; i<=prestamo.getCuotasPrestamo(); i++) { %>
			        <option value="<%=i%>"><%=i%></option>
			    <% } %>
				</select>
				<input type="hidden" name="cantidadCuotas" id="cantidadCuotas" value="">
				</td>
				
 				<td><input type="submit" name="BotonPagar"  value="Pagar"></td>		
 			</form> 
 		</tr>
 	<%}%>
           <% int filas = 0; 
		if (request.getAttribute("cantFilas") != null) {
			filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
		}
		
		
 %>
 
 <% if(filas==1) 
	{
%>
		Prestamo Pagado con exito
<%} %><% else if(filas==-1)
	{
%> Saldo insuficiente
<%} %>
         
            
    
        </tr>
      
    </table>

</body>
</html>