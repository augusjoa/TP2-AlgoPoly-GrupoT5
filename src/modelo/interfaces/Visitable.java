package modelo.interfaces;

import modelo.Jugador;

public interface Visitable {
	public abstract void esVisitadoPorJugador(Jugador unJugador);
	public abstract String getNombre();
}
