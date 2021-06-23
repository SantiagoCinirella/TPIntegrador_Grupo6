package frgp.utn.edu.ar.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.entidad.Cuenta;

@Repository("loginDao")
public class LoginDao {

	@Autowired
	private Conexion conexion;

	public boolean verificarUsuario(String usuario, String password) {
		Session session = conexion.abrirConexion();
		List<Cuenta> list = session.createCriteria(Cuenta.class).list();
		session.beginTransaction();
		session.close();
		return false;
	}

}
