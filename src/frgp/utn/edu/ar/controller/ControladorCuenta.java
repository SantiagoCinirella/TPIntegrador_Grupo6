package frgp.utn.edu.ar.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Cliente;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.negocio.NegCliente;
import frgp.utn.edu.ar.negocio.NegCuenta;
import frgp.utn.edu.ar.negocio.NegPersona;

@Controller
public class ControladorCuenta {

	@Autowired
	@Qualifier("servicioCuenta")
	private NegCuenta negocioCuenta;
	private NegCliente negocioCliente;
	@Autowired
	private Cuenta cuenta;
	private Cliente cliente;
	String cartel = null;
	
	@RequestMapping(value ="/buscarCliente.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView eventoRedireccionar(String txtDni)
	{
		ModelAndView MV = new ModelAndView();
		String mensajeCliente = null;
		int dni;
		
		dni = Integer.parseInt(txtDni);
		negocioCliente = new NegCliente();
		cliente = (Cliente) negocioCliente.obtenerCliente(dni);
		
		if(cliente == null) {
			mensajeCliente = "El usuario no existe";
			
		}
		
		MV.addObject("mensajeCliente",mensajeCliente);
		MV.addObject("clienteObtenido",cliente);
		MV.setViewName("AltaDeCuenta");
		return MV;
	}
	
	
	@RequestMapping("agregarCuenta.html")
	public ModelAndView eventoRedireccionarPag2( String txtTipoCuenta,String txtCBU ,String txtNumCuenta, String txtAlias , String txtIdCliente,String txtDni ,String txtNombre ,String txtApellido)
	{
		int idCliente , cbu, numCuenta,dni;
		ModelAndView MV = new ModelAndView();
		
		cbu = Integer.parseInt(txtCBU);
		numCuenta = Integer.parseInt(txtNumCuenta);
		idCliente = Integer.valueOf(txtIdCliente);  
		
		cuenta.setCbu(cbu);
		cuenta.setTipoCuenta(txtTipoCuenta);
		cuenta.setAlias(txtAlias);
		cuenta.setNroCuenta(numCuenta);
		
		cliente = new Cliente();
		
		cliente.setIdCliente(idCliente);
		dni = Integer.parseInt(txtDni);  
		cliente.setDni(dni);
		cliente.setNombre(txtNombre);
		cliente.setApellido(txtApellido);
		
		cuenta.setCliente(cliente);
		
		boolean estado= negocioCuenta.agregarCuenta(cuenta);
		
		cartel="No se pudo agregar la cuenta";
		if(estado)
		{
			cartel="La cuenta ha sido agregada exitosamente";
		}
		MV.addObject("estadoAgregarCuenta",cartel);
		MV.setViewName("AltaDeCuenta");
		return MV;
		
	}
	@RequestMapping(value ="/recargaGrillaCuentas.html" , method= { RequestMethod.GET, RequestMethod.POST})
	//@RequestMapping("recargaGrillaCuentas.html")
	public ModelAndView eventoRedireccionarpage12( String txtTipoCuenta,String txtCBU ,String txtNumCuenta, String txtAlias )
	{
		
		ModelAndView MV = new ModelAndView();
		
		ArrayList<Cuenta> listaCuenta = new ArrayList<>();
		
		listaCuenta = (ArrayList<Cuenta>) negocioCuenta.listarCuentas();
		
		MV.addObject("listaCuentas",listaCuenta);
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
	@RequestMapping(value ="/ModificarCuenta.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modificar(int numeroCuenta, int cbu, String alias, String tipoCuenta)
	{
		Cuenta Cuenta = new Cuenta();
		Cuenta.setAlias(alias);
		Cuenta.setCbu(cbu);
		Cuenta.setNroCuenta(numeroCuenta);
		Cuenta.setTipoCuenta(tipoCuenta);
		
		
		ModelAndView MV = new ModelAndView();
		MV.addObject("CuentaModificar", Cuenta);
		MV.setViewName("AltaDeCuenta");
		return MV;	
		
}
	@RequestMapping(value ="/ModificarCuenta_AltaDecuenta.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modificarDesdeAlta(int numeroCuenta, int cbu, String alias, String tipoCuenta)
	{
		Cuenta Cuenta = new Cuenta();
		Cuenta.setAlias(alias);
		Cuenta.setCbu(cbu);
		Cuenta.setNroCuenta(numeroCuenta);
		Cuenta.setTipoCuenta(tipoCuenta);
		
		boolean estado= negocioCuenta.update(cuenta);
		String mesajeActualizacion = "Cuenta Modificada correctamente";
		if(!estado)
		{
			mesajeActualizacion = "No se pudo actualizar la cuenta";
		}
		ModelAndView MV = new ModelAndView();
		MV.addObject("mesajeActualizacion", mesajeActualizacion);
		MV.setViewName("AltaDeCuenta");
		return MV;	
		
}
	@RequestMapping("RedireccionAltaDeCuenta.html")
	public ModelAndView AltaDeCuentaRedireccion()
	{
 		ModelAndView MV = new ModelAndView();
		
		MV.setViewName("AltaDeCuenta");
		return MV;	
	}
	
}
