package frgp.utn.edu.ar.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.entidad.enumMensajes.enumMensajes;
import frgp.utn.edu.ar.negocio.NegCuenta;
import frgp.utn.edu.ar.negocio.NegMovimiento;
import frgp.utn.edu.ar.negocio.NegPersona;

@Controller
public class ControladorCuenta {

	@Autowired
	@Qualifier("servicioCuenta")
	private NegCuenta negocioCuenta;
	private NegPersona negocioPersona;
	private NegMovimiento negocioMovimiento;
	@Autowired
	private Cuenta cuenta;
	private Persona persona;

	@RequestMapping(value = "/buscarCliente.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView eventoRedireccionar(String txtDni) {
		ModelAndView MV = new ModelAndView();
		int dni, cbu, nroCuenta, maxCuenta, maxCbu;

		dni = Integer.parseInt(txtDni);
		negocioPersona = new NegPersona();
		persona = (Persona) negocioPersona.obtenerPersona(dni);

		if (persona == null) {
			MV.addObject("MensajeBack", enumMensajes.USUARIO_NO_EXISTE);

		} else {

			maxCuenta = negocioCuenta.obtenerCuentaMax();
			maxCbu = negocioCuenta.obtenerCbuMax();

			cbu = maxCbu + 1;
			nroCuenta = maxCuenta + 1;
			cuenta.setCbu(cbu);
			cuenta.setNroCuenta(nroCuenta);

		}

		MV.addObject("CuentaParcial", cuenta);
		MV.addObject("clienteObtenido", persona);
		MV.setViewName("AltaDeCuenta");
		return MV;
	}

	@RequestMapping(value = "/agregarCuenta.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView eventoRedireccionarPag2(String tipoCuenta, String cbu, String numeroCuenta, String alias,
			int txtDni, String txtNombre, String txtApellido) {

		int idCliente, cbuint, numCuentaint, dniInt;
		ModelAndView MV = new ModelAndView();

		cbuint = Integer.parseInt(cbu);
		numCuentaint = Integer.parseInt(numeroCuenta);

		int cantidadCuentas;
		cuenta.setCbu(cbuint);
		cuenta.setTipoCuenta(tipoCuenta);
		cuenta.setAlias(alias);
		cuenta.setNroCuenta(numCuentaint);
		cuenta.setDni(txtDni);

		cuenta.setSaldo(10000.00);
		cuenta.setFechaCreacion(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));

		Persona persona = (Persona) negocioPersona.obtenerPersona(txtDni);
		if (!tipoCuenta.equals("Seleccione un tipo de Cuenta")) {

			cantidadCuentas = negocioCuenta.getCantidadCuentas(cuenta.getDni());
			if (cantidadCuentas < 4) {

				MV.addObject("MensajeBack", enumMensajes.ERROR_CUENTA_NO_AGREGADA);

				if (negocioCuenta.agregarCuenta(cuenta)) {
					MV.addObject("MensajeBack", enumMensajes.CUENTA_AGREGADA_EXITOSAMENTE);

					negocioMovimiento = new NegMovimiento();
					Movimiento movimiento = new Movimiento();
					movimiento.setCbuOrigen(cuenta.getCbu());
					movimiento.setCbuDestino(cuenta.getCbu());
					movimiento.setDetalle("Saldo Inicial");
					movimiento.setFecha(LocalDateTime.now().toString().replace("T", " ").substring(0, 16));
					movimiento.setSaldo(10000.00);
					cuenta.setNroCuenta(negocioCuenta.obtenerCuentaMax()+1);
					cuenta.setCbu(negocioCuenta.obtenerCbuMax()+1);

				}
			} else {
				MV.addObject("MensajeBack", enumMensajes.ERROR_CANTIDAD_CUENTA);

			}
		} else {
			MV.addObject("MensajeBack", enumMensajes.DEBE_SELECCIONAR_TIPOCUENTA);

		}
		MV.addObject("CuentaParcial", cuenta);
		MV.addObject("clienteObtenido", persona);
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
	public ModelAndView eventoRedireccionarPagCliente(int Usuario) {

		ModelAndView MV = new ModelAndView();
		negocioPersona = new NegPersona();
		ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Usuario);
		MV.addObject("listaCuenta", listaCuenta);
		MV.setViewName("Cliente");
		return MV;

	}

	@RequestMapping("Transferencia.html")
	public ModelAndView eventoRedireccionarTransferencia(HttpServletRequest request, HttpServletResponse response) {
		HttpSession misession = (HttpSession) request.getSession();
		Persona Persona = (Persona) misession.getAttribute("Usuario");
		negocioPersona = new NegPersona();
		ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());
		ModelAndView MV = new ModelAndView();
		if (listaCuenta.isEmpty()) {
			MV.addObject("mensaje", enumMensajes.CLIENTE_SIN_CUENTA);
			MV.setViewName("Cliente");
		} else {
			MV.setViewName("Transferencia");
			MV.addObject("listaCuenta", listaCuenta);
		}
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
	public ModelAndView movimientos(int cbu) {
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

		ModelAndView MV = new ModelAndView();
		Cuenta Cuenta = new Cuenta();
		Cuenta.setAlias(alias);
		Cuenta.setCbu(cbu);
		Cuenta.setNroCuenta(numeroCuenta);
		Cuenta.setTipoCuenta(tipoCuenta);

		boolean estado = negocioCuenta.update(Cuenta);
		MV.addObject("MensajeBack", enumMensajes.CUENTA_MODIFICADA_EXITOSAMENTE);

		if (!estado) {
			MV.addObject("MensajeBack", enumMensajes.ERROR_ACTUALIZAR_CUENTA);
		}

		MV.addObject("CuentaModificar", Cuenta);
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
