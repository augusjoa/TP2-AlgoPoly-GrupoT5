package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;

public abstract class Barrio implements Adquirible,Visitable{

	private Dinero valorDelBarrio;
	protected Jugador jugadorDuenio;
	

	public Barrio(int precioDelBarrio) {
		valorDelBarrio = new Dinero(precioDelBarrio);
		jugadorDuenio = null;
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

	

}
