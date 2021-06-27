package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.queries.ClienteQueries;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Persona;

@Repository("daoPersona")
public class DaoPersona {

	@Autowired
	private Conexion conexion = new Conexion();

	public List<Persona> listarPersonas() {

		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		ArrayList<Persona> listaPersonas = (ArrayList<Persona>) session.createCriteria(Persona.class).list();
		tx = session.getTransaction();
		return listaPersonas;
	}

	public List<Persona> listarPersonasBajaLogica() {

		Session session = conexion.abrirConexion();
		ArrayList<Persona> listaPersonas = (ArrayList<Persona>) session
				.createQuery("SELECT p FROM Persona p WHERE p.estado=0)").list();
		session.close();
		return listaPersonas;

	}

	public boolean eliminarUsuario(int idUsuario) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		boolean aux = true;
		try {
			Persona user = new Persona();
			user.setDni(idUsuario);
			session.delete(user);
			tx = session.getTransaction();
			tx.commit();
		} catch (Exception e) {
			aux = false;
			tx.rollback();
		}
		session.close();
		return aux;
	}

	public boolean bajaLogica(int dni) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
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
			session.close();
		}
	}
	public boolean bajaLogicaCuenta(int dni) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
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
			session.close();
		}
	}
	public boolean bajaLogicaUsuarioLogin(int dni) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
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
			session.close();
		}
	}
	
	public boolean agregarPersona(Persona p) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		boolean aux = true;
		try {
			session.save(p);
			tx = session.getTransaction();
			tx.commit();
		} catch (Exception e) {
			aux = false;
			tx.rollback();
		}
		session.close();
		return aux;
	}

	public boolean editarPersona(Persona persona) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			session.update(persona);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	public Persona obtenerPersona(int dni) {

		Persona persona = new Persona();
		Session session = conexion.abrirConexion();
		try {
			Query busqueda = session.createQuery(ClienteQueries.BUSCA_CLIENTE_SQL.getQuery());
			persona = (Persona) busqueda.setParameter(0, dni).uniqueResult();
			return persona;
		} catch (Exception e) {
			return persona;
		} finally {
			session.close();
		}
	}
	
	public List<Integer> obtenerCuentaxCliente(int dni) {
		try {
			Session session = conexion.abrirConexion();
			Query buscarCBU = session.createQuery("SELECT p.cbu FROM Cuenta p WHERE p.dni = ? and p.estado = 0");
			buscarCBU.setParameter(0, dni);
			ArrayList<Integer> listaCbu = (ArrayList<Integer>) buscarCBU.list();
			session.close();
			return listaCbu;
		} catch (Exception ex) {
			throw ex;
		}

	}
	
	
	public List<Cuenta> obtenerCuenta(int dni) {
		try {
			Session session = conexion.abrirConexion();
			Query buscarCuenta = session.createQuery("SELECT p FROM Cuenta p WHERE p.dni = ? and p.estado = 0");
			buscarCuenta.setParameter(0, dni);
			ArrayList<Cuenta> listaCbu = (ArrayList<Cuenta>) buscarCuenta.list();
			session.close();
			return listaCbu;
		} catch (Exception ex) {
			throw ex;
		}

	}

	public boolean verificarDniExistente(Integer dni) throws Exception {
		Persona persona = new Persona();
		Session session = conexion.abrirConexion();

		try {
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
