package frgp.utn.edu.ar.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Cuenta;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.entidad.UsuarioLogin;
import frgp.utn.edu.ar.negocio.NegPersona;

@Controller
public class ControladorCliente {

	@Autowired
	@Qualifier("servicioPersona")
	private NegPersona negocioPersona;
	@Autowired
	private Persona persona;

	@RequestMapping("agregarCliente.html")
	public ModelAndView eventoRedireccionarPag1(String txtEmail, Integer txtDNI, String txtNombre, String txtApellido,
			String btnCrear) {
		ModelAndView MV = new ModelAndView();
		persona.setApellido(txtApellido);
		persona.setDni(txtDNI);
		persona.setNombre(txtNombre);
		persona.setEmail(txtEmail);
		
		UsuarioLogin usuario = new UsuarioLogin();
		usuario.setPassword(txtDNI.toString());
		usuario.setUsuario(txtDNI.toString());
		usuario.setDni(txtDNI);
		persona.setUsuario(usuario);
		boolean agregarModificar = false;

		try {
			if (btnCrear != null) {
				agregarModificar = negocioPersona.agregarPersona(persona);
			} else {
				agregarModificar = negocioPersona.editarPersona(persona);
			}
			MV.addObject("agregadoExitoso", agregarModificar);
			MV.addObject("esBotonCrear", btnCrear);
			MV.setViewName("AltaUsuarios");
		} catch (Exception e) {
			MV.setViewName("AltaUsuarios");
			return MV;
		}
		return MV;
	}
	
	@RequestMapping("agregarPersona.html")
	public ModelAndView eventoRedireccionarPag1(Integer txtDni,String txtNombre, String txtApellido)
	{
		ModelAndView MV = new ModelAndView();
		persona.setApellido(txtApellido);
		persona.setDni(txtDni);
		persona.setNombre(txtNombre);
		
		boolean estado= negocioPersona.agregarPersona(persona);
		String cartel="No se pudo agregar la persona";
		if(estado)
		{
			cartel="La persona ha sido agregada exitosamente";
		}
		MV.addObject("estadoAgregarPersona",cartel);
		MV.setViewName("Inicio");
		return MV;
	}
	
	@RequestMapping("abmlClientes.html")
	public ModelAndView eventoRedireccionarPag1()
	{
		ModelAndView MV = new ModelAndView();

		ArrayList<Persona> listaPersona = new ArrayList<>();
		
		listaPersona = (ArrayList<Persona>) negocioPersona.listarPersonasBajaLogica();
		
		MV.addObject("listaPersona",listaPersona);
		MV.setViewName("ABMLClientes");
		return MV;

	}
	
	
	@RequestMapping("eliminacion.html")
	public ModelAndView eliminar(Integer dni)
	{
		negocioPersona.bajaLogica(dni);	
		negocioPersona.bajaLogicabajaLogicaUsuarioLogin(dni);
		ArrayList<Integer> listaCuenta = (ArrayList<Integer>) negocioPersona.obtenerCuentaxCliente(dni);
		for (Integer cbu : listaCuenta) {
			negocioPersona.bajaLogicaCuenta(cbu);
		}

		ModelAndView MV = new ModelAndView();

		ArrayList<Persona> listaPersona = new ArrayList<>();
		
		listaPersona = (ArrayList<Persona>) negocioPersona.listarPersonasBajaLogica();
		
		MV.addObject("listaPersona",listaPersona);
		MV.setViewName("ABMLClientes");
		return MV;	
		
}
	@RequestMapping("ModificarCliente.html")
	public ModelAndView modificar(int dni, String nombre, String apellido, String email)
	{
		Persona persona = new Persona();
		persona.setApellido(apellido);
		persona.setDni(dni);
		persona.setNombre(nombre);
		persona.setEmail(email);
		ArrayList<Persona> listaPersona = new ArrayList<>();
		listaPersona.add(persona);
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaPersona", listaPersona);
		MV.setViewName("AltaUsuarios");
		return MV;		
}
	
	
}
