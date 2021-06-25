package frgp.utn.edu.ar.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Component
@Entity
public class Cuenta {
	
	@Id	
	private int cbu;
	private int nroCuenta;
	private String tipoCuenta;
	private String alias;
	private boolean estado;
	
	
	public Cuenta()
	{
		
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
