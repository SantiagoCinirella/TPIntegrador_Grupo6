package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ParseConversionEvent;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.queries.ClienteQueries;
import frgp.utn.edu.ar.dao.queries.CuentaQueries;
import frgp.utn.edu.ar.dao.queries.PersonaQueries;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;
import frgp.utn.edu.ar.entidad.Persona;

@Repository("daoCuenta")
public class DaoCuenta {

	@Autowired
	private Conexion conexion = new Conexion();

	public List<Cuenta> listarCuentas() {

		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Cuenta cuenta;

		/*
		 * String hql = "FROM Employee E"; Query query = session.createQuery(hql); List
		 * results = query.list();
		 */

		ArrayList<Cuenta> listaCuentas = (ArrayList<Cuenta>) session.createCriteria(Cuenta.class).list();

		// cuenta = (Cuenta) session.get(Cuenta.class,"ID");
		tx = session.getTransaction();
		conexion.cerrarSession();
		return listaCuentas;

	}

	public List<Cuenta> listarCuentasBajaLogica() {

		try {
			Session session = conexion.abrirConexion();
			Transaction tx = session.beginTransaction();
			ArrayList<Cuenta> listaPersonas = (ArrayList<Cuenta>) session
					.createQuery("SELECT p FROM Cuenta p WHERE p.estado=0)").list();
			session.close();
			return listaPersonas;
		} catch (Exception ex) {
			throw ex;
		}

	}
	
	public List<Movimiento> listarMovimientos(int cbu) {
		try {
			ArrayList<Movimiento> listaMov = new ArrayList<Movimiento>();
			Session session = conexion.abrirConexion();
			Query buscarCBU = session.createQuery("SELECT p FROM Movimiento p WHERE p.cbuDestino = ? or p.cbuOrigen = ? ORDER BY p.fecha DESC");
			buscarCBU.setParameter(0, cbu);
			buscarCBU.setParameter(1, cbu);
			listaMov = (ArrayList<Movimiento>) buscarCBU.list();
			session.close();
			return listaMov;
		} catch (Exception ex) {
			throw ex;
		}

	}

	public boolean eliminarCuenta(int NumeroCuenta) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		boolean aux = true;
		try {
			Cuenta cuenta = new Cuenta();
			cuenta.setCbu(NumeroCuenta);
			session.delete(cuenta);
			tx = session.getTransaction();
			tx.commit();
		} catch (Exception e) {
			aux = false;
			tx.rollback();
		}
		// conexion.cerrarSession();
		session.close();
		return aux;
	}

	public boolean agregarCuenta(Cuenta c) {

		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		boolean aux = true;
		try {
			session.save(c);

			tx.commit();
		} catch (Exception e) {
			aux = false;
			tx.rollback();
		}
		// conexion.cerrarSession();
		session.close();

		return aux;
	}

	public boolean bajaLogica(int cbu) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
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
			session.close();
		}
	}

	public boolean update(Cuenta cuenta) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {

			session.update(cuenta);
			session.getTransaction().commit();

			return true;

		} catch (Exception e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	public int obtenerCuentaMax() {

		int maximaCuenta = 0;

		Session session = conexion.abrirConexion();
		try {

			Query busqueda = session.createQuery(CuentaQueries.BUSCA_MAX_CUENTA_SQL.getQuery());
			maximaCuenta = (int) busqueda.uniqueResult();

			// List results = busqueda.list();
			return maximaCuenta;
		} catch (Exception e) {
			return maximaCuenta;
		} finally {
			session.close();
		}
	}

	public int obtenerCbuMax() {

		int maximaCbu = 0;

		Session session = conexion.abrirConexion();
		try {

			Query busqueda = session.createQuery(CuentaQueries.BUSCA_MAX_CBU_SQL.getQuery());
			maximaCbu = (int) busqueda.uniqueResult();

			// List results = busqueda.list();
			return maximaCbu;
		} catch (Exception e) {
			return maximaCbu;
		} finally {
			session.close();
		}

	}
}
