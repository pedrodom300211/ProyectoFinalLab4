<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
Sistema Gestor Banco<br><br>
</head>
<body>
<form action="servletCliente" method="get">
Usuario: <input type="text" name="txtUsuarioLogIn"><br>
Contraseña: <input type="password" name="txtContrasenaLogIn"><br>
<input type="submit" name="BotonAceptarLogin" value="Aceptar" >

<% int bandera=5; 
		if (request.getAttribute("bandera") != null) {
			bandera = Integer.valueOf(request.getAttribute("bandera").toString());
		}
		
		
 %>
 
 <% 
 
 if(bandera==1) 
	{
	 
	 response.sendRedirect("InicioAdmin.jsp");
%>
		Usuario existe
<%	} 
 	else if(bandera==0)
 		{
	 		response.sendRedirect("elegirCuenta.jsp");
	 	}
 	else if(bandera==4)
 	{
 		%>
 		
 		<p>Credenciales incorrectas, vuelva a intentar</p>
 		
 		<%
 	}

%>
</form>
</body>
</html>