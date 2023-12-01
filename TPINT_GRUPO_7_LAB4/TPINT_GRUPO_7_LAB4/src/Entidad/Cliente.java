package Entidad;

import java.sql.Date;

public class Cliente {
	
private String DNICliente; 
private String Nombre;
private String Apellido;
private TipoCliente TipoCliente;
private String Sexo;
private String CorreoElectronico;
private String Nacionalidad;
private String FechaNacimiento;
private String Direccion;
private String Localidad;
private String Provincia;
private String Telefono ;
private String NombreUsuario;
private String ContrasenaUsuario;
private boolean Estado;

public String getDNICliente() {
	return DNICliente;
}
public void setDNICliente(String dNICliente) {
	DNICliente = dNICliente;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public String getApellido() {
	return Apellido;
}
public void setApellido(String apellido) {
	Apellido = apellido;
}
public String getSexo() {
	return Sexo;
}
public void setSexo(String sexo) {
	Sexo = sexo;
}
public String getCorreoElectronico() {
	return CorreoElectronico;
}
public void setCorreoElectronico(String correoElectronico) {
	CorreoElectronico = correoElectronico;
}
public String getNacionalidad() {
	return Nacionalidad;
}
public void setNacionalidad(String nacionalidad) {
	Nacionalidad = nacionalidad;
}
public String getFechaNacimiento() {
	return FechaNacimiento;
}
public void setFechaNacimiento(String fechaNacimiento) {
	FechaNacimiento = fechaNacimiento;
}
public String getDireccion() {
	return Direccion;
}
public void setDireccion(String direccion) {
	Direccion = direccion;
}
public String getLocalidad() {
	return Localidad;
}
public void setLocalidad(String localidad) {
	Localidad = localidad;
}
public String getProvincia() {
	return Provincia;
}
public void setProvincia(String provincia) {
	Provincia = provincia;
}
public String getTelefono() {
	return Telefono;
}
public void setTelefono(String telefono) {
	Telefono = telefono;
}

public String getNombreUsuario() {
	return NombreUsuario;
}
public void setNombreUsuario(String nombreUsuario) {
	NombreUsuario = nombreUsuario;
}
public String getContrasenaUsuario() {
	return ContrasenaUsuario;
}
public void setContrasenaUsuario(String contrasenaUsuario) {
	ContrasenaUsuario = contrasenaUsuario;
}
public boolean isEstado() {
	return Estado;
}
public void setEstado(boolean estado) {
	Estado = estado;
}
@Override
public String toString() {
	return "Cliente [DNICliente=" + DNICliente + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Sexo=" + Sexo
			+ ", CorreoElectronico=" + CorreoElectronico + ", Nacionalidad=" + Nacionalidad + ", FechaNacimiento="
			+ FechaNacimiento + ", Direccion=" + Direccion + ", Localidad=" + Localidad + ", Provincia=" + Provincia
			+ ", Telefono=" + Telefono + ", Estado=" + Estado + "]";
}

public TipoCliente getTipoCliente() {
	return TipoCliente;
}
public void setTipoCliente(TipoCliente tipoCliente) {
	TipoCliente = tipoCliente;
}



}
