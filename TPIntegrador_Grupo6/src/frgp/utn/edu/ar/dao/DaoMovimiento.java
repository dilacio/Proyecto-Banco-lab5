package frgp.utn.edu.ar.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.interfazDao.InterfaceMovimientoDao;
import frgp.utn.edu.ar.entidad.Movimiento;

@Repository("daoMovimiento")
public class DaoMovimiento implements InterfaceMovimientoDao{

	@Autowired
	private Conexion conexion;
	
	public DaoMovimiento() {}
	
	public DaoMovimiento(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public Boolean agregarMovimiento(Movimiento mov) {
		boolean aux = true;
		Session session = null;
		Transaction tx = null;
		try {
			session = conexion.abrirConexion();
			tx = session.beginTransaction();
			session.save(mov);
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
}
