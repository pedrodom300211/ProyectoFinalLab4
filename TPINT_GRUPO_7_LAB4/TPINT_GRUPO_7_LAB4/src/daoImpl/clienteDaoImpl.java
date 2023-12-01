package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import Entidad.Cliente;
import Entidad.TipoCliente;

public class clienteDaoImpl {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root"; 
	private String dbName = "tif_lab4";
	
	
	
public int ObtenerUsuario(String password, String Usuario) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection cn = null; 
		int tipo=4;
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			String query = "SELECT * FROM clientes WHERE nombreUsuario_CL = '"+Usuario+"'"+"AND contrasenaUsuario_CL = '"+password+"' and Estado_CL = 1";
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				tipo = rs.getInt("TipoUsuario_CL");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return tipo; 
	}
	
	
	
	
public int agregarCliente(Cliente cliente) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		int filas = 0; 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			int estado = 1;
			String query = "Insert into Clientes (DNI_CL,Nombre_CL,Apellido_CL,TipoUsuario_CL,Sexo_CL,CorreoElectronico_CL,Nacionalidad_CL,FechaNacimiento_CL,Direccion_CL,Localidad_Cl,Provincia_CL,Telefono_CL,nombreUsuario_CL,contrasenaUsuario_CL,Estado_CL) VALUES ('"+cliente.getDNICliente()+"','"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getTipoCliente().getNumeroTipoCliente()+"','"+cliente.getSexo()+"','"+cliente.getCorreoElectronico()+"','"+cliente.getNacionalidad()+"','"+cliente.getFechaNacimiento()+"','"+cliente.getDireccion()+"','"+cliente.getLocalidad()+"','"+cliente.getProvincia()+"','"+cliente.getTelefono()+"','"+cliente.getNombreUsuario()+"','"+cliente.getContrasenaUsuario()+"','"+estado+"')";
			filas = st.executeUpdate(query); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas; 
	}


public int eliminarCliente(String dni) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	int filas = 0; 
	Connection cn = null; 
	try {
		cn = DriverManager.getConnection(host+dbName, user,pass); 
		Statement st = cn.createStatement(); 
		String query = "UPDATE clientes SET Estado_CL = 0 WHERE DNI_CL = '"+dni+"'";
		filas = st.executeUpdate(query); 
	} catch (Exception e) {
		e.printStackTrace();
	}
	return filas; 
}


public int ActualizarCliente(Cliente cliente,String dni) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	int filas = 0; 
	Connection cn = null; 
	
	try {
		cn = DriverManager.getConnection(host+dbName, user,pass); 
		Statement st = cn.createStatement(); 
		String query = "UPDATE clientes SET  DNI_CL= '"+ cliente.getDNICliente()+"',Nombre_CL='"+ cliente.getNombre()+"',Apellido_CL='"+ cliente.getApellido()+"',TipoUsuario_CL="+ cliente.getTipoCliente().getNumeroTipoCliente()+",Sexo_CL='"+ cliente.getSexo()+"',CorreoElectronico_CL='"+ cliente.getCorreoElectronico()+"',Nacionalidad_CL='"+ cliente.getNacionalidad()+"',FechaNacimiento_CL='"+ cliente.getFechaNacimiento()+"',Direccion_CL='"+ cliente.getDireccion()+"',Localidad_Cl='"+ cliente.getLocalidad()+"',Provincia_CL='"+ cliente.getProvincia()+"',Telefono_CL='"+ cliente.getTelefono()+"',contrasenaUsuario_CL='"+ cliente.getContrasenaUsuario()+"', Estado_CL = 1 WHERE DNI_CL = '"+dni+"'";
		filas = st.executeUpdate(query); 
	} catch (Exception e) {
		e.printStackTrace();
	}
	return filas; 
}


public ArrayList<Cliente> ObtenerClientes(){
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	
	ArrayList<Cliente> Lista = new ArrayList<Cliente>();
	Connection cn = null;
	try {
		cn = DriverManager.getConnection(host+dbName, user, pass);
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("SELECT DNI_CL,Nombre_CL,Apellido_CL,TipoUsuario_CL,descripcioncliente,Sexo_CL,CorreoElectronico_CL,Nacionalidad_CL,FechaNacimiento_CL,Direccion_CL,Localidad_Cl,Provincia_CL,Telefono_CL,nombreUsuario_CL,contrasenaUsuario_CL,Estado_CL FROM clientes inner join tipodeclientes on TipoUsuario_CL = numerotipocliente");
		
		while(rs.next()) {
			
			Cliente ClienteL = new Cliente();
			TipoCliente tC=new TipoCliente();
			
			tC.setNumeroTipoCliente(rs.getInt("TipoUsuario_CL"));
			tC.setDescripcionTipoCliente(rs.getString("descripcioncliente"));
			
			ClienteL.setDNICliente(rs.getString("DNI_CL"));
			ClienteL.setNombre(rs.getString("Nombre_CL"));
			ClienteL.setApellido(rs.getString("Apellido_CL"));
			ClienteL.setTipoCliente(tC);
			ClienteL.setSexo(rs.getString("Sexo_CL"));
			ClienteL.setCorreoElectronico(rs.getString("CorreoElectronico_CL"));
			ClienteL.setNacionalidad(rs.getString("Nacionalidad_CL"));
			ClienteL.setFechaNacimiento(rs.getString("FechaNacimiento_CL"));
			ClienteL.setDireccion(rs.getString("Direccion_CL"));
			ClienteL.setLocalidad(rs.getString("Localidad_Cl"));
			ClienteL.setProvincia(rs.getString("Provincia_CL"));
			ClienteL.setTelefono(rs.getString("Telefono_CL"));
			ClienteL.setNombreUsuario(rs.getString("nombreUsuario_CL"));
			ClienteL.setContrasenaUsuario(rs.getString("contrasenaUsuario_CL"));
			ClienteL.setEstado(rs.getBoolean("Estado_CL"));
			
			
			Lista.add(ClienteL);
			
		}
		cn.close();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		
		
	}

	return Lista;

	
}

