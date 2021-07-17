package frgp.utn.edu.ar.dao.interfazDao;

import java.util.List;

import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Persona;

public interface InterfacePersonaDao {

	public List<Persona> listarPersonas();

	public List<Persona> listarPersonasBajaLogica();

	public boolean eliminarUsuario(int idUsuario);

	public boolean bajaLogica(int dni);

	public boolean bajaLogicaCuenta(int dni);

	public boolean bajaLogicaUsuarioLogin(int dni);

	public boolean agregarPersona(Persona p);

	public boolean editarPersona(Persona persona);

	public Persona obtenerPersona(int dni);

	public Persona obtenerPersonaParaLogin(int dni);

	public List<Integer> obtenerCuentaxCliente(int dni);

	public Cuenta obtenerCuentaxCbu(int dni);

	public List<Cuenta> obtenerCuenta(int dni);

	public boolean verificarDniExistente(Integer dni) throws Exception;
}
