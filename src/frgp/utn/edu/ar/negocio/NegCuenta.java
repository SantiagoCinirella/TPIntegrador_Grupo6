package frgp.utn.edu.ar.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.DaoCuenta;
import frgp.utn.edu.ar.entidad.Cuenta;

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

	
	public boolean agregarCuenta(Cuenta p) {
		return daoCuenta.agregarCuenta(p);
	}

	public boolean eliminarCuenta(int numeroCuenta) {
		return daoCuenta.eliminarCuenta(numeroCuenta);
		
	}
	
	public boolean bajaLogica(int numeroCuenta) {
		return daoCuenta.bajaLogica(numeroCuenta);
		
	}

}
