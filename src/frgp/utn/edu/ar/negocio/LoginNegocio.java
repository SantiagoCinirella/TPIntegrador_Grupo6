package frgp.utn.edu.ar.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.LoginDao;

@Service("loginNegocio")
public class LoginNegocio {

	@Autowired
	private LoginDao loginDao = new LoginDao();

	public boolean verificarUsuario(String usuario, String password) {
		return loginDao.verificarUsuario(usuario, password);
	}

}