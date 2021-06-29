package frgp.utn.edu.ar.dao.daoImpl;

import frgp.utn.edu.ar.entidad.UsuarioLogin;

public interface LoginDaoImpl {

	public boolean verificarUsuario(String usuario, String password);

	public UsuarioLogin buscarRol(String usuario, String password);

}
