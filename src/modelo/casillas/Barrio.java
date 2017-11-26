package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.excepciones.JugadorInvalidoError;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;

public abstract class Barrio implements Adquirible,Visitable{

	private Dinero valorDelBarrio;
	protected Jugador jugadorDuenio;
	protected String nombre;
	

	public Barrio(int precioDelBarrio, String unNombre) {
		valorDelBarrio = new Dinero(precioDelBarrio);
		jugadorDuenio = null;
		this.nombre = unNombre;
	}
	
	public abstract int getCantidadDeEdificios();
	
	@Override
	public Dinero getPrecio() {
		return valorDelBarrio;
	}

	@Override
	public Jugador getDuenio() {
		return jugadorDuenio;
	}

	@Override
	public void setDuenio(Jugador unJugador) {
		jugadorDuenio = unJugador;
	}
	
	public void esVisitadoPorJugador(Jugador unJugador) {
		if(this.getDuenio() != unJugador && this.getDuenio() != null) {
			this.cobrarAlquilerA(unJugador);
		}
	}
	protected void verificarJugador(Jugador unJugador) {
		if(this.getDuenio() != unJugador) {
			throw new JugadorInvalidoError("Solo el propietario puede construir en el terreno");
		}
	}

	public abstract void cobrarAlquilerA(Jugador unJugador);
	public abstract void agregarCasa(Jugador unJugador);

}
