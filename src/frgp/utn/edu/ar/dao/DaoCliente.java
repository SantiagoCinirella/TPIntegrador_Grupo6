package frgp.utn.edu.ar.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

import frgp.utn.edu.ar.dao.queries.ClienteQueries;
import frgp.utn.edu.ar.dao.queries.PersonaQueries;
import frgp.utn.edu.ar.entidad.Cliente;


@Repository("daoCliente")
public class DaoCliente {
	
	@Autowired
	private Conexion conexion = new Conexion();
	
	
	public List<Cliente> listarClientes() {
		
		Session session = conexion.abrirConexion();
		Transaction tx= session.beginTransaction();
		Cliente cliente; 
		
		/*String hql = "FROM Employee E";
		Query query = session.createQuery(hql);
		List results = query.list();*/
		
		ArrayList<Cliente> listarClientes = (ArrayList<Cliente>) session.createCriteria(Cliente.class).list();
		 
		//cuenta = (Cuenta) session.get(Cuenta.class,"ID");
		tx = session.getTransaction();
		conexion.cerrarSession();
		return listarClientes;
		
	}


	public Cliente obtenerCliente(int dni) {
		
		Cliente cliente = null;
		Session session = conexion.abrirConexion();
		try {
			
			
			Query busqueda = session.createQuery(ClienteQueries.BUSCA_CLIENTE_SQL.getQuery());
			cliente = (Cliente)busqueda.setParameter(0, dni).uniqueResult();
			
			
			//List results = busqueda.list();			
			return cliente;
		} catch (Exception e) {
			return cliente;
		} finally {
			session.close();
		}
	}

	
}
