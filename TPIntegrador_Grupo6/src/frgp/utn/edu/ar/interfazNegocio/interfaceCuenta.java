package frgp.utn.edu.ar.interfazNegocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;

public interface interfaceCuenta {

	public List<Cuenta> listarCuentas();

	public List<Cuenta> listarCuentasBajaLogica();

	public Cuenta buscarSaldo(int cbu);

	public List<Movimiento> listarMovimientos(int cbu);

	public boolean agregarCuenta(Cuenta p);

	public boolean eliminarCuenta(int numeroCuenta);

	public boolean bajaLogica(int numeroCuenta);

	public boolean update(Cuenta cuenta);

	public boolean actualizarSaldo(Cuenta cuenta);

	public int obtenerCuentaMax();

	public int obtenerCbuMax();

	public int getCantidadCuentas(int dni);

}
