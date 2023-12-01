package dao;

import java.util.List;

import Entidad.Cuenta;

public interface CuentaDao {
	public boolean insert(Cuenta cuenta);
	public boolean delete(Cuenta cuentaEliminar);
	public List<Cuenta> readAll();
}
