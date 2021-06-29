package frgp.utn.edu.ar.negocio;

import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.LoginDao;
import frgp.utn.edu.ar.entidad.UsuarioLogin;
import frgp.utn.edu.ar.negocio.negocioImpl.LoginNegocioImpl;

@Service
public class LoginNegocio implements LoginNegocioImpl{

	private LoginDao loginDao;

	public void setPersonDAO(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	public boolean verificarUsuario(String usuario, String password) {
		return loginDao.verificarUsuario(usuario, password);
	}

	@Override
	public UsuarioLogin buscarRol(String usuario, String password) {
		return loginDao.buscarRol(usuario, password);
	}
}
