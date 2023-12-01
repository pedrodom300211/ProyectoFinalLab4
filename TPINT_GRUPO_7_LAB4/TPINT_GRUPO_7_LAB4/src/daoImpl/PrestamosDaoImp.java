package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import Entidad.Cliente;
import Entidad.Cuenta;
import Entidad.Prestamo;

public class PrestamosDaoImp {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root"; 
	private String dbName = "tif_lab4";
	
	public int agregarPrestamo(Prestamo prestamo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		int filas = 0; 
		int estado = 1;
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			String query = " INSERT into prestamos(numeroCuentaSolocita,montoPedido,montoconinteres,FechaPrestamo,CuotasPrestamo,EstadoPrestamo) VALUES ("+prestamo.getNumeroCuentaSolocita()+","+prestamo.getMontoPedido()+","+prestamo.getMontoPedido()*1.12+",'"+prestamo.getFechaPrestamo()+"',"+prestamo.getCuotasPrestamo()+","+prestamo.isEstadoPrestamo()+")";                                
			filas = st.executeUpdate(query); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas; 
	}
	public ArrayList<Prestamo> obtenerPrestamos() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Prestamo> Lista = new ArrayList<Prestamo>(); 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery("SELECT numeroPrestamo,numeroCuentaSolocita,montoPedido,montoConInteres,FechaPrestamo,CuotasPrestamo,EstadoPrestamo from Prestamos WHERE EstadoPrestamo =2");
			
			while(rs.next()) {
				Prestamo prestamoL = new Prestamo(); 
				prestamoL.setNumeroPrestamo(rs.getInt("numeroPrestamo"));
				prestamoL.setNumeroCuentaSolocita(rs.getInt("numeroCuentaSolocita"));
				prestamoL.setMontoPedido(rs.getFloat("montoPedido"));
				
				prestamoL.setMontoConInteres(rs.getFloat("montoConInteres"));
				
				prestamoL.setFechaPrestamo(rs.getString("FechaPrestamo"));
				prestamoL.setCuotasPrestamo(rs.getInt("CuotasPrestamo"));
				prestamoL.setEstadoPrestamo(rs.getInt("EstadoPrestamo"));
				
				Lista.add(prestamoL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Lista;
	}
	
	public Prestamo GetNumeroPrestamo(int numeroPrestamo) {
		Prestamo prestamoL = new Prestamo();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		
		Connection cn = null;
		try {
			
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT numeroPrestamo, numeroCuentaSolocita, montoPedido,montoconinteres, FechaPrestamo, CuotasPrestamo, EstadoPrestamo FROM Prestamos WHERE numeroPrestamo = "+ numeroPrestamo );
			if(rs.next()) {
			
			prestamoL.setNumeroPrestamo(rs.getInt("numeroPrestamo"));
			prestamoL.setNumeroCuentaSolocita(rs.getInt("numeroCuentaSolocita"));
			prestamoL.setMontoPedido(rs.getFloat("montoPedido"));
			prestamoL.setMontoConInteres(rs.getFloat("montoconinteres"));
			prestamoL.setFechaPrestamo(rs.getString("FechaPrestamo"));
			System.out.println("HOla");
			prestamoL.setCuotasPrestamo(rs.getInt("CuotasPrestamo"));
			prestamoL.setEstadoPrestamo(rs.getInt("EstadoPrestamo"));
			
			ActualizarPrestamo( rs.getInt("numeroPrestamo"), rs.getInt("numeroCuentaSolocita"), rs.getFloat("montoPedido"), rs.getFloat("montoconinteres"), rs.getString("FechaPrestamo"), rs.getInt("CuotasPrestamo"),rs.getInt("EstadoPrestamo")); 
			}
			cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return prestamoL;
	}
	
	public int ActualizarPrestamo(int numeroPrestamo, int numeroCuentaSolocita, float monto,float montoconinteres, String fechaPedido, int cuotasPrestamo, int estado) {
		
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
			String query = "UPDATE Prestamos SET numeroPrestamo = '"+ numeroPrestamo +"', numeroCuentaSolocita = '"+ numeroCuentaSolocita +"', montoPedido = '"+ monto +"', montoconinteres = '"+ montoconinteres +"', FechaPrestamo = '"+ fechaPedido +"', CuotasPrestamo = '"+ cuotasPrestamo +"', EstadoPrestamo = '"+estado+ "' WHERE numeroPrestamo = '"+ numeroPrestamo +"'";
			filas = st.executeUpdate(query); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas; 
	} 
	public int AceptarPrestamo(int estado,int numeroPrestamo) {
		
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
			String query = "UPDATE Prestamos SET EstadoPrestamo = "+estado +" WHERE numeroPrestamo = "+ numeroPrestamo ;
			
			filas = st.executeUpdate(query); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas; 
	} 
	
	
	
	public ArrayList<Prestamo> obtenerPrestamoSegunCuenta(int cuenta) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Prestamo> Lista = new ArrayList<Prestamo>(); 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery(" SELECT * FROM Prestamos WHERE numeroCuentaSolocita ="+cuenta+" and EstadoPrestamo = 1");
			
			while(rs.next()) {
				Prestamo prestamoL = new Prestamo(); 
				prestamoL.setNumeroPrestamo(rs.getInt("numeroPrestamo"));
				prestamoL.setNumeroCuentaSolocita(rs.getInt("numeroCuentaSolocita"));
				prestamoL.setMontoPedido(rs.getFloat("montoPedido"));
				prestamoL.setMontoConInteres(rs.getFloat("montoConInteres"));
				prestamoL.setFechaPrestamo(rs.getString("FechaPrestamo"));
				prestamoL.setCuotasPrestamo(rs.getInt("CuotasPrestamo"));
				prestamoL.setEstadoPrestamo(rs.getInt("EstadoPrestamo"));
				
				Lista.add(prestamoL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Lista;
	}
	public String GetNumCuentaByNumPrestamo(int numPrestamo)
	{	

	    String numCuenta = null ; 
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    Connection cn = null;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        String query = "SELECT numeroCuentaSolocita from prestamos where  numeroPrestamo= ?";
	        
	        try (PreparedStatement st = cn.prepareStatement(query)) {
	            st.setInt(1, numPrestamo);
	            
	            
	            ResultSet resultSet = st.executeQuery();

	            if (resultSet.next()) {
	                numCuenta = resultSet.getString("numeroCuentaSolocita");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (cn != null) {
	                cn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return numCuenta;
	
	}

}
