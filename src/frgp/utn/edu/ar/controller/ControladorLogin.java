package frgp.utn.edu.ar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.entidad.UsuarioLogin;
import frgp.utn.edu.ar.negocio.LoginNegocio;
import frgp.utn.edu.ar.negocio.NegPersona;

@Controller
public class ControladorLogin {

	private NegPersona negocioPersona;

	private Persona persona;
	private UsuarioLogin usuarioLogin;

	private LoginNegocio loginNegocio;

	@Autowired
	@Qualifier(value = "LoginNegocio")
	public void setPersonService(LoginNegocio lg) {
		this.loginNegocio = lg;
	}

	@RequestMapping("altaDeUsuarios.html")
	public ModelAndView eventoRedirectLogin(String txtUsuario, String txtPassword, HttpServletRequest request,
			HttpServletResponse response) {
		boolean verificarUsuario = false;
		ModelAndView MV = new ModelAndView();
		try {
			verificarUsuario = loginNegocio.verificarUsuario(txtUsuario, txtPassword) ? true : false;
			if (verificarUsuario) {
				usuarioLogin = new LoginNegocio().buscarRol(txtUsuario, txtPassword);
				if (usuarioLogin.getTipoUsuario() == false) {
					persona = (Persona) negocioPersona.obtenerPersonaParaLogin(usuarioLogin.getDni());
					HttpSession misession = request.getSession(true);
					misession.setAttribute("Usuario", persona);
					ControladorCuenta ControladorCuenta = new ControladorCuenta();
					return ControladorCuenta.eventoRedireccionarPag1();
				} else {
					persona = (Persona) negocioPersona.obtenerPersonaParaLogin(usuarioLogin.getDni());
					HttpSession misession = request.getSession(true);
					misession.setAttribute("Usuario", persona);
					ControladorCuenta ControladorCuenta = new ControladorCuenta();
					return ControladorCuenta.eventoRedireccionarPagCliente(usuarioLogin.getDni());
				}

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
