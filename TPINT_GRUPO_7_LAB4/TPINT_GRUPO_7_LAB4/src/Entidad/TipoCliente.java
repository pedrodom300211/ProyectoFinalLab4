package Entidad;

public class TipoCliente {
	private int numeroTipoCliente; 
	private String DescripcionTipoCliente;
	public int getNumeroTipoCliente() {
		return numeroTipoCliente;
	}
	public void setNumeroTipoCliente(int numeroTipoCliente) {
		this.numeroTipoCliente = numeroTipoCliente;
	}
	public String getDescripcionTipoCliente() {
		return DescripcionTipoCliente;
	}
	public void setDescripcionTipoCliente(String descripcionTipoCliente) {
		DescripcionTipoCliente = descripcionTipoCliente;
	}
	@Override
	public String toString() {
		return "TipoCliente [numeroTipoCliente=" + numeroTipoCliente + ", DescripcionTipoCliente="
				+ DescripcionTipoCliente + "]";
	}
	
	

}
