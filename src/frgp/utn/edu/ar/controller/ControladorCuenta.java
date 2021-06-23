package frgp.utn.edu.ar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;

import org.hibernate.service.config.spi.ConfigurationService.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Cliente;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.negocio.NegCuenta;
import frgp.utn.edu.ar.negocio.NegPersona;

@Controller
public class ControladorCuenta {

	@Autowired
	@Qualifier("servicioCuenta")
	private NegCuenta negocioCuenta;
	@Autowired
	private Cuenta cuenta;
	private Cliente cliente;
	
	
	@RequestMapping("agregarCuenta.html")
	public ModelAndView eventoRedireccionarPag2( String txtTipoCuenta,String txtCBU ,String txtNumCuenta, String txtAlias )
	{
		ModelAndView MV = new ModelAndView();
		cuenta.setCBU(txtCBU);
		cuenta.setTipoCuenta(txtTipoCuenta);
		cuenta.setAlias(txtAlias);
		cuenta.setNroCuenta(txtNumCuenta);
		
		
		boolean estado= negocioCuenta.agregarCuenta(cuenta);
		String cartel="No se pudo agregar la cuenta";
		if(estado)
		{
			cartel="La cuenta ha sido agregada exitosamente";
		}
		MV.addObject("estadoAgregarCuenta",cartel);
		MV.setViewName("AltaDeCuenta");
		return MV;
		
	}
	
	@RequestMapping("recargaGrillaCuentas.html")
	public ModelAndView eventoRedireccionarpage12( String txtTipoCuenta,String txtCBU ,String txtNumCuenta, String txtAlias )
	{
		
		ModelAndView MV = new ModelAndView();
		
		ArrayList<Cuenta> listaCuenta = new ArrayList<>();
		
		listaCuenta = (ArrayList<Cuenta>) negocioCuenta.listarCuentas();
		
		MV.addObject("ListaCuentas",listaCuenta);
		MV.setViewName("AltaDeCuenta");
		return MV;
	}
	
}
