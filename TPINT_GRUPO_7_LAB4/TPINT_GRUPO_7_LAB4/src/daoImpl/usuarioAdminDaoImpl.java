package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Entidad.UsuarioAdmin;

public class usuarioAdminDaoImpl {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root"; 
	private String dbName = "tif_lab4";
	
	
	public boolean obtenerUsuarioAdmin(String NombreUsuarioAdmin, String ContraseñaUsuarioAdmin) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		boolean bandera = false; 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			String query = "SELECT * FROM UsuarioAdmin WHERE nombreUsuarioAdministrador='"+NombreUsuarioAdmin+"' and contraseñaUsuarioAdministrador='"+ContraseñaUsuarioAdmin+"'";                                
			bandera = st.execute(query); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bandera; 
	}
	
}
