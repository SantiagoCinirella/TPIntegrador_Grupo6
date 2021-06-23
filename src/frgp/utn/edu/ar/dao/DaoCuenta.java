package frgp.utn.edu.ar.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.entidad.Cuenta;

@Repository("daoCuenta")
public class DaoCuenta {
	
	@Autowired
	private Conexion conexion;
	
	
	public List<Cuenta> listarCuentas() {
		Session session = conexion.abrirConexion();
		
		List<Cuenta> list = session.createCriteria(Cuenta.class).list();
		session.beginTransaction();
		session.close();
		
		return list;
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
}
