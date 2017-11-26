package modelo.excepciones;

public class AccionInvalidaError extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AccionInvalidaError(String mensaje) {
		super(mensaje);
		}

}
