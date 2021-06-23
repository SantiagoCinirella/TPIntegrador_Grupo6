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
	
	
	@RequestMapping("agregarPersona.html")
	public ModelAndView eventoRedireccionarPag1(Integer txtDni,String txtNombre, String txtApellido)
	{
		ModelAndView MV = new ModelAndView();
		persona.setApellido(txtApellido);
		persona.setDni(txtDni);
		persona.setNombre(txtNombre);
		
		boolean estado= negocioPersona.agregarPersona(persona);
		String cartel="No se pudo agregar la persona";
		if(estado)
		{
			cartel="La persona ha sido agregada exitosamente";
		}
		MV.addObject("estadoAgregarPersona",cartel);
		MV.setViewName("Inicio");
		return MV;
	}
}
