package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.interfazDao.InterfacePersonaDao;
import frgp.utn.edu.ar.dao.queries.ClienteQueries;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Persona;

@Repository("daoPersona")
public class DaoPersona implements InterfacePersonaDao {

	@Autowired
	private Conexion conexion;

	@Autowired
	private Persona persona;

	public DaoPersona() {}

	public DaoPersona(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public List<Persona> listarPersonas() {
		Session session = null;
		try {
			session = conexion.abrirConexion();
			Transaction tx = session.beginTransaction();
			ArrayList<Persona> listaPersonas = (ArrayList<Persona>) session.createCriteria(Persona.class).list();
			tx = session.getTransaction();
			return listaPersonas;
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<Persona> listarPersonasBajaLogica() {

		Session session = null;
		try {
			session = conexion.abrirConexion();
			Transaction tx = session.beginTransaction();
			ArrayList<Persona> listaPersonas = (ArrayList<Persona>) session
					.createQuery(
							"SELECT p FROM Persona p INNER JOIN p.usuario u WHERE p.estado=0 AND u.tipoUsuario = 1)")
					.list();
			return listaPersonas;
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public boolean eliminarUsuario(int idUsuario) {
		Transaction tx = null;
		boolean aux = true;
		Session session = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			persona.setDni(idUsuario);
			session.delete(persona);
			tx = session.getTransaction();
			tx.commit();
		} catch (Exception e) {
			aux = false;
			tx.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return aux;
	}

	@Override
	public boolean bajaLogica(int dni) {
		Session session = null;
		Transaction tx = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			String queryUpdate = "UPDATE Persona p SET p.estado = 1 WHERE p.dni = ?";
			Query update = session.createQuery(queryUpdate);
			update.setParameter(0, dni);
			int executeUpdate = update.executeUpdate();
			tx.commit();
			return executeUpdate != 0;
		} catch (Exception e) {
			tx.rollback();
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public boolean bajaLogicaCuenta(int dni) {
		Session session = null;
		Transaction tx = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			String queryUpdate = "UPDATE Cuenta p SET p.estado = 1 WHERE p.cbu = ?";
			Query update = session.createQuery(queryUpdate);
			update.setParameter(0, dni);
			int executeUpdate = update.executeUpdate();
			tx.commit();
			return executeUpdate != 0;
		} catch (Exception e) {
			tx.rollback();
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public boolean bajaLogicaUsuarioLogin(int dni) {
		Session session = null;
		Transaction tx = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			String queryUpdate = "UPDATE UsuarioLogin p SET p.estado = 1 WHERE p.dni = ?";
			Query update = session.createQuery(queryUpdate);
			update.setParameter(0, dni);
			int executeUpdate = update.executeUpdate();
			tx.commit();
			return executeUpdate != 0;
		} catch (Exception e) {
			tx.rollback();
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public boolean agregarPersona(Persona p) {
		boolean aux = true;
		Session session = null;
		Transaction tx = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			session.save(p);
			session.update(p);
			tx = session.getTransaction();
			session.flush();
			tx.commit();
		} catch (Exception e) {
			aux = false;
			tx.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return aux;
	}

	@Override
	public boolean editarPersona(Persona persona) {
		Session session = null;
		Transaction tx = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			session.update(persona);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public Persona obtenerPersona(int dni) {

		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query busqueda = session.createQuery(ClienteQueries.BUSCA_CLIENTE_TIPO_USUARIO_SQL.getQuery());
			persona = (Persona) busqueda.setParameter(0, dni).uniqueResult();
			ArrayList<Persona> listaPersonas = (ArrayList<Persona>) session.createCriteria(Persona.class).list();
			return persona;
		} catch (Exception e) {
			return persona;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public Persona obtenerPersonaParaLogin(int dni) {

		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query busqueda = session.createQuery(ClienteQueries.BUSCA_CLIENTE_SQL.getQuery());
			persona = (Persona) busqueda.setParameter(0, dni).uniqueResult();
			ArrayList<Persona> listaPersonas = (ArrayList<Persona>) session.createCriteria(Persona.class).list();
			return persona;
		} catch (Exception e) {
			return persona;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<Integer> obtenerCuentaxCliente(int dni) {
		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query buscarCBU = session.createQuery("SELECT p.cbu FROM Cuenta p WHERE p.dni = ? and p.estado = 0");
			buscarCBU.setParameter(0, dni);
			ArrayList<Integer> listaCbu = (ArrayList<Integer>) buscarCBU.list();
			return listaCbu;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public Cuenta obtenerCuentaxCbu(int dni) {
		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query buscarCuenta = session.createQuery("SELECT p FROM Cuenta p WHERE p.cbu = ? and p.estado = 0");
			buscarCuenta.setParameter(0, dni);
			Cuenta Cuenta = (Cuenta) buscarCuenta.uniqueResult();
			return Cuenta;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public List<Cuenta> obtenerCuenta(int dni) {
		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query buscarCuenta = session.createQuery("SELECT p FROM Cuenta p WHERE p.dni = ? and p.estado = 0");
			buscarCuenta.setParameter(0, dni);
			ArrayList<Cuenta> listaCbu = (ArrayList<Cuenta>) buscarCuenta.list();
			return listaCbu;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public boolean verificarDniExistente(Integer dni) throws Exception {
		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query existeDni = session.createQuery(ClienteQueries.VERIFICAR_CLIENTE_EXISTENTE.getQuery());
			existeDni.setParameter(0, dni);
			return existeDni.uniqueResult() == null ? true : false;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			session.close();
		}
	}
}
