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
import frgp.utn.edu.ar.negocio.LoginNegocio;
import frgp.utn.edu.ar.negocio.NegPersona;

@Controller
public class ControladorLogin {

	@Autowired
	@Qualifier("servicioPersona")
	private NegPersona negocioPersona;
	
	@Autowired
	@Qualifier("loginNegocio")
	private LoginNegocio loginNegocio;
	
	@Autowired
	private Persona Persona;

	@Autowired
	private ControladorCuenta ControladorCuenta;
	
	@RequestMapping("altaDeUsuarios.html")
	public ModelAndView eventoRedirectLogin(String txtUsuario, String txtPassword, HttpServletRequest request,
			HttpServletResponse response) {
		boolean verificarUsuario = false;
		ModelAndView MV = new ModelAndView();
		try {
			Persona = loginNegocio.verificarUsuario(txtUsuario, txtPassword);
			if (!(Persona == null)) {
				if(Persona.getUsuario().getTipoUsuario()== false)
				{
					HttpSession misession = request.getSession(true);
					misession.setAttribute("Usuario", Persona);
					ControladorCuenta ControladorCuenta = new ControladorCuenta();
					return ControladorCuenta.eventoRedireccionarPag1();
				}
				else
				{
					HttpSession misession = request.getSession(true);
					misession.setAttribute("Usuario",Persona);
					return ControladorCuenta.eventoRedireccionarPagCliente(Persona.getDni());
					
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
