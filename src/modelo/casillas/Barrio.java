package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;

public class Barrio implements Adquirible{

//	private boolean tieneDuenio = false;
	Dinero valorDelBarrio;
	Jugador jugadorDuenio;
	
	public Barrio(double valor) {
		this.valorDelBarrio = new Dinero(valor);
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
	public double getPrecio() {
		return valorDelBarrio.getValor();
	}

	@Override
	public Jugador getDuenio() {
		return jugadorDuenio;
	}


}
