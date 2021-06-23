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
			//TODO descomentar esto cuando se haya implementado la funcionalidad correctamente
			verificarUsuario = true;//new LoginNegocio().verificarUsuario(txtUsuario, txtPassword) ? true : false;
			if (verificarUsuario) {
				MV.setViewName("AltaUsuarios");
			} else {
				MV.setViewName("Login");
			}
			MV.addObject("verificarUsuario", verificarUsuario);
		} catch (Exception e) {
			MV.addObject("verificarUsuario", verificarUsuario);
			MV.setViewName("Login");
			return MV;
		}
		return MV;
	}
}
