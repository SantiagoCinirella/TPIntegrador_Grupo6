package frgp.utn.edu.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.negocio.NegMovimiento;


@Controller
public class ControladorMovimiento {

	@Autowired
	@Qualifier("servicioMovimiento")
	private NegMovimiento negocioMovimiento;
	

	@RequestMapping(value = "/poner_Metodo.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView eventoRedireccionar(String txtDni) {
		ModelAndView MV = new ModelAndView();
		
		MV.setViewName("AltaDeCuenta");
		return MV;
	}

	
}
