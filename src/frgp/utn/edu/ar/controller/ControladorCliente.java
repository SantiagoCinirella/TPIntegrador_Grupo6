package frgp.utn.edu.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.negocio.NegPersona;

@Controller
public class ControladorCliente {

	@Autowired
	@Qualifier("servicioPersona")
	private NegPersona negocioPersona;
	@Autowired
	private Persona persona;

	@RequestMapping("agregarCliente.html")
	public ModelAndView eventoRedireccionarPag1(String txtEmail, Integer txtDNI, String txtNombre, String txtApellido,
			String btnCrear) {
		ModelAndView MV = new ModelAndView();
		persona.setApellido(txtApellido);
		persona.setDni(txtDNI);
		persona.setNombre(txtNombre);
		persona.setEmail(txtEmail);
		boolean agregarModificar = false;

		try {
			if (btnCrear != null) {
				agregarModificar = negocioPersona.agregarPersona(persona);
			} else {
				agregarModificar = negocioPersona.editarPersona(persona);
			}
			MV.addObject("agregadoExitoso", agregarModificar);
			MV.addObject("esBotonCrear", btnCrear);
			MV.setViewName("AltaUsuarios");
		} catch (Exception e) {
			MV.setViewName("AltaUsuarios");
			return MV;
		}
		return MV;
	}
}
