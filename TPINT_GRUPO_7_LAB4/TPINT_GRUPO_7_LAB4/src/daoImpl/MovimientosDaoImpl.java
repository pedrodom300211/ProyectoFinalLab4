package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidad.Cuenta;
import Entidad.MovimientoCuentas;

public class MovimientosDaoImpl {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root"; 
	private String dbName = "tif_lab4";
	
	public ArrayList<MovimientoCuentas> obtenerMovimientos(int numeroCuenta) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<MovimientoCuentas> Lista = new ArrayList<MovimientoCuentas>(); 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery(" SELECT * FROM movimientoscuentas where numerocuentaemisor = '"+numeroCuenta+"' or numeroCuentaReceptor = '"+numeroCuenta+"'");
			
			while(rs.next()) {
				MovimientoCuentas MovCuenta = new MovimientoCuentas(); 
				MovCuenta.setNumeroMovimiento(rs.getInt("numeroMovimiento"));
				MovCuenta.setNumeroCuentaEmisor(rs.getInt("numeroCuentaEmisor"));
				MovCuenta.setNumeroCunetaReceptor(rs.getInt("numeroCuentaReceptor"));
				MovCuenta.setMonto(rs.getFloat("montoEnviado"));
				MovCuenta.setFechaMovimiento(rs.getString("FechaMovimiento"));
				MovCuenta.setDetalleMovimiento(rs.getString("DetalleMovimiento"));
				MovCuenta.setTipoMovimiento(rs.getString("tipoMovimineto"));
				
				Lista.add(MovCuenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Lista;
	}
	
	public ArrayList<MovimientoCuentas> obtenerMovimientosTotales() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<MovimientoCuentas> Lista = new ArrayList<MovimientoCuentas>(); 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery(" SELECT * FROM movimientoscuentas");
			
			while(rs.next()) {
				MovimientoCuentas MovCuenta = new MovimientoCuentas(); 
				MovCuenta.setNumeroMovimiento(rs.getInt("numeroMovimiento"));
				MovCuenta.setNumeroCuentaEmisor(rs.getInt("numeroCuentaEmisor"));
				MovCuenta.setNumeroCunetaReceptor(rs.getInt("numeroCuentaReceptor"));
				MovCuenta.setMonto(rs.getFloat("montoEnviado"));
				MovCuenta.setFechaMovimiento(rs.getString("FechaMovimiento"));
				MovCuenta.setDetalleMovimiento(rs.getString("DetalleMovimiento"));
				MovCuenta.setTipoMovimiento(rs.getString("tipoMovimineto"));
				
				Lista.add(MovCuenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Lista;
	}
	
	public ArrayList<MovimientoCuentas> obtenerMovimientosMenosMil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<MovimientoCuentas> Lista = new ArrayList<MovimientoCuentas>(); 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery(" SELECT * FROM movimientoscuentas where montoEnviado > 0 and montoEnviado <1000 ");
			
			while(rs.next()) {
				MovimientoCuentas MovCuenta = new MovimientoCuentas(); 
				MovCuenta.setNumeroMovimiento(rs.getInt("numeroMovimiento"));
				MovCuenta.setNumeroCuentaEmisor(rs.getInt("numeroCuentaEmisor"));
				MovCuenta.setNumeroCunetaReceptor(rs.getInt("numeroCuentaReceptor"));
				MovCuenta.setMonto(rs.getFloat("montoEnviado"));
				MovCuenta.setFechaMovimiento(rs.getString("FechaMovimiento"));
				MovCuenta.setDetalleMovimiento(rs.getString("DetalleMovimiento"));
				MovCuenta.setTipoMovimiento(rs.getString("tipoMovimineto"));
				
				Lista.add(MovCuenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Lista;
	}
	public ArrayList<MovimientoCuentas> obtenerMovimientosMenosDiezMil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<MovimientoCuentas> Lista = new ArrayList<MovimientoCuentas>(); 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery(" SELECT * FROM movimientoscuentas where montoEnviado >= 1000 and montoEnviado < 10000");
			
			while(rs.next()) {
				MovimientoCuentas MovCuenta = new MovimientoCuentas(); 
				MovCuenta.setNumeroMovimiento(rs.getInt("numeroMovimiento"));
				MovCuenta.setNumeroCuentaEmisor(rs.getInt("numeroCuentaEmisor"));
				MovCuenta.setNumeroCunetaReceptor(rs.getInt("numeroCuentaReceptor"));
				MovCuenta.setMonto(rs.getFloat("montoEnviado"));
				MovCuenta.setFechaMovimiento(rs.getString("FechaMovimiento"));
				MovCuenta.setDetalleMovimiento(rs.getString("DetalleMovimiento"));
				MovCuenta.setTipoMovimiento(rs.getString("tipoMovimineto"));
				
				Lista.add(MovCuenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Lista;
	}
	public ArrayList<MovimientoCuentas> obtenerMovimientosMasDiezMil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<MovimientoCuentas> Lista = new ArrayList<MovimientoCuentas>(); 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery(" SELECT * FROM movimientoscuentas where montoEnviado >= 10000");
			
			while(rs.next()) {
				MovimientoCuentas MovCuenta = new MovimientoCuentas(); 
				MovCuenta.setNumeroMovimiento(rs.getInt("numeroMovimiento"));
				MovCuenta.setNumeroCuentaEmisor(rs.getInt("numeroCuentaEmisor"));
				MovCuenta.setNumeroCunetaReceptor(rs.getInt("numeroCuentaReceptor"));
				MovCuenta.setMonto(rs.getFloat("montoEnviado"));
				MovCuenta.setFechaMovimiento(rs.getString("FechaMovimiento"));
				MovCuenta.setDetalleMovimiento(rs.getString("DetalleMovimiento"));
				MovCuenta.setTipoMovimiento(rs.getString("tipoMovimineto"));
				
				Lista.add(MovCuenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Lista;
	}
	
	
	public int agregarMovimiento(MovimientoCuentas MovCuenta) {
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
			String query = "Insert into movimientoscuentas(numeroCuentaEmisor,numeroCuentaReceptor,montoEnviado,FechaMovimiento,DetalleMovimiento,tipoMovimineto) values('"+MovCuenta.getNumeroCuentaEmisor()+"','"+MovCuenta.getNumeroCunetaReceptor()+"','"+MovCuenta.getMonto()+"','"+MovCuenta.getFechaMovimiento()+"','"+MovCuenta.getDetalleMovimiento()+"','"+MovCuenta.getTipoMovimiento()+"')";                                
			filas = st.executeUpdate(query); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas; 
	

}
}