<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Cuenta"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%


ArrayList<Cuenta> Lista = null;
if(request.getAttribute("listaC")!=null){


	Lista = (ArrayList<Cuenta>) request.getAttribute("listaC");
}
 %>
<br>
<table border="1">
	<tr> 
		<th>numeroDeCuenta</th>  
		<th>DNI</th>  
		<th>CBU</th> 
		<th>Tipo de cuenta</th> 
		<th>Fecha de crecion</th> 
		<th>Saldo</th> 
		<th>Estado</th> 
		<th>Modificar</th> 
		<%if(Lista!=null)
		for(Cuenta cuenta : Lista){
	
		 %>
		 	<tr> 
		 	<form action="servletCuenta" method="get">
			 	<td><%=cuenta.getNumeroDeCuenta() %><input type="hidden" name="NumeroCuenta" value="<%=cuenta.getNumeroDeCuenta()%>"></td>
			 	<td><%=cuenta.getDNICliente_Cuenta()%></td>
			 	<td><%=cuenta.getCBU()%></td>
			 	<td><%=cuenta.getTipoDeCuenta()%></td>
			 	<td><%=cuenta.getFechaDeCreacion()%></td>
			 	<td><%=cuenta.getSaldo()%></td>
			 	<td><%=cuenta.isEstado()%></td>
		 		<td><input type="submit" value="Modificar" name="btnModificarCuenta"></td> 
		 	</form>
 		<%}%>
</table>

</body>
</html>