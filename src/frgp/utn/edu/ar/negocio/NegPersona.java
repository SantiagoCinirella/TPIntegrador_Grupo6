package frgp.utn.edu.ar.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.DaoPersona;
import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Persona;

@Service("servicioPersona")
public class NegPersona {

	@Autowired
	private DaoPersona daoPersona = new DaoPersona();

	public List<Persona> listarPersonas() {
		return daoPersona.listarPersonas();
	}

	public boolean agregarPersona(Persona p) {
		return daoPersona.agregarPersona(p);
	}

	public boolean editarPersona(Persona persona) {
		return daoPersona.editarPersona(persona);

	}

	public List<Persona> listarPersonasBajaLogica() {
		return daoPersona.listarPersonasBajaLogica();
	}

	public boolean eliminarPersona(int dni) {
		return daoPersona.eliminarUsuario(dni);

	}

	public boolean bajaLogica(int dni) {
		return daoPersona.bajaLogica(dni);

	}

	public boolean bajaLogicaCuenta(int dni) {
		return daoPersona.bajaLogicaCuenta(dni);

	}

	public boolean bajaLogicabajaLogicaUsuarioLogin(int dni) {
		return daoPersona.bajaLogicaUsuarioLogin(dni);

	}

	public Persona obtenerPersona(int dni) {

		return daoPersona.obtenerPersona(dni);
	}
	
	public Persona obtenerPersonaParaLogin(int dni) {

		return daoPersona.obtenerPersonaParaLogin(dni);
	}

	public List<Integer> obtenerCuentaxCliente(int dni) {

		return daoPersona.obtenerCuentaxCliente(dni);
	}

	public List<Cuenta> obtenerCuenta(int dni) {

		return daoPersona.obtenerCuenta(dni);
	}
	
	public Cuenta obtenerCuentaxCbu(int cbu) {

		return daoPersona.obtenerCuentaxCbu(cbu);
	}

	public boolean verificarDniExistente(Integer dni) throws Exception {
		return daoPersona.verificarDniExistente(dni);
	}
}
