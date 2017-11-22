package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;

public class Casa implements Adquirible{
	Dinero valorDeLaCasa;
	Jugador jugadorDuenio;

	public Casa(int valor) {
		valorDeLaCasa = new Dinero(valor);
		jugadorDuenio = null;
	}
	@Override
	public Dinero getPrecio() {
		return valorDeLaCasa;
	}
	@Override
	public Jugador getDuenio() {
		return jugadorDuenio;
	}

}
