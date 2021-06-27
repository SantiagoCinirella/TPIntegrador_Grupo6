package frgp.utn.edu.ar.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.negocio.NegCuenta;
import frgp.utn.edu.ar.negocio.NegPersona;

@Controller
public class ControladorCuenta {

	@Autowired
	@Qualifier("servicioCuenta")
	private NegCuenta negocioCuenta;
	private NegPersona negocioPersona;
	@Autowired
	private Cuenta cuenta;
	private Persona persona;
	String cartel = null;

	@RequestMapping(value = "/buscarCliente.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView eventoRedireccionar(String txtDni) {
		ModelAndView MV = new ModelAndView();
		String mensajeCliente = null;
		int dni, cbu, nroCuenta, maxCuenta, maxCbu;

		dni = Integer.parseInt(txtDni);
		negocioPersona = new NegPersona();
		persona = (Persona) negocioPersona.obtenerPersona(dni);

		if (persona == null) {
			mensajeCliente = "El usuario no existe o esta dado de baja";

		} else {

			maxCuenta = negocioCuenta.obtenerCuentaMax();
			maxCbu = negocioCuenta.obtenerCbuMax();

			if (maxCuenta == 0 && maxCbu == 0) {
				cuenta = new Cuenta();
				cbu = 1000000;
				nroCuenta = 5000000;
				cuenta.setCbu(cbu);
				cuenta.setNroCuenta(nroCuenta);
			} else {
				cbu = maxCbu + 1;
				nroCuenta = maxCuenta + 1;
				cuenta.setCbu(cbu);
				cuenta.setNroCuenta(nroCuenta);
			}

		}

		MV.addObject("CuentaParcial", cuenta);
		MV.addObject("mensajeCliente", mensajeCliente);
		MV.addObject("clienteObtenido", persona);
		MV.setViewName("AltaDeCuenta");
		return MV;
	}

	@RequestMapping(value ="/agregarCuenta.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView eventoRedireccionarPag2( String tipoCuenta,String cbu ,String numeroCuenta, String alias , String txtDni ,String txtNombre ,String txtApellido)
	{
		int idCliente , cbuint, numCuentaint,dniInt;
		ModelAndView MV = new ModelAndView();
		
		if(tipoCuenta !=  "" && cbu !=  "" &&  numeroCuenta  !=  "" &&  alias   !=  "" && txtDni    !=  "" && txtNombre   !=  "" && txtApellido  !=  "" )
		{
			
			cbuint = Integer.parseInt(cbu);
			numCuentaint = Integer.parseInt(numeroCuenta);
			dniInt = Integer.parseInt(txtDni);
			boolean estado;
			int cantidadCuentas;
			cuenta.setCbu(cbuint);
			cuenta.setTipoCuenta(tipoCuenta);
			cuenta.setAlias(alias);
			cuenta.setNroCuenta(numCuentaint);
			cuenta.setDni(dniInt);
			persona = new Persona();
			
			persona.setDni(dniInt);
			persona.setNombre(txtNombre);
			persona.setApellido(txtApellido);
		
			cuenta.setPersona(persona);
			cuenta.setSaldo(10000.00);
			cuenta.setFechaCreacion(LocalDateTime.now().toString() );
			
			cantidadCuentas = negocioCuenta.getCantidadCuentas(cuenta.getDni());
			if(cantidadCuentas < 4 )
				{
				estado = negocioCuenta.agregarCuenta(cuenta);
				
				cartel="No se pudo agregar la cuenta";
				if(estado)
				{
					cartel="La cuenta ha sido agregada exitosamente";					
				}
			}
			else
			{
				cartel="El cliente no puede tener mas de 4 cuentas";
			}
			
		}
		else 
		{
			cartel="Debe completar todos los campos";
		}
		MV.addObject("estadoAgregarCuenta",cartel);
		MV.setViewName("AltaDeCuenta");
		return MV;
		
		
	}

	@RequestMapping(value = "/recargaGrillaCuentas.html", method = { RequestMethod.GET, RequestMethod.POST })
	// @RequestMapping("recargaGrillaCuentas.html")
	public ModelAndView eventoRedireccionarpage12(String txtTipoCuenta, String txtCBU, String txtNumCuenta,
			String txtAlias) {

		ModelAndView MV = new ModelAndView();

		ArrayList<Cuenta> listaCuenta = new ArrayList<>();

		listaCuenta = (ArrayList<Cuenta>) negocioCuenta.listarCuentas();

		MV.addObject("listaCuentas", listaCuenta);
		MV.setViewName("AltaDeCuenta");
		return MV;
	}

	@RequestMapping("homeCliente.html")
	public ModelAndView eventoRedireccionarPagCliente(int Usuario)
	{

		ModelAndView MV = new ModelAndView();
		negocioPersona = new NegPersona();
		ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Usuario);
		MV.addObject("listaCuenta", listaCuenta);
		MV.setViewName("Cliente");
		return MV;

	}
	
