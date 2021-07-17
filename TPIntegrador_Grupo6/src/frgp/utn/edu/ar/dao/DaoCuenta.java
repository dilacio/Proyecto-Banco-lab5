package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.interfazDao.InterfaceCuentaDao;
import frgp.utn.edu.ar.dao.queries.CuentaQueries;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;

@Repository("daoCuenta")
public class DaoCuenta implements InterfaceCuentaDao {

	@Autowired
	private Conexion conexion;

	@Autowired
	private Cuenta cuenta;

	public DaoCuenta() {}

	public DaoCuenta(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public List<Cuenta> listarCuentas() {

		Session session = null;
		try {
			session = conexion.abrirConexion();
			Transaction tx = session.beginTransaction();

			ArrayList<Cuenta> listaCuentas = (ArrayList<Cuenta>) session.createCriteria(Cuenta.class).list();

			tx = session.getTransaction();
			return listaCuentas;
		} catch (Exception e) {
			return null;
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public List<Cuenta> listarCuentasBajaLogica() {

		Session session = null;
		try {
			session = conexion.abrirConexion();
			Transaction tx = session.beginTransaction();
			ArrayList<Cuenta> listaPersonas = (ArrayList<Cuenta>) session
					.createQuery("SELECT p FROM Cuenta p WHERE p.estado=0)").list();
			return listaPersonas;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}

	}

	public Cuenta buscarSaldo(int cbu) {
		Session session = null;
		try {
			session = conexion.abrirConexion();
			Transaction tx = session.beginTransaction();

			Query buscarSaldo = session.createQuery("SELECT p FROM Cuenta p WHERE p.cbu = ? ");
			buscarSaldo.setParameter(0, cbu);
			cuenta = (Cuenta) buscarSaldo.uniqueResult();
			return cuenta;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}

	}

	public List<Movimiento> listarMovimientos(int cbu) {
		Session session = null;
		try {
			session = conexion.abrirConexion();
			ArrayList<Movimiento> listaMov = new ArrayList<Movimiento>();
			Query buscarCBU = session
					.createQuery("SELECT p FROM Movimiento p WHERE p.cbuOrigen = ? ORDER BY p.fecha DESC");
			buscarCBU.setParameter(0, cbu);
			listaMov = (ArrayList<Movimiento>) buscarCBU.list();
			return listaMov;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}

	}

	public boolean eliminarCuenta(int NumeroCuenta) {
		boolean aux = true;
		Session session = null;
		Transaction tx = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			cuenta.setCbu(NumeroCuenta);
			session.delete(cuenta);
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

	public boolean agregarCuenta(Cuenta c) {

		boolean aux = true;
		Session session = null;
		Transaction tx = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			session.save(c);
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

	public boolean bajaLogica(int cbu) {
		Session session = null;
		Transaction tx = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			String queryUpdate = "UPDATE Cuenta c SET c.estado = 1 WHERE c.cbu = ?";
			Query update = session.createQuery(queryUpdate);
			update.setParameter(0, cbu);
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

	public boolean update(Cuenta cuenta) {
		Session session = null;
		Transaction tx = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			String queryUpdate = "UPDATE Cuenta c SET c.alias = ? WHERE c.cbu = ?";
			Query update = session.createQuery(queryUpdate);
			update.setParameter(0, cuenta.getAlias());
			update.setParameter(1, cuenta.getCbu());
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

	public boolean actualizarSaldo(Cuenta cuenta) {
		Session session = null;
		Transaction tx = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			String queryUpdate = "UPDATE Cuenta c SET c.saldo = ? WHERE c.cbu = ?";
			Query update = session.createQuery(queryUpdate);
			update.setParameter(0, cuenta.getSaldo());
			update.setParameter(1, cuenta.getCbu());
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

	public int obtenerCuentaMax() {

		int maximaCuenta = 0;
		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query busqueda = session.createQuery(CuentaQueries.BUSCA_MAX_CUENTA_SQL.getQuery());
			maximaCuenta = (int) busqueda.uniqueResult();
			return maximaCuenta;
		} catch (Exception e) {
			return maximaCuenta;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public int obtenerCbuMax() {

		int maximaCbu = 0;
		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query busqueda = session.createQuery(CuentaQueries.BUSCA_MAX_CBU_SQL.getQuery());
			maximaCbu = (int) busqueda.uniqueResult();
			return maximaCbu;
		} catch (Exception e) {
			return maximaCbu;
		} finally {
			if (session != null)
				session.close();
		}

	}

	public int getCantidadCuentas(int dni) {

		int cantidadCuenta = 0;
		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query busqueda = session.createQuery(CuentaQueries.CANT_CUENTAS_SQL.getQuery());
			cantidadCuenta = ((Long) busqueda.setParameter(0, dni).uniqueResult()).intValue();
			return cantidadCuenta;
		} catch (Exception e) {
			return cantidadCuenta;
		} finally {
			if (session != null)
				session.close();
		}

	}
}
