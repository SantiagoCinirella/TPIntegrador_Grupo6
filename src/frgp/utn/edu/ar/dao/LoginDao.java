package frgp.utn.edu.ar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.queries.UsuarioLoginQueries;

@Repository("loginDao")
public class LoginDao {

	@Autowired
	private Conexion conexion = new Conexion();

	public boolean verificarUsuario(String usuario, String password) {
		Session session = null;
		try {
			session = conexion.abrirConexion();
			Query verificarUsuario = session.createQuery(UsuarioLoginQueries.VERIFICAR_USUARIO_SQL.getQuery());
			verificarUsuario.setParameter(0, password);
			verificarUsuario.setParameter(1, usuario);
			List results = verificarUsuario.list();
			return !results.isEmpty();
		} catch (Exception e) {
			return false;
		}finally {
			session.close();
		}
	}
}
