package frgp.utn.edu.ar.entidad.enumMensajes;

public enum enumMensajes {

	ALTA_EXITOSA("Cliente agregado exitosamente", 1),
	MODIFICACION_EXITOSA("Cliente modificado exitosamente", 2),
	DNI_EXISTENTE("El dni ya se encuentra en el sistema", 3),
	SELECCIONAR_CUENTA("Seleccione una cuenta valida", 4),
	CBU_INCORRECTO("CBU incorrecto", 5),
	SALDO_INSUFICIENTE("Saldo insuficiente", 6),
	TRANSFERIR_MISMA_CUENTA("No es posible transferir a la misma cuenta", 7),
	TRANSFERENCIA_EXITOSA("Se ha transferido exitosamente", 8),
	CUENTA_AGREGADA_EXITOSAMENTE("La cuenta ha sido agregada correctamente",9),
	DEBE_SELECCIONAR_TIPOCUENTA("Se debe seleccionar un tipo de cuenta",10),
	ERROR_CANTIDAD_CUENTA("El cliente no puede tener mas de 4 cuentas",11),
	ERROR_CUENTA_NO_AGREGADA("La cuneta no se ha podido agregar",12),
	USUARIO_NO_EXISTE("El usuario no existe o está dado de baja",13),
	CUENTA_MODIFICADA_EXITOSAMENTE("La cuenta ha sido actualizada exitosamente",14),
	ERROR_ACTUALIZAR_CUENTA("No se pudo actualizar la cuenta",15),
	CLIENTE_SIN_CUENTA("Necesita tener una cuenta para transferir", 16),
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
