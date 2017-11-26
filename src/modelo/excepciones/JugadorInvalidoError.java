package modelo.excepciones;

public class JugadorInvalidoError extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public JugadorInvalidoError(String mensaje) {
		super(mensaje);
		}


}
