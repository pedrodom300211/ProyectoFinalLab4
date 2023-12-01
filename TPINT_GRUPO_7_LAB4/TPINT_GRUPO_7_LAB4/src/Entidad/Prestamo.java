package Entidad;

public class Prestamo {
	private int numeroPrestamo;
	private int numeroCuentaSolocita;
	private float montoPedido;
	private float MontoConInteres;
	private String  FechaPrestamo;
	private int CuotasPrestamo;
	private int EstadoPrestamo;
	public int getNumeroPrestamo() {
		return numeroPrestamo;
	}
	public void setNumeroPrestamo(int numeroPrestamo) {
		this.numeroPrestamo = numeroPrestamo;
	}
	public int getNumeroCuentaSolocita() {
		return numeroCuentaSolocita;
	}
	public void setNumeroCuentaSolocita(int numeroCuentaSolocita) {
		this.numeroCuentaSolocita = numeroCuentaSolocita;
	}
	public float getMontoPedido() {
		return montoPedido;
	}
	public void setMontoPedido(float montoPedido) {
		this.montoPedido = montoPedido;
	}
	public String getFechaPrestamo() {
		return FechaPrestamo;
	}
	public void setFechaPrestamo(String fechaPrestamo) {
		FechaPrestamo = fechaPrestamo;
	}
	public int getCuotasPrestamo() {
		return CuotasPrestamo;
	}
	public void setCuotasPrestamo(int cuotasPrestamo) {
		CuotasPrestamo = cuotasPrestamo;
	}
	public int isEstadoPrestamo() {
		return EstadoPrestamo;
	}
	public void setEstadoPrestamo(int estadoPrestamo) {
		EstadoPrestamo = estadoPrestamo;
	}
	@Override
	public String toString() {
		return "Prestamo [numeroPrestamo=" + numeroPrestamo + ", numeroCuentaSolocita=" + numeroCuentaSolocita
				+ ", montoPedido=" + montoPedido + ", FechaPrestamo=" + FechaPrestamo + ", CuotasPrestamo="
				+ CuotasPrestamo + ", EstadoPrestamo=" + EstadoPrestamo + "]";
	}
	public float getMontoConInteres() {
		return MontoConInteres;
	}
	public void setMontoConInteres(float montoConInteres) {
		MontoConInteres = montoConInteres;
	}
	
	

}