public ArrayList<Cliente> ObtenerClientesFiltrados(int num){
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	
	ArrayList<Cliente> Lista = new ArrayList<Cliente>();
	Connection cn = null;
	try {
		cn = DriverManager.getConnection(host+dbName, user, pass);
		Statement st = cn.createStatement();
		//ListarClientes ls = new ListarClientes();
		//String ddl = rs.get;
		ResultSet rs = st.executeQuery("SELECT DNI_CL,Nombre_CL,Apellido_CL,TipoUsuario_CL,descripcioncliente,Sexo_CL,CorreoElectronico_CL,Nacionalidad_CL,FechaNacimiento_CL,Direccion_CL,Localidad_Cl,Provincia_CL,Telefono_CL,nombreUsuario_CL,contrasenaUsuario_CL,Estado_CL FROM clientes inner join tipodeclientes on TipoUsuario_CL = numerotipocliente WHERE DNI_CL LIKE '"+num+"%'");
		
		while(rs.next()) {
			
			Cliente ClienteL = new Cliente();
			TipoCliente tC=new TipoCliente();
			tC.setNumeroTipoCliente(rs.getInt("TipoUsuario_CL"));
			tC.setDescripcionTipoCliente(rs.getString("descripcioncliente"));
			ClienteL.setDNICliente(rs.getString("DNI_CL"));
			ClienteL.setNombre(rs.getString("Nombre_CL"));
			ClienteL.setApellido(rs.getString("Apellido_CL"));
			ClienteL.setTipoCliente(tC);
			ClienteL.setSexo(rs.getString("Sexo_CL"));
			ClienteL.setCorreoElectronico(rs.getString("CorreoElectronico_CL"));
			ClienteL.setNacionalidad(rs.getString("Nacionalidad_CL"));
			ClienteL.setFechaNacimiento(rs.getString("FechaNacimiento_CL"));
			ClienteL.setDireccion(rs.getString("Direccion_CL"));
			ClienteL.setLocalidad(rs.getString("Localidad_Cl"));
			ClienteL.setProvincia(rs.getString("Provincia_CL"));
			ClienteL.setTelefono(rs.getString("Telefono_CL"));
			ClienteL.setNombreUsuario(rs.getString("nombreUsuario_CL"));
			ClienteL.setContrasenaUsuario(rs.getString("contrasenaUsuario_CL"));
			ClienteL.setEstado(rs.getBoolean("Estado_CL"));
			
			
			Lista.add(ClienteL);
			
		}
		cn.close();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		
		
	}

	return Lista;

	
}

