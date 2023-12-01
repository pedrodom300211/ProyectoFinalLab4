package Entidad;

public class UsuarioAdmin {
	private int numeroUsuarioAdmin; 
	private String nombreUsuarioAdmin; 
	private String contraseñaUsuarioAdmin;
	
	public UsuarioAdmin() {
		
	}

	public UsuarioAdmin(int numeroUsuarioAdmin, String nombreUsuarioAdmin, String contraseñaUsuarioAdmin) {
		super();
		this.numeroUsuarioAdmin = numeroUsuarioAdmin;
		this.nombreUsuarioAdmin = nombreUsuarioAdmin;
		this.contraseñaUsuarioAdmin = contraseñaUsuarioAdmin;
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

	public String getContraseñaUsuarioAdmin() {
		return contraseñaUsuarioAdmin;
	}

	public void setContraseñaUsuarioAdmin(String contraseñaUsuarioAdmin) {
		this.contraseñaUsuarioAdmin = contraseñaUsuarioAdmin;
	}

	@Override
	public String toString() {
		return "UsuarioAdmin [numeroUsuarioAdmin=" + numeroUsuarioAdmin + ", nombreUsuarioAdmin=" + nombreUsuarioAdmin
				+ ", contraseñaUsuarioAdmin=" + contraseñaUsuarioAdmin + "]";
	}
	
	
	
}
