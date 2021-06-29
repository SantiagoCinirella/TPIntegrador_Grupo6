package frgp.utn.edu.ar.negocio.negocioImpl;

import frgp.utn.edu.ar.entidad.UsuarioLogin;

public interface LoginNegocioImpl {

	public boolean verificarUsuario(String usuario, String password);

	public UsuarioLogin buscarRol(String usuario, String password);

}