public ArrayList<Cliente> ObtenerClientesFiltro(String num, String Simbolo, int segundovalor){
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	
	ArrayList<Cliente> Lista = new ArrayList<Cliente>();
	Connection cn = null;
	try {
		cn = DriverManager.getConnection(host+dbName, user, pass);
		Statement st = cn.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT DNI_CL,Nombre_CL,Apellido_CL,TipoUsuario_CL,descripcioncliente,Sexo_CL,CorreoElectronico_CL,Nacionalidad_CL,FechaNacimiento_CL,Direccion_CL,Localidad_Cl,Provincia_CL,Telefono_CL,nombreUsuario_CL,contrasenaUsuario_CL,Estado_CL FROM clientes inner join tipodeclientes on TipoUsuario_CL = numerotipocliente WHERE " + num + " " + Simbolo + " " + segundovalor);

		
		while(rs.next()) {
			
			Cliente ClienteL = new Cliente();
			TipoCliente tC=new TipoCliente();
			tC.setNumeroTipoCliente(rs.getInt("TipoUsuario_CL"));
			tC.setDescripcionTipoCliente(rs.getString("descripcioncliente"));
			ClienteL.setDNICliente(rs.getString("DNI_CL"));
			ClienteL.setNombre(rs.getString("Nombre_CL"));
			ClienteL.setApellido(rs.getString("Apellido_CL"));
			ClienteL.setTipoCliente(tC);
			ClienteL.setSexo(rs.getString("Sexo_CL"));
			ClienteL.setCorreoElectronico(rs.getString("CorreoElectronico_CL"));
			ClienteL.setNacionalidad(rs.getString("Nacionalidad_CL"));
			ClienteL.setFechaNacimiento(rs.getString("FechaNacimiento_CL"));
			ClienteL.setDireccion(rs.getString("Direccion_CL"));
			ClienteL.setLocalidad(rs.getString("Localidad_Cl"));
			ClienteL.setProvincia(rs.getString("Provincia_CL"));
			ClienteL.setTelefono(rs.getString("Telefono_CL"));
			ClienteL.setNombreUsuario(rs.getString("nombreUsuario_CL"));
			ClienteL.setContrasenaUsuario(rs.getString("contrasenaUsuario_CL"));
			ClienteL.setEstado(rs.getBoolean("Estado_CL"));
			
			
			Lista.add(ClienteL);
			
		}
		cn.close();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		
		
	}

	return Lista;

	
}





	public Cliente GetByDni(String Dni) {
		Cliente ClienteL = new Cliente();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			//ListarClientes ls = new ListarClientes();
			//String ddl = rs.get;
			ResultSet rs = st.executeQuery("SELECT DNI_CL,Nombre_CL,Apellido_CL,TipoUsuario_CL,descripcioncliente,Sexo_CL,CorreoElectronico_CL,Nacionalidad_CL,FechaNacimiento_CL,Direccion_CL,Localidad_Cl,Provincia_CL,Telefono_CL,nombreUsuario_CL,contrasenaUsuario_CL,Estado_CL FROM clientes inner join tipodeclientes on TipoUsuario_CL = numerotipocliente WHERE DNI_CL='"+Dni+"'");
			rs.next();
			TipoCliente tC=new TipoCliente();
			tC.setNumeroTipoCliente(rs.getInt("TipoUsuario_CL"));
			tC.setDescripcionTipoCliente(rs.getString("descripcioncliente"));
			ClienteL.setDNICliente(Dni);
			ClienteL.setNombre(rs.getString("Nombre_CL"));
			ClienteL.setApellido(rs.getString("Apellido_CL"));
			ClienteL.setTipoCliente(tC);
			ClienteL.setSexo(rs.getString("Sexo_CL"));
			ClienteL.setCorreoElectronico(rs.getString("CorreoElectronico_CL"));
			ClienteL.setNacionalidad(rs.getString("Nacionalidad_CL"));
			ClienteL.setFechaNacimiento(rs.getString("FechaNacimiento_CL"));
			ClienteL.setDireccion(rs.getString("Direccion_CL"));
			ClienteL.setLocalidad(rs.getString("Localidad_Cl"));
			ClienteL.setProvincia(rs.getString("Provincia_CL"));
			ClienteL.setTelefono(rs.getString("Telefono_CL"));
			ClienteL.setNombreUsuario(rs.getString("nombreUsuario_CL"));
			ClienteL.setContrasenaUsuario(rs.getString("contrasenaUsuario_CL"));
			ClienteL.setEstado(rs.getBoolean("Estado_CL"));
			
			cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ClienteL;
	}
	
	public Cliente GetByDni2(String Dni) {
		Cliente ClienteL = new Cliente();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			//ListarClientes ls = new ListarClientes();
			//String ddl = rs.get;
			ResultSet rs = st.executeQuery("SELECT DNI_CL,Nombre_CL,Apellido_CL,Sexo_CL,CorreoElectronico_CL,Nacionalidad_CL,FechaNacimiento_CL,Direccion_CL,Localidad_Cl,Provincia_CL,Telefono_CL,nombreUsuario_CL,contrasenaUsuario_CL,Estado_CL FROM clientes WHERE DNI_CL='"+Dni+"'");
			rs.next();
			ClienteL.setDNICliente(Dni);
			ClienteL.setNombre(rs.getString("Nombre_CL"));
			ClienteL.setApellido(rs.getString("Apellido_CL"));
			ClienteL.setSexo(rs.getString("Sexo_CL"));
			ClienteL.setCorreoElectronico(rs.getString("CorreoElectronico_CL"));
			ClienteL.setNacionalidad(rs.getString("Nacionalidad_CL"));
			ClienteL.setFechaNacimiento(rs.getString("FechaNacimiento_CL"));
			ClienteL.setDireccion(rs.getString("Direccion_CL"));
			ClienteL.setLocalidad(rs.getString("Localidad_Cl"));
			ClienteL.setProvincia(rs.getString("Provincia_CL"));
			ClienteL.setTelefono(rs.getString("Telefono_CL"));
			ClienteL.setNombreUsuario(rs.getString("nombreUsuario_CL"));
			ClienteL.setContrasenaUsuario(rs.getString("contrasenaUsuario_CL"));
			ClienteL.setEstado(rs.getBoolean("Estado_CL"));
			
			cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ClienteL;
	}
	public boolean validar2Strings(String s1,String s2)
	{	System.out.println(s1);
	System.out.println(s2);
		if(s1.equals(s2)) {
		return true;
		}
		return false;
		
		
	}
	
	//public boolean VerificarCliente(Cliente cliente) {}


}