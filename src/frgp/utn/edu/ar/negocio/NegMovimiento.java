package frgp.utn.edu.ar.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.DaoMovimiento;
import frgp.utn.edu.ar.entidad.Movimiento;
import frgp.utn.edu.ar.negocio.interfaceNegocio.interfaceMovimiento;

@Service("servicioMovimiento")
public class NegMovimiento implements interfaceMovimiento {

	@Autowired
	private DaoMovimiento daoMovimiento = new DaoMovimiento();

	@Override
	public Boolean agregarMovimiento(Movimiento mov) {
		return daoMovimiento.agregarMovimiento(mov);
	}

}
