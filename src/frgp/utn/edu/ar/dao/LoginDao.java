package frgp.utn.edu.ar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.daoImpl.LoginDaoImpl;
import frgp.utn.edu.ar.dao.queries.UsuarioLoginQueries;
import frgp.utn.edu.ar.entidad.UsuarioLogin;

@Repository("loginDao")
public class LoginDao implements LoginDaoImpl{

	@Autowired
	private Conexion conexion = new Conexion();
	private UsuarioLogin usuarioLogin;
	
	@Override
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
	
	@Override
	public UsuarioLogin buscarRol(String usuario, String password) {
		Session session = conexion.abrirConexion();
		Query buscarRol = session
				.createQuery("SELECT p.tipoUsuario FROM UsuarioLogin p WHERE p.password = ? and p.usuario = ? and p.estado = 0");
		buscarRol.setParameter(0, password);
		buscarRol.setParameter(1, usuario);
		boolean tipoRol = (boolean) buscarRol.uniqueResult();
		usuarioLogin.setTipoUsuario(tipoRol);
		session.close();
		session = conexion.abrirConexion();
		Query buscardni = session
				.createQuery("SELECT p.dni FROM UsuarioLogin p WHERE p.password = ? and p.usuario = ? and p.estado = 0");
		buscardni.setParameter(0, password);
		buscardni.setParameter(1, usuario);
		int dni = (int) buscardni.uniqueResult();
		usuarioLogin.setDni(dni);
		session.close();
		return usuarioLogin;
	}
}
