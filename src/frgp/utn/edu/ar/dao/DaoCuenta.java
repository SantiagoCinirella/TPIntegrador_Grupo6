package frgp.utn.edu.ar.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.entidad.Cuenta;

@Repository("daoCuenta")
public class DaoCuenta {
	
	@Autowired
	private Conexion conexion = new Conexion();
	
	public List<Cuenta> listarCuentas() {
		
		Session session = conexion.abrirConexion();
		Transaction tx= session.beginTransaction();
		Cuenta cuenta; 
		
		/*String hql = "FROM Employee E";
		Query query = session.createQuery(hql);
		List results = query.list();*/
		
		ArrayList<Cuenta> listaCuentas = (ArrayList<Cuenta>) session.createCriteria(Cuenta.class).list();
		
		//cuenta = (Cuenta) session.get(Cuenta.class,"ID");
		tx = session.getTransaction();
		
		return listaCuentas;
		
	}
	
public List<Cuenta> listarCuentasBajaLogica() {
		
	try {
		Session session = conexion.abrirConexion();
		Transaction tx= session.beginTransaction();
		ArrayList<Cuenta> listaPersonas = (ArrayList<Cuenta>) session.createQuery("SELECT p FROM Cuenta p WHERE p.estado=0)").list();
		session.close();
		return listaPersonas;
	}
	catch(Exception ex)
	{
		throw ex;
	}

		
	}
	
	public boolean eliminarCuenta(int NumeroCuenta) {
		Session session = conexion.abrirConexion();
		Transaction tx= session.beginTransaction();
		boolean aux = true;		
		try
		{		
			Cuenta cuenta = new Cuenta();
			cuenta.setCbu(NumeroCuenta);
			session.delete(cuenta); 
			tx = session.getTransaction();
			tx.commit();
		}
		catch (Exception e) {
			aux=false;
			tx.rollback();
		}
		//conexion.cerrarSession();
		session.close();
		return aux;
	}

	public boolean agregarCuenta (Cuenta c) {
		
		Session session = conexion.abrirConexion();
		Transaction tx= session.beginTransaction();
		boolean aux = true;
		try
		{
			session.save(c); 
			tx = session.getTransaction();
			tx.commit();
		}
		catch (Exception e) {
			aux=false;
			tx.rollback();
		}
		conexion.cerrarSession();
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
}
