package frgp.utn.edu.ar.entidad.enumMensajes;

public enum enumMensajes {

	ALTA_EXITOSA("Cliente agregado exitosamente", 1),
	MODIFICACION_EXITOSA("Cliente modificado exitosamente", 2),
	DNI_EXISTENTE("El dni ya se encuentra en el sistema", 3),
	SELECCIONAR_CUENTA("Seleccione una cuenta valida", 4),
	CBU_INCORRECTO("CBU incorrecto", 5),
	SALDO_INSUFICIENTE("Saldo insuficiente", 6),
	TRANSFERIR_MISMA_CUENTA("No es posible transferir a la misma cuenta", 7),
	TRANSFERENCIA_EXITOSA("Se ha transferido exitosamente", 8)
	;

	private String mensaje;
	private int numeroMensaje;

	enumMensajes(String mensaje, int numeroMensaje) {
		this.setMensaje(mensaje);
		this.setNumeroMensaje(numeroMensaje);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getNumeroMensaje() {
		return numeroMensaje;
	}

	public void setNumeroMensaje(int numeroMensaje) {
		this.numeroMensaje = numeroMensaje;
	}

}
