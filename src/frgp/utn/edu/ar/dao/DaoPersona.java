package frgp.utn.edu.ar.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

import frgp.utn.edu.ar.entidad.Persona;

@Repository("daoPersona")
public class DaoPersona {

	@Autowired
	private Conexion conexion;

	public List<Persona> listarPersonas() {
		Session session = conexion.abrirConexion();

		session.close();
		return null;
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
		conexion.cerrarSession();
		return aux;
	}

	public boolean editarPersona(Persona persona) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			String queryUpdate = "UPDATE Persona p SET p.apellido = ?, p.nombre = ?, p.email = ? WHERE p.dni = ?";
			Query update = session.createQuery(queryUpdate);
			update.setParameter(0, persona.getApellido());
			update.setParameter(1, persona.getNombre());
			update.setParameter(2, persona.getEmail());
			update.setParameter(3, persona.getDni());
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
}
