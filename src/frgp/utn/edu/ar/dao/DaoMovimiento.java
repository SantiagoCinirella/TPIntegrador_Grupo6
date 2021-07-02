package frgp.utn.edu.ar.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.entidad.Movimiento;

@Repository("daoMovimiento")
public class DaoMovimiento {

	@Autowired
	private Conexion conexion = new Conexion();

	public Boolean agregarMovimiento(Movimiento mov) {
		Session session = conexion.abrirConexion();
        Transaction tx = session.beginTransaction();
        boolean aux = true;
        try {
            session.save(mov);
            tx.commit();
        } catch (Exception e) {
            aux = false;
            tx.rollback();
        }
		session.close();
        return aux;
	}

	
}
