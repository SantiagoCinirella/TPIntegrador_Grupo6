package frgp.utn.edu.ar.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.negocio.LoginNegocio;

@Controller
public class ControladorLogin {

	@Qualifier("loginNegocio")
	
	@RequestMapping("altaDeUsuarios.html")
	public ModelAndView eventoRedirectLogin(String txtUsuario, String txtPassword) {

		ModelAndView MV = new ModelAndView();
		boolean verificarUsuario = false;
		try {
			verificarUsuario = new LoginNegocio().verificarUsuario(txtUsuario, txtPassword);
			MV.addObject("verificarUsuario", verificarUsuario);
		} catch (Exception e) {
			MV.addObject("verificarUsuario", verificarUsuario);
		}

		MV.setViewName("AltaUsuarios");
		return MV;
	}

}
