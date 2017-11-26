package modelo.edificios;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;

public class Casa implements Adquirible{
	Dinero valorDeLaCasa;
	Jugador jugadorDuenio=null;

	public Casa(int valor) {
		valorDeLaCasa = new Dinero(valor);
	}
	@Override
	public Dinero getPrecio() {
		return valorDeLaCasa;
	}
	@Override
	public Jugador getDuenio() {
		return jugadorDuenio;
	}
	@Override
	public void setDuenio(Jugador unJugador) {
		jugadorDuenio = unJugador;
	}
	@Override
	public void comprar(Jugador unJugador) {
		unJugador.getDinero().sustraerDinero(valorDeLaCasa);
		setDuenio(unJugador);
	}

}
