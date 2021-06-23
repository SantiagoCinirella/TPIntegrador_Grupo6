package frgp.utn.edu.ar.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Component
@Entity
public class Cuenta {
	
	@Id
	private String CBU;
	private String NroCuenta;
	private String TipoCuenta;
	private String Alias;
	
	public String getCBU() {
		return CBU;
	}
	public void setCBU(String txtCBU) {
		CBU = txtCBU;
	}
	public String getNroCuenta() {
		return NroCuenta;
	}
	public void setNroCuenta(String nroCuenta) {
		NroCuenta = nroCuenta;
	}
	public String getTipoCuenta() {
		return TipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}
	public String getAlias() {
		return Alias;
	}
	public void setAlias(String alias) {
		Alias = alias;
	}
	@Override
	public String toString() {
		return "Cuenta [CBU=" + CBU + ", NroCuenta=" + NroCuenta + ", TipoCuenta=" + TipoCuenta + ", Alias=" + Alias
				+ "]";
	}
	
}
