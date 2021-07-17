package frgp.utn.edu.ar.interfazNegocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Persona;

public interface interfacePersona {

	public List<Persona> listarPersonas();

	public boolean agregarPersona(Persona p);

	public boolean editarPersona(Persona persona);

	public List<Persona> listarPersonasBajaLogica();

	public boolean eliminarPersona(int dni);

	public boolean bajaLogica(int dni);

	public boolean bajaLogicaCuenta(int dni);

	public boolean bajaLogicabajaLogicaUsuarioLogin(int dni);

	public Persona obtenerPersona(int dni);

	public Persona obtenerPersonaParaLogin(int dni);

	public List<Integer> obtenerCuentaxCliente(int dni);

	public List<Cuenta> obtenerCuenta(int dni);

	public Cuenta obtenerCuentaxCbu(int cbu);

	public boolean verificarDniExistente(Integer dni) throws Exception;

}
