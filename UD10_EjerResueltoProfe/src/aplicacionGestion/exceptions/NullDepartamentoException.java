package aplicacionGestion.exceptions;

public class NullDepartamentoException extends Exception{
	public String mensaje;

	public NullDepartamentoException(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
