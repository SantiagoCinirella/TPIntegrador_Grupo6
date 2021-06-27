package frgp.utn.edu.ar.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.DaoMovimiento;
import frgp.utn.edu.ar.dao.DaoPersona;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;
import frgp.utn.edu.ar.entidad.Persona;

@Service("servicioMovimiento")
public class NegMovimiento {

	@Autowired
	private DaoMovimiento daoMovimiento = new DaoMovimiento();
	

	public Boolean agregarMovimiento(Movimiento mov) {
		return daoMovimiento.agregarMovimiento(mov);
	}

}
