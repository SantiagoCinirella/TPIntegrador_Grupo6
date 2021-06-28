package frgp.utn.edu.ar.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.DaoCuenta;
import frgp.utn.edu.ar.dao.DaoPersona;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;
import frgp.utn.edu.ar.entidad.Persona;

@Service("servicioCuenta")
public class NegCuenta {

	@Autowired
	private DaoCuenta daoCuenta = new DaoCuenta();
	
	
	public List<Cuenta> listarCuentas() {
		return daoCuenta.listarCuentas();
	}

	public List<Cuenta> listarCuentasBajaLogica() {
		return daoCuenta.listarCuentasBajaLogica();
	}

	public Cuenta buscarSaldo(int cbu) {
		return daoCuenta.buscarSaldo(cbu);
	}
	
	public List<Movimiento> listarMovimientos(int cbu) {
		return daoCuenta.listarMovimientos(cbu);
	}
	
	public boolean agregarCuenta(Cuenta p) {
		return daoCuenta.agregarCuenta(p);
	}

	public boolean eliminarCuenta(int numeroCuenta) {
		return daoCuenta.eliminarCuenta(numeroCuenta);
		
	}
	
	public boolean bajaLogica(int numeroCuenta) {
		return daoCuenta.bajaLogica(numeroCuenta);
		
	}

	public boolean update(Cuenta cuenta) {
		return daoCuenta.update(cuenta);
	}
	
	public boolean actualizarSaldo(Cuenta cuenta) {
		return daoCuenta.actualizarSaldo(cuenta);
	}

	public int obtenerCuentaMax() {
		return daoCuenta.obtenerCuentaMax();
	}
	
	public int obtenerCbuMax() {
		return daoCuenta.obtenerCbuMax();
	}

	public int getCantidadCuentas(int dni) {
		return daoCuenta.getCantidadCuentas(dni);
	}

}
