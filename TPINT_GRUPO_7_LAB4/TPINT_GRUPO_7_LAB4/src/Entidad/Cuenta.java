package Entidad;

import java.sql.Date;

public class Cuenta {
	private int numeroDeCuenta;
	private String DNICliente_Cuenta;
	private String CBU; 
	private String fechaDeCreacion; 
	private int tipoDeCuenta;
	private float saldo; 
	private boolean estado;
	
	public Cuenta() {
	}

	public Cuenta(int numeroDeCuenta, String dNICliente_Cuenta, int numeroUsuario, String cBU, String fechaDeCreacion,
			float saldo, boolean estado) {
		this.numeroDeCuenta = numeroDeCuenta;
		DNICliente_Cuenta = dNICliente_Cuenta;
		CBU = cBU;
		this.fechaDeCreacion = fechaDeCreacion;
		this.saldo = saldo;
		this.estado = estado;
	}

	public int getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(int numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	public String getDNICliente_Cuenta() {
		return DNICliente_Cuenta;
	}

	public void setDNICliente_Cuenta(String dNICliente_Cuenta) {
		DNICliente_Cuenta = dNICliente_Cuenta;
	}

	public String getCBU() {
		return CBU;
	}

	public void setCBU(String cBU) {
		CBU = cBU;
	}

	public String getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(String fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cuenta [numeroDeCuenta=" + numeroDeCuenta + ", DNICliente_Cuenta=" + DNICliente_Cuenta
				 + ", CBU=" + CBU + ", fechaDeCreacion=" + fechaDeCreacion
				+ ", saldo=" + saldo + ", estado=" + estado + "]";
	}


	public int getTipoDeCuenta() {
		return tipoDeCuenta;
	}

	public void setTipoDeCuenta(int tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	} 	
}
