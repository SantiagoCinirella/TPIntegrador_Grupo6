package frgp.utn.edu.ar.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.negocio.NegCuenta;

@Controller
public class ControladorCuenta {

	@Autowired
	@Qualifier("servicioCuenta")
	private NegCuenta negocioCuenta;
	@Autowired
	private Cuenta cuenta;
	
	
	@RequestMapping("agregarCuenta.html")
	public ModelAndView eventoRedireccionarPag2( String txtTipoCuenta,int txtCBU ,int txtNumCuenta, String txtAlias )
	{
		ModelAndView MV = new ModelAndView();
		cuenta.setCbu(txtCBU);
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
	
	@RequestMapping("abmlCuentas.html")
	public ModelAndView eventoRedireccionarPag1()
	{
		NegCuenta negocioCuenta = new NegCuenta();
		ModelAndView MV = new ModelAndView();
		
		ArrayList<Cuenta> listaPersona = new ArrayList<>();
		
		listaPersona = (ArrayList<Cuenta>) negocioCuenta.listarCuentasBajaLogica();
		
		MV.addObject("listaPersona",listaPersona);
		MV.setViewName("ABMLCuentas");
		return MV;

	}
	
	@RequestMapping("eliminacionCuenta.html")
	public ModelAndView eliminar(int numeroCuenta)
	{
		negocioCuenta.bajaLogica(numeroCuenta);	
		ModelAndView MV = new ModelAndView();

		ArrayList<Cuenta> listaPersona = new ArrayList<>();
		
		listaPersona = (ArrayList<Cuenta>) negocioCuenta.listarCuentasBajaLogica();
		
		MV.addObject("listaPersona", listaPersona);
		MV.setViewName("ABMLCuentas");
		return MV;	
		
}

	@RequestMapping("ModificarCuenta.html")
	public ModelAndView modificar(int numeroCuenta, int cbu, String alias, String tipoCuenta)
	{
		Cuenta Cuenta = new Cuenta();
		Cuenta.setAlias(alias);
		Cuenta.setCbu(cbu);
		Cuenta.setNroCuenta(numeroCuenta);
		Cuenta.setTipoCuenta(tipoCuenta);
		ArrayList<Cuenta> listaPersona = new ArrayList<>();
		listaPersona.add(Cuenta);
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaPersona", listaPersona);
		MV.setViewName("AltaDeCuenta");
		return MV;	
		
}
	
}
