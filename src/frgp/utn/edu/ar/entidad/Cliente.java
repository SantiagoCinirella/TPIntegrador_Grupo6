package frgp.utn.edu.ar.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Cliente {
	
	@Id
	private int IDCliente;
	private int DNI;
	private String Nombre;
	private String Apellido;
	public int getIDCliente() {
		return IDCliente;
	}
	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	@Override
	public String toString() {
		return "Cliente [IDCliente=" + IDCliente + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido=" + Apellido
				+ "]";
	}
	
	

}
