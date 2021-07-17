package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.interfazDao.InterfaceLoginDao;
import frgp.utn.edu.ar.dao.queries.UsuarioLoginQueries;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.entidad.UsuarioLogin;

@Repository("loginDao")
public class LoginDao implements InterfaceLoginDao {

	@Autowired
	private Conexion conexion;

	@Autowired
	private UsuarioLogin UsuarioLogin;

	@Autowired
	private Persona persona;

	@Override
	public Persona verificarUsuario(String usuario, String password) {
		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query verificarUsuario = session.createQuery(UsuarioLoginQueries.VERIFICAR_USUARIO_SQL.getQuery());
			verificarUsuario.setParameter(0, password);
			verificarUsuario.setParameter(1, usuario);
			ArrayList<UsuarioLogin> listaPersonas = (ArrayList<UsuarioLogin>) verificarUsuario.list();
			for (UsuarioLogin usuarioLogin : listaPersonas) {
				if (!listaPersonas.isEmpty()) {
					persona = (Persona) session.get(Persona.class, usuarioLogin.getDni());
				}
			}
			return persona;
		} catch (Exception e) {
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public UsuarioLogin buscarRol(String usuario, String password) {

		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query buscarRol = session.createQuery(
					"SELECT p.tipoUsuario FROM UsuarioLogin p WHERE p.password = ? and p.usuario = ? and p.estado = 0");
			buscarRol.setParameter(0, password);
			buscarRol.setParameter(1, usuario);
			boolean tipoRol = (boolean) buscarRol.uniqueResult();

			UsuarioLogin.setTipoUsuario(tipoRol);

			Query buscardni = session.createQuery(
					"SELECT p.dni FROM UsuarioLogin p WHERE p.password = ? and p.usuario = ? and p.estado = 0");
			buscardni.setParameter(0, password);
			buscardni.setParameter(1, usuario);
			int dni = (int) buscardni.uniqueResult();
			UsuarioLogin.setDni(dni);
			return UsuarioLogin;
		} catch (Exception e) {
			return null;
		} finally {
			if (session != null)
				session.close();
		}

	}
}
