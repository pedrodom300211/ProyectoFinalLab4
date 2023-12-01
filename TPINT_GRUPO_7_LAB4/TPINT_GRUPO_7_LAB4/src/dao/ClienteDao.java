package dao;

import java.util.List;

import Entidad.Cliente;

public interface ClienteDao {
	public boolean insert(Cliente cliente);
	public boolean delete(Cliente cliente_a_eliminar);
	public List<Cliente> readAll();
	public Cliente GetByDni(String Dni);
	public boolean obtenerUsuario(Cliente cliente);

}
