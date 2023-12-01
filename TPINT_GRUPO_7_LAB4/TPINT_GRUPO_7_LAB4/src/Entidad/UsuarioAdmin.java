package Entidad;

public class UsuarioAdmin {
	private int numeroUsuarioAdmin; 
	private String nombreUsuarioAdmin; 
	private String contrase�aUsuarioAdmin;
	
	public UsuarioAdmin() {
		
	}

	public UsuarioAdmin(int numeroUsuarioAdmin, String nombreUsuarioAdmin, String contrase�aUsuarioAdmin) {
		super();
		this.numeroUsuarioAdmin = numeroUsuarioAdmin;
		this.nombreUsuarioAdmin = nombreUsuarioAdmin;
		this.contrase�aUsuarioAdmin = contrase�aUsuarioAdmin;
	}

	public int getNumeroUsuarioAdmin() {
		return numeroUsuarioAdmin;
	}

	public void setNumeroUsuarioAdmin(int numeroUsuarioAdmin) {
		this.numeroUsuarioAdmin = numeroUsuarioAdmin;
	}

	public String getNombreUsuarioAdmin() {
		return nombreUsuarioAdmin;
	}

	public void setNombreUsuarioAdmin(String nombreUsuarioAdmin) {
		this.nombreUsuarioAdmin = nombreUsuarioAdmin;
	}

	public String getContrase�aUsuarioAdmin() {
		return contrase�aUsuarioAdmin;
	}

	public void setContrase�aUsuarioAdmin(String contrase�aUsuarioAdmin) {
		this.contrase�aUsuarioAdmin = contrase�aUsuarioAdmin;
	}

	@Override
	public String toString() {
		return "UsuarioAdmin [numeroUsuarioAdmin=" + numeroUsuarioAdmin + ", nombreUsuarioAdmin=" + nombreUsuarioAdmin
				+ ", contrase�aUsuarioAdmin=" + contrase�aUsuarioAdmin + "]";
	}
	
	
	
}
