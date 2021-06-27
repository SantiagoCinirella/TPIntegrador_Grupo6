package frgp.utn.edu.ar.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.entidad.UsuarioLogin;
import frgp.utn.edu.ar.negocio.LoginNegocio;
import frgp.utn.edu.ar.negocio.NegPersona;

@Controller
public class ControladorLogin {

	@Qualifier("loginNegocio")
	private NegPersona negocioPersona = new NegPersona();

	@RequestMapping("altaDeUsuarios.html")
	public ModelAndView eventoRedirectLogin(String txtUsuario, String txtPassword, HttpServletRequest request,
			HttpServletResponse response) {
		boolean verificarUsuario = false;
		ModelAndView MV = new ModelAndView();
		try {
			verificarUsuario = new LoginNegocio().verificarUsuario(txtUsuario, txtPassword) ? true : false;
			if (verificarUsuario) {
				Persona persona;
				UsuarioLogin UsuarioLogin = new LoginNegocio().buscarRol(txtUsuario, txtPassword);
				if (UsuarioLogin.getTipoUsuario() == false) {
					persona = new Persona();
					persona = (Persona) negocioPersona.obtenerPersona(UsuarioLogin.getDni());
					HttpSession misession = request.getSession(true);
					misession.setAttribute("Usuario", persona);
					ControladorCuenta ControladorCuenta = new ControladorCuenta();
					return ControladorCuenta.eventoRedireccionarPag1();
				}
				else
				{
					Persona Persona = new Persona();
					Persona = (Persona) negocioPersona.obtenerPersona(UsuarioLogin.getDni());			
					HttpSession misession = request.getSession(true);
					misession.setAttribute("Usuario",Persona);
					ControladorCuenta ControladorCuenta = new ControladorCuenta();
					return ControladorCuenta.eventoRedireccionarPagCliente(UsuarioLogin.getDni());
					
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
