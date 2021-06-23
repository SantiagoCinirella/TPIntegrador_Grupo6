package frgp.utn.edu.ar.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.DaoCuenta;
import frgp.utn.edu.ar.entidad.Cuenta;

@Service("servicioCuenta")
public class NegCuenta {

	@Autowired
	private DaoCuenta daoCuenta;
	
	public List<Cuenta> listarCuentas() {
		return daoCuenta.listarCuentas();
	}

	public boolean agregarCuenta(Cuenta p) {
		return daoCuenta.agregarCuenta(p);
	}

}
