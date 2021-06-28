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
public class ControladorMovimiento {

	@Autowired
	@Qualifier("servicioMovimiento")
	private NegMovimiento negocioMovimiento;

	@RequestMapping(value = "buscarSaldo.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView eventoRedireccionar(int cuentas, int CBU, int SaldoTransferir, HttpServletRequest request,
			HttpServletResponse response) {
		if (cuentas != 0) {
			NegPersona negocioPersona = new NegPersona();
			Cuenta CuentaDestino = negocioPersona.obtenerCuentaxCbu(CBU);
			if (CuentaDestino != null) {
				
				Persona personaDestino = negocioPersona.obtenerPersona(CuentaDestino.getDni());
				NegCuenta negocioCuenta = new NegCuenta();
				Cuenta cuenta = negocioCuenta.buscarSaldo(cuentas);

				HttpSession misession = (HttpSession) request.getSession();
				Persona Persona = (Persona) misession.getAttribute("Usuario");
				ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());

				ModelAndView MV = new ModelAndView();
				MV.addObject("listaCuenta", listaCuenta);
				MV.addObject("cuenta", cuenta);
				MV.addObject("personaDestino", personaDestino);
				MV.addObject("CuentaDestino", CuentaDestino);
				MV.addObject("SaldoTransferir", SaldoTransferir);
				MV.setViewName("Transferencia");
				return MV;

			} 
			else {
				HttpSession misession = (HttpSession) request.getSession();
				Persona Persona = (Persona) misession.getAttribute("Usuario");
				ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());

				ModelAndView MV = new ModelAndView();
				MV.addObject("listaCuenta", listaCuenta);
				MV.setViewName("Transferencia");
				MV.addObject("mensaje", enumMensajes.CBU_INCORRECTO);
				return MV;
			}

		} else {
			HttpSession misession = (HttpSession) request.getSession();
			Persona Persona = (Persona) misession.getAttribute("Usuario");
			NegPersona negocioPersona = new NegPersona();
			ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());
			ModelAndView MV = new ModelAndView();
			MV.addObject("listaCuenta", listaCuenta);
			MV.setViewName("Transferencia");
			MV.addObject("mensaje", enumMensajes.SELECCIONAR_CUENTA);
			return MV;
		}

	}
	
	@RequestMapping(value = "TransferirDinero.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView Transferir(int CBU, int CBUOrigen , int SaldoTransferir , HttpServletRequest request,
			HttpServletResponse response) {
		NegPersona negocioPersona = new NegPersona();
		Cuenta CuentaOrigen = negocioPersona.obtenerCuentaxCbu(CBUOrigen);

		if (CuentaOrigen.getSaldo() != 0 && CuentaOrigen.getSaldo() >= SaldoTransferir ) {
			
			if(CBU == CBUOrigen)
			{
				HttpSession misession = (HttpSession) request.getSession();
				Persona Persona = (Persona) misession.getAttribute("Usuario");
				ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());

				ModelAndView MV = new ModelAndView();
				MV.addObject("listaCuenta", listaCuenta);
				MV.setViewName("Transferencia");
				MV.addObject("mensaje", enumMensajes.TRANSFERIR_MISMA_CUENTA);
				return MV;
			}
			else
			{
				double SaldoParaMovimiento = SaldoTransferir;
				Cuenta CuentaDestino = negocioPersona.obtenerCuentaxCbu(CBU);
				double SaldoCuentaDestino = CuentaDestino.getSaldo();
				SaldoCuentaDestino += SaldoTransferir;
				CuentaDestino.setSaldo(SaldoCuentaDestino);
				NegCuenta negocioCuenta = new NegCuenta();
				negocioCuenta.actualizarSaldo(CuentaDestino);
				
				double SaldoCuentaOrigen = CuentaOrigen.getSaldo();
				SaldoCuentaOrigen = SaldoCuentaOrigen - SaldoTransferir;
				CuentaOrigen.setSaldo(SaldoCuentaOrigen);
				negocioCuenta.actualizarSaldo(CuentaOrigen);
				
				NegMovimiento negocioMovimiento = new NegMovimiento();
				Movimiento Movimiento = new Movimiento();
				Movimiento.setCbuOrigen(CuentaOrigen.getCbu());
				Movimiento.setCbuDestino(CuentaDestino.getCbu());
				Movimiento.setDetalle("porro");
				Movimiento.setSaldo(-SaldoParaMovimiento);
				Movimiento.setFecha(LocalDateTime.now().toString());
				negocioMovimiento.agregarMovimiento(Movimiento);
				
				Movimiento = new Movimiento();
				Movimiento.setCbuOrigen(CuentaDestino.getCbu());
				Movimiento.setCbuDestino(CuentaOrigen.getCbu());
				Movimiento.setDetalle("porro");
				Movimiento.setSaldo(SaldoParaMovimiento);
				Movimiento.setFecha(LocalDateTime.now().toString());
				negocioMovimiento.agregarMovimiento(Movimiento);

				
				HttpSession misession = (HttpSession) request.getSession();
				Persona Persona = (Persona) misession.getAttribute("Usuario");
				ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());
				
				ModelAndView MV = new ModelAndView();
				MV.addObject("listaCuenta", listaCuenta);
				MV.setViewName("Transferencia");
				MV.addObject("mensaje", enumMensajes.TRANSFERENCIA_EXITOSA);
				return MV;
				
				}

		} 
		else
		{
			HttpSession misession = (HttpSession) request.getSession();
			Persona Persona = (Persona) misession.getAttribute("Usuario");
			ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) negocioPersona.obtenerCuenta(Persona.getDni());

			ModelAndView MV = new ModelAndView();
			MV.addObject("listaCuenta", listaCuenta);
			MV.setViewName("Transferencia");
			MV.addObject("mensaje", enumMensajes.SALDO_INSUFICIENTE);
			return MV;
		}

	}

}
