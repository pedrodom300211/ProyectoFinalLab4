package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidad.Cliente;
import Entidad.Cuenta;
import Entidad.TipoCliente;

public class cuentaDaoImpl {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root"; 
	private String dbName = "tif_lab4";
	
	public int agregarCuenta(Cuenta cuenta) {
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
			String query = "INSERT INTO Cuentas (DNICliente_Cuenta,CBU,tipoCuenta,fechaDeCreacion,saldo,estado) VALUES('"+cuenta.getDNICliente_Cuenta()+"','"+cuenta.getCBU()+"','"+cuenta.getTipoDeCuenta()+"','"+cuenta.getFechaDeCreacion()+"','"+cuenta.getSaldo()+"','"+estado+"')";                                
			filas = st.executeUpdate(query); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas; 
	}
	
	
	public int eliminarCuenta(String num) {
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
			String query = "UPDATE Cuentas SET estado = 0 WHERE numeroDeCuenta = '"+num+"'";
			filas = st.executeUpdate(query); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas; 
	}
	
	
	public ArrayList<Cuenta> obtenerCuenta() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Cuenta> Lista = new ArrayList<Cuenta>(); 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery("SELECT numeroDeCuenta, DNICliente_Cuenta, CBU, tipoCuenta,descripcionCuenta,fechaDeCreacion, saldo,estado FROM cuentas inner join tipodecuentas on tipocuenta = numerotipocuenta");
			
