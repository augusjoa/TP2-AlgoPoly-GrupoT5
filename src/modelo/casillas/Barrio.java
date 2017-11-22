package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;

public class Barrio implements Adquirible{

//	private boolean tieneDuenio = false;
	private Dinero valorDelBarrio;
	private Jugador jugadorDuenio;
	
	public Barrio(int precioDelBarrio) {
		valorDelBarrio = new Dinero(precioDelBarrio);
		jugadorDuenio = null;
	}

//	public void comprado() {
//		this.tieneDuenio = true;
//	}
//	
//	public boolean estaComprado() {
//		return this.tieneDuenio;
//	}
//	
//	public double getValor() {
//		return this.valorDelBarrio.getValor();
//	}

	@Override
	public Dinero getPrecio() {
		return valorDelBarrio;
	}

	@Override
	public Jugador getDuenio() {
		return jugadorDuenio;
	}


}
