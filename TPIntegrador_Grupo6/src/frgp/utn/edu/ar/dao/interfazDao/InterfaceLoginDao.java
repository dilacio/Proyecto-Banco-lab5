package frgp.utn.edu.ar.dao.interfazDao;

import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.entidad.UsuarioLogin;

public interface InterfaceLoginDao {

	public Persona verificarUsuario(String usuario, String password);

	public UsuarioLogin buscarRol(String usuario, String password);
}
