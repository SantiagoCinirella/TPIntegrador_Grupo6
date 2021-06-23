package frgp.utn.edu.ar.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.DaoPersona;
import frgp.utn.edu.ar.entidad.Persona;

@Service("servicioPersona")
public class NegPersona {

	@Autowired
	private DaoPersona daoPersona;
	
	public List<Persona> listarPersonas() {
		return daoPersona.listarPersonas();
	}

	public boolean agregarPersona(Persona p) {
		return daoPersona.agregarPersona(p);
	}

}
