package frgp.utn.edu.ar.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.DaoCliente;
import frgp.utn.edu.ar.dao.DaoCuenta;
import frgp.utn.edu.ar.dao.DaoPersona;
import frgp.utn.edu.ar.entidad.Cliente;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Persona;

@Service("servicioCliente")
public class NegCliente {

	@Autowired
	private DaoCliente daoCliente = new DaoCliente();
	
	public List<Cliente> listarClientes() {
		return daoCliente.listarClientes();
	}

	public Cliente obtenerCliente(int dni) {
		
		return daoCliente.obtenerCliente(dni);
	}

	

}