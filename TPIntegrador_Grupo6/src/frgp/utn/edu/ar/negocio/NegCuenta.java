package frgp.utn.edu.ar.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.DaoCuenta;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;
import frgp.utn.edu.ar.interfazNegocio.interfaceCuenta;

@Service("servicioCuenta")
public class NegCuenta implements interfaceCuenta {

	@Autowired
	private DaoCuenta daoCuenta;

	@Override
	public List<Cuenta> listarCuentas() {
		return daoCuenta.listarCuentas();
	}

	@Override
	public List<Cuenta> listarCuentasBajaLogica() {
		return daoCuenta.listarCuentasBajaLogica();
	}

	@Override
	public Cuenta buscarSaldo(int cbu) {
		return daoCuenta.buscarSaldo(cbu);
	}

	@Override
	public List<Movimiento> listarMovimientos(int cbu) {
		return daoCuenta.listarMovimientos(cbu);
	}

	@Override
	public boolean agregarCuenta(Cuenta p) {
		return daoCuenta.agregarCuenta(p);
	}

	@Override
	public boolean eliminarCuenta(int numeroCuenta) {
		return daoCuenta.eliminarCuenta(numeroCuenta);

	}

	@Override
	public boolean bajaLogica(int numeroCuenta) {
		return daoCuenta.bajaLogica(numeroCuenta);

	}

	@Override
	public boolean update(Cuenta cuenta) {
		return daoCuenta.update(cuenta);
	}

	@Override
	public boolean actualizarSaldo(Cuenta cuenta) {
		return daoCuenta.actualizarSaldo(cuenta);
	}

	@Override
	public int obtenerCuentaMax() {
		return daoCuenta.obtenerCuentaMax();
	}

	@Override
	public int obtenerCbuMax() {
		return daoCuenta.obtenerCbuMax();
	}

	@Override
	public int getCantidadCuentas(int dni) {
		return daoCuenta.getCantidadCuentas(dni);
	}

}
