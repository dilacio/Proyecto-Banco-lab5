package frgp.utn.edu.ar.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.DaoPersona;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.interfazNegocio.interfacePersona;

@Service("servicioPersona")
public class NegPersona implements interfacePersona {

	@Autowired
	private DaoPersona daoPersona;

	@Override
	public List<Persona> listarPersonas() {
		return daoPersona.listarPersonas();
	}

	@Override
	public boolean agregarPersona(Persona p) {
		return daoPersona.agregarPersona(p);
	}

	@Override
	public boolean editarPersona(Persona persona) {
		return daoPersona.editarPersona(persona);

	}

	@Override
	public List<Persona> listarPersonasBajaLogica() {
		return daoPersona.listarPersonasBajaLogica();
	}

	@Override
	public boolean eliminarPersona(int dni) {
		return daoPersona.eliminarUsuario(dni);

	}

	@Override
	public boolean bajaLogica(int dni) {
		return daoPersona.bajaLogica(dni);

	}

	@Override
	public boolean bajaLogicaCuenta(int dni) {
		return daoPersona.bajaLogicaCuenta(dni);

	}

	@Override
	public boolean bajaLogicabajaLogicaUsuarioLogin(int dni) {
		return daoPersona.bajaLogicaUsuarioLogin(dni);

	}

	@Override
	public Persona obtenerPersona(int dni) {

		return daoPersona.obtenerPersona(dni);
	}

	@Override
	public Persona obtenerPersonaParaLogin(int dni) {

		return daoPersona.obtenerPersonaParaLogin(dni);
	}

	@Override
	public List<Integer> obtenerCuentaxCliente(int dni) {

		return daoPersona.obtenerCuentaxCliente(dni);
	}

	@Override
	public List<Cuenta> obtenerCuenta(int dni) {

		return daoPersona.obtenerCuenta(dni);
	}

	@Override
	public Cuenta obtenerCuentaxCbu(int cbu) {

		return daoPersona.obtenerCuentaxCbu(cbu);
	}

	@Override
	public boolean verificarDniExistente(Integer dni) throws Exception {
		return daoPersona.verificarDniExistente(dni);
	}
}
