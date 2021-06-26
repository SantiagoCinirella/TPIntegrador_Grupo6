package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;


@Component
@Entity
public class Cuenta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int cbu;
	private int nroCuenta;
	private String tipoCuenta;
	private String alias;
	private boolean estado;
	private String fechaCreacion;
	private Double saldo;
	

	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn (name="dni")
	private Persona persona;
	
	
	public Cuenta()
	{
	}

	
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public int getCbu() {
		return cbu;
	}


	public void setCbu(int cbu) {
		this.cbu = cbu;
	}


	public int getNroCuenta() {
		return nroCuenta;
	}


	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}


	public String getTipoCuenta() {
		return tipoCuenta;
	}


	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
