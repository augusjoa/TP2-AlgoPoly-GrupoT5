package modelo.interfaces;

import modelo.Dinero;
import modelo.Jugador;

public interface Adquirible {
	public abstract Jugador getDuenio();
	public abstract Dinero getPrecio();
	public abstract void setDuenio(Jugador unJugador);
}
