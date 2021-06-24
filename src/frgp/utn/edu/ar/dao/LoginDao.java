package frgp.utn.edu.ar.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.entidad.UsuarioLogin;

@Repository("loginDao")
public class LoginDao {

	@Autowired
	private Conexion conexion = new Conexion();

	public boolean verificarUsuario(String usuario, String password) {
		Session session = null;
		Boolean esUsuario = false;
		session = conexion.abrirConexion();
		List<UsuarioLogin> usuarioLogin = session.createCriteria(UsuarioLogin.class).list();
		for (UsuarioLogin user : usuarioLogin) {
			if (user.getPassword().equalsIgnoreCase(usuario) && user.getUsuario().equalsIgnoreCase(usuario))
				esUsuario = true;
		}
		session.close();
		return esUsuario;
	}

}
