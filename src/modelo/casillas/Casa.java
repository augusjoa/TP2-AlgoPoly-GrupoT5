package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;

public class Casa implements Adquirible{
	Dinero valorDeaCasa;
	Jugador jugadorDuenio;

	public Casa(double valor) {
		this.valorDeaCasa = new Dinero(valor);
	}
	@Override
	public double getPrecio() {
		return valorDeaCasa.getValor();
	}
	@Override
	public Jugador getDuenio() {
		return jugadorDuenio;
	}

}
