package Entidad;

public class MovimientoCuentas {
private int numeroMovimiento;
private int numeroCuentaEmisor;
private int numeroCunetaReceptor;
private float Monto;
private String  fechaMovimiento;
private String detalleMovimiento;
private String tipoMovimiento;
public int getNumeroMovimiento() {
	return numeroMovimiento;
}
public void setNumeroMovimiento(int numeroMovimiento) {
	this.numeroMovimiento = numeroMovimiento;
}
public int getNumeroCuentaEmisor() {
	return numeroCuentaEmisor;
}
public void setNumeroCuentaEmisor(int numeroCuentaEmisor) {
	this.numeroCuentaEmisor = numeroCuentaEmisor;
}
public int getNumeroCunetaReceptor() {
	return numeroCunetaReceptor;
}
public void setNumeroCunetaReceptor(int numeroCunetaReceptor) {
	this.numeroCunetaReceptor = numeroCunetaReceptor;
}
public float getMonto() {
	return Monto;
}
public void setMonto(float monto) {
	Monto = monto;
}
public String getFechaMovimiento() {
	return fechaMovimiento;
}
public void setFechaMovimiento(String fechaMovimiento) {
	this.fechaMovimiento = fechaMovimiento;
}
public String getDetalleMovimiento() {
	return detalleMovimiento;
}
public void setDetalleMovimiento(String detalleMovimiento) {
	this.detalleMovimiento = detalleMovimiento;
}
public String getTipoMovimiento() {
	return tipoMovimiento;
}
public void setTipoMovimiento(String tipoMovimiento) {
	this.tipoMovimiento = tipoMovimiento;
}
@Override
public String toString() {
	return "MovimientoCuentas [numeroMovimiento=" + numeroMovimiento + ", numeroCuentaEmisor=" + numeroCuentaEmisor
			+ ", numeroCunetaReceptor=" + numeroCunetaReceptor + ", Monto=" + Monto + ", fechaMovimiento="
			+ fechaMovimiento + ", detalleMovimiento=" + detalleMovimiento + ", tipoMovimiento=" + tipoMovimiento + "]";
}






}