	@RequestMapping("Transferencia.html")
	public ModelAndView eventoRedireccionarTransferencia()
	{

		ModelAndView MV = new ModelAndView();
		MV.setViewName("Transferencia");
		return MV;

	}
	
	@RequestMapping("abmlCuentas.html")
	public ModelAndView eventoRedireccionarPag1() {
		NegCuenta negocioCuenta = new NegCuenta();
		ModelAndView MV = new ModelAndView();

		ArrayList<Cuenta> listaPersona = new ArrayList<>();

		listaPersona = (ArrayList<Cuenta>) negocioCuenta.listarCuentasBajaLogica();

		MV.addObject("listaPersona", listaPersona);
		MV.setViewName("ABMLCuentas");
		return MV;

	}

	@RequestMapping("Movimientos.html")
	public ModelAndView movimientos(int cbu)
	{
		NegCuenta negocioCuenta = new NegCuenta();
		ModelAndView MV = new ModelAndView();
		
		ArrayList<Movimiento> listaMovimientos = new ArrayList<>();
		
		listaMovimientos = (ArrayList<Movimiento>) negocioCuenta.listarMovimientos(cbu);
		
		MV.addObject("listaMovimientos", listaMovimientos);
		MV.setViewName("HistorialDeMovimientos");
		return MV;

	}
	
	@RequestMapping("eliminacionCuenta.html")
	public ModelAndView eliminar(int numeroCuenta) {
		negocioCuenta.bajaLogica(numeroCuenta);
		ModelAndView MV = new ModelAndView();

		ArrayList<Cuenta> listaPersona = new ArrayList<>();

		listaPersona = (ArrayList<Cuenta>) negocioCuenta.listarCuentasBajaLogica();

		MV.addObject("listaPersona", listaPersona);
		MV.setViewName("ABMLCuentas");
		return MV;

	}

	@RequestMapping(value = "/ModificarCuenta.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView modificar(int numeroCuenta, int cbu, String alias, String tipoCuenta) {
		Cuenta Cuenta = new Cuenta();
		Cuenta.setAlias(alias);
		Cuenta.setCbu(cbu);
		Cuenta.setNroCuenta(numeroCuenta);
		Cuenta.setTipoCuenta(tipoCuenta);

		ModelAndView MV = new ModelAndView();
		MV.addObject("CuentaModificar", Cuenta);
		MV.setViewName("ModificacionDeCuenta");
		return MV;

	}

	@RequestMapping("ModificarCuenta_AltaDecuenta.html")
	public ModelAndView modificarDesdeAlta(int numeroCuenta, int cbu, String alias, String tipoCuenta) {
		Cuenta Cuenta = new Cuenta();
		Cuenta.setAlias(alias);
		Cuenta.setCbu(cbu);
		Cuenta.setNroCuenta(numeroCuenta);
		Cuenta.setTipoCuenta(tipoCuenta);

		boolean estado = negocioCuenta.update(Cuenta);
		String mesajeActualizacion = "Cuenta Modificada correctamente";
		if (!estado) {
			mesajeActualizacion = "No se pudo actualizar la cuenta";
		}

		ModelAndView MV = new ModelAndView();
		MV.addObject("mesajeActualizacion", mesajeActualizacion);
		MV.setViewName("ModificacionDeCuenta");
		return MV;

	}

	@RequestMapping("RedireccionAltaDeCuenta.html")
	public ModelAndView AltaDeCuentaRedireccion() {
		ModelAndView MV = new ModelAndView();

		MV.setViewName("AltaDeCuenta");
		return MV;
	}
}
