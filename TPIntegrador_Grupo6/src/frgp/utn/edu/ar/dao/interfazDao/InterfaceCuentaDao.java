package frgp.utn.edu.ar.dao.interfazDao;

import java.util.List;

import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;

public interface InterfaceCuentaDao {

	public List<Cuenta> listarCuentasBajaLogica();

	public Cuenta buscarSaldo(int cbu);

	public List<Movimiento> listarMovimientos(int cbu);

	public boolean eliminarCuenta(int NumeroCuenta);

	public boolean agregarCuenta(Cuenta c);

	public boolean bajaLogica(int cbu);

	public boolean update(Cuenta cuenta);

	public boolean actualizarSaldo(Cuenta cuenta);

	public int obtenerCuentaMax();

	public int obtenerCbuMax();

	public int getCantidadCuentas(int dni);

	public List<Cuenta> listarCuentas();
}
