package frgp.utn.edu.ar.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.LoginDao;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.entidad.UsuarioLogin;
import frgp.utn.edu.ar.interfazNegocio.interfaceLogin;

@Service("loginNegocio")
public class LoginNegocio implements interfaceLogin {

	@Autowired
	private LoginDao loginDao;

	@Override
	public Persona verificarUsuario(String usuario, String password) {
		return loginDao.verificarUsuario(usuario, password);
	}

	@Override
	public UsuarioLogin buscarRol(String usuario, String password) {
		return loginDao.buscarRol(usuario, password);
	}
}
