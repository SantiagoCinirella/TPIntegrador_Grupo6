package frgp.utn.edu.ar.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.entidad.UsuarioLogin;

public class mainApp {

	public static void main(String[] args) {

		System.out.println("Comienzo");

		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
		UsuarioLogin usuarioLogin = (UsuarioLogin) appContext.getBean("LoginNegocio");
		((ConfigurableApplicationContext)(appContext)).close();
		
		System.out.println("Fin");
	}
}