			while(rs.next()) {
				Cuenta cuentaL = new Cuenta(); 
				cuentaL.setNumeroDeCuenta(rs.getInt("numeroDeCuenta"));
				cuentaL.setDNICliente_Cuenta(rs.getString("DNICliente_Cuenta"));
				cuentaL.setCBU(rs.getString("CBU"));
				cuentaL.setTipoDeCuenta(rs.getInt("tipoCuenta"));
				cuentaL.setFechaDeCreacion(rs.getString("fechaDeCreacion"));
				cuentaL.setSaldo(rs.getFloat("saldo"));
				cuentaL.setEstado(rs.getBoolean("estado"));
				
				Lista.add(cuentaL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Lista;
	}
	public ArrayList<Cuenta> obtenerCuentaByDNI(String DNI) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Cuenta> Lista = new ArrayList<Cuenta>(); 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery("SELECT numeroDeCuenta, DNICliente_Cuenta, CBU, tipoCuenta,fechaDeCreacion, saldo,estado FROM cuentas Where DNICliente_Cuenta = '"+DNI+"' and estado=1");
			
			while(rs.next()) {
				Cuenta cuentaL = new Cuenta(); 
				cuentaL.setNumeroDeCuenta(rs.getInt("numeroDeCuenta"));
				cuentaL.setDNICliente_Cuenta(rs.getString("DNICliente_Cuenta"));
				cuentaL.setCBU(rs.getString("CBU"));
				cuentaL.setTipoDeCuenta(rs.getInt("tipoCuenta"));
				cuentaL.setFechaDeCreacion(rs.getString("fechaDeCreacion"));
				cuentaL.setSaldo(rs.getFloat("saldo"));
				cuentaL.setEstado(rs.getBoolean("estado"));
				
				Lista.add(cuentaL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Lista;
	}
	
	public int ActualizarCuenta(Cuenta cuenta,String NumCuenta) {
		
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
			String query = "UPDATE cuentas SET  CBU='"+ cuenta.getCBU()+"',tipoCuenta='"+ cuenta.getTipoDeCuenta()+"',fechaDeCreacion='"+cuenta.getFechaDeCreacion()+"',saldo='"+cuenta.getSaldo()+"', estado = 1 WHERE numeroDeCuenta = '"+NumCuenta+"'";
			filas = st.executeUpdate(query); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas; 
	}
	
	public Cuenta GetByNumeroCuenta(String NumCuenta) {
		Cuenta CuentaL = new Cuenta();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT numeroDeCuenta, DNICliente_Cuenta, CBU, tipoCuenta,fechaDeCreacion, saldo,estado FROM cuentas WHERE numeroDeCuenta='"+NumCuenta+"' and estado=1");
			rs.next();
			CuentaL.setNumeroDeCuenta(Integer.parseInt(NumCuenta));
			CuentaL.setDNICliente_Cuenta(rs.getString("DNICliente_Cuenta"));
			CuentaL.setCBU(rs.getString("CBU"));
			CuentaL.setTipoDeCuenta(rs.getInt("tipoCuenta"));
			CuentaL.setFechaDeCreacion(rs.getString("fechaDeCreacion"));
			CuentaL.setSaldo(rs.getFloat("saldo"));
			CuentaL.setEstado(rs.getBoolean("estado"));
			
			
			cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return CuentaL;
	}
	public String GetDNIByNumeroCuenta(String NumCuenta) {
		Cuenta CuentaL = new Cuenta();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT DNICliente_Cuenta FROM cuentas WHERE numeroDeCuenta='"+NumCuenta+"'");
			rs.next();
			
			CuentaL.setDNICliente_Cuenta(rs.getString("DNICliente_Cuenta"));
			
			
			
			cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return CuentaL.getDNICliente_Cuenta();
	}
	public ArrayList<Cuenta> ObtenerCuentasFiltrados(int num){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		
		ArrayList<Cuenta> Lista = new ArrayList<Cuenta>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			//ListarClientes ls = new ListarClientes();
			//String ddl = rs.get;
			ResultSet rs = st.executeQuery("SELECT numeroDeCuenta, DNICliente_Cuenta, CBU, tipoCuenta,fechaDeCreacion, saldo,estado FROM cuentas WHERE numeroDeCuenta LIKE'"+num+"%'");
			
			while(rs.next()) {
				Cuenta CuentaL = new Cuenta();
				CuentaL.setNumeroDeCuenta(rs.getInt("numeroDeCuenta"));
				CuentaL.setDNICliente_Cuenta(rs.getString("DNICliente_Cuenta"));
				CuentaL.setCBU(rs.getString("CBU"));
				CuentaL.setTipoDeCuenta(rs.getInt("tipoCuenta"));
				CuentaL.setFechaDeCreacion(rs.getString("fechaDeCreacion"));
				CuentaL.setSaldo(rs.getFloat("saldo"));
				CuentaL.setEstado(rs.getBoolean("estado"));
				
				
				Lista.add(CuentaL);
				
			}
			cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
		}

		return Lista;

		
	}
	
	
	public ArrayList<Cuenta> ObtenerCuentasFiltradosPorFecha(String desde, String hasta){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		
		ArrayList<Cuenta> Lista = new ArrayList<Cuenta>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			//ListarClientes ls = new ListarClientes();
			//String ddl = rs.get;
			ResultSet rs = st.executeQuery("SELECT numeroDeCuenta, DNICliente_Cuenta, CBU, tipoCuenta,fechaDeCreacion, saldo,estado FROM cuentas WHERE fechaDeCreacion >= '"+desde+"' and fechaDeCreacion <= '"+hasta+"' ");
			
			while(rs.next()) {
				Cuenta CuentaL = new Cuenta();
				CuentaL.setNumeroDeCuenta(rs.getInt("numeroDeCuenta"));
				CuentaL.setDNICliente_Cuenta(rs.getString("DNICliente_Cuenta"));
				CuentaL.setCBU(rs.getString("CBU"));
				CuentaL.setTipoDeCuenta(rs.getInt("tipoCuenta"));
				CuentaL.setFechaDeCreacion(rs.getString("fechaDeCreacion"));
				CuentaL.setSaldo(rs.getFloat("saldo"));
				CuentaL.setEstado(rs.getBoolean("estado"));
				
				
				Lista.add(CuentaL);
				
			}
			cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
		}

		return Lista;

		
	}
	
	
	public int TrasnferirDinero(String NumCuentaOrigen, String CBU_Destino, float monto)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		int filas = 0; 
		int filas2 = 0; 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			String query ="UPDATE cuentas set Saldo=Saldo -"+monto+" where numeroDeCuenta="+NumCuentaOrigen+";";
			filas = st.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			String query ="UPDATE cuentas set saldo=saldo +"+monto +"where CBU='"+CBU_Destino+"';";
			filas2 = st.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filas; 
		
		
	}
	public ArrayList<Cuenta> ObtenerCuentaFiltro(String num, String Simbolo, int segundovalor){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Cuenta> Lista = new ArrayList<Cuenta>(); 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery("SELECT numeroDeCuenta, DNICliente_Cuenta, CBU, tipoCuenta,fechaDeCreacion, saldo,estado FROM cuentas Where " + num + " " + Simbolo + " " + segundovalor);
			
			while(rs.next()) {
				Cuenta cuentaL = new Cuenta(); 
				cuentaL.setNumeroDeCuenta(rs.getInt("numeroDeCuenta"));
				cuentaL.setDNICliente_Cuenta(rs.getString("DNICliente_Cuenta"));
				cuentaL.setCBU(rs.getString("CBU"));
				cuentaL.setTipoDeCuenta(rs.getInt("tipoCuenta"));
				cuentaL.setFechaDeCreacion(rs.getString("fechaDeCreacion"));
				cuentaL.setSaldo(rs.getFloat("saldo"));
				cuentaL.setEstado(rs.getBoolean("estado"));
				
				Lista.add(cuentaL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Lista;
	}
	public ArrayList<Cuenta> ObtenerCuentaFiltroLargo(String num, String Simbolo, long segundovalor){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Cuenta> Lista = new ArrayList<Cuenta>(); 
		Connection cn = null; 
		
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass); 
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery("SELECT numeroDeCuenta, DNICliente_Cuenta, CBU, tipoCuenta,fechaDeCreacion, saldo,estado FROM cuentas Where " + num + " " + Simbolo + " " + segundovalor);
			
			while(rs.next()) {
				Cuenta cuentaL = new Cuenta(); 
				cuentaL.setNumeroDeCuenta(rs.getInt("numeroDeCuenta"));
				cuentaL.setDNICliente_Cuenta(rs.getString("DNICliente_Cuenta"));
				cuentaL.setCBU(rs.getString("CBU"));
				cuentaL.setTipoDeCuenta(rs.getInt("tipoCuenta"));
				cuentaL.setFechaDeCreacion(rs.getString("fechaDeCreacion"));
				cuentaL.setSaldo(rs.getFloat("saldo"));
				cuentaL.setEstado(rs.getBoolean("estado"));
				
				Lista.add(cuentaL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Lista;
	}
	public int GetNumCuentaByCBU(String CBU) {
	    int numCuenta = -1; // Inicializar con un valor por defecto o un valor que indique error
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    Connection cn = null;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        String query = "SELECT numerodecuenta FROM cuentas WHERE CBU = ?";
	        
	        try (PreparedStatement st = cn.prepareStatement(query)) {
	            st.setString(1, CBU);
	            ResultSet resultSet = st.executeQuery();

	            if (resultSet.next()) {
	                numCuenta = resultSet.getInt("numerodecuenta");
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
	public String GetNumCuentaByUsuario(String U) {
	    String numCuenta = null ; // Inicializar con un valor por defecto o un valor que indique error
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    Connection cn = null;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        String query = "SELECT DNI_CL from Clientes where  nombreUsuario_CL= ?";
	        
	        try (PreparedStatement st = cn.prepareStatement(query)) {
	            st.setString(1, U);
	            
	            
	            ResultSet resultSet = st.executeQuery();

	            if (resultSet.next()) {
	                numCuenta = resultSet.getString("DNI_CL");
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
	public String getCBUByNumCuenta(String numCuenta)
	{

	    String CBU = null ; // Inicializar con un valor por defecto o un valor que indique error
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    Connection cn = null;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        String query = "SELECT CBU from Cuentas where  numeroDeCuenta= ?";
	        
	        try (PreparedStatement st = cn.prepareStatement(query)) {
	            st.setString(1, numCuenta);
	            
	            
	            ResultSet resultSet = st.executeQuery();

	            if (resultSet.next()) {
	                CBU = resultSet.getString("CBU");
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

	    return CBU;
	
	}
	public Boolean verificarSaldo(int nCuenta, float Monto)
	{float resultado=0;
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    Connection cn = null;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        String query = "SELECT saldo from Cuentas where  numeroDeCuenta=?";
	        
	        try (PreparedStatement st = cn.prepareStatement(query)) {
	            
	            st.setInt(1, nCuenta);
	            
	            
	            ResultSet resultSet = st.executeQuery();

	            if (resultSet.next()) {
	                resultado = resultSet.getFloat("Saldo")-Monto;
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
	    if(resultado>=0) {
	    return true;
	    }else {
	    return false;
	    }
		
	}
	public Boolean verificarEstado(int CBU)
	{boolean resultado = false;
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    Connection cn = null;

	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        String query = "SELECT estado from Cuentas where  CBU=?";
	        
	        try (PreparedStatement st = cn.prepareStatement(query)) {
	            
	            st.setInt(1, CBU);
	            
	            
	            ResultSet resultSet = st.executeQuery();

	            if (resultSet.next()) {
	                resultado = resultSet.getBoolean("estado");
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
	   return resultado;
		
	}
}
