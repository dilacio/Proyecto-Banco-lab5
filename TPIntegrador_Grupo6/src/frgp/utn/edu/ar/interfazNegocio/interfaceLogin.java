package frgp.utn.edu.ar.interfazNegocio;

import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.entidad.UsuarioLogin;

public interface interfaceLogin {

	public Persona verificarUsuario(String usuario, String password);

	public UsuarioLogin buscarRol(String usuario, String password);

}
