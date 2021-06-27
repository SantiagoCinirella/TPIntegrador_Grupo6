package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.queries.CuentaQueries;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Movimiento;

@Repository("daoMovimiento")
public class DaoMovimiento {

	@Autowired
	private Conexion conexion = new Conexion();

	public Boolean agregarMovimiento(Movimiento mov) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
