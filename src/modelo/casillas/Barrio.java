package modelo.casillas;

import modelo.Dinero;

public class Barrio {

	private boolean tieneDuenio = false;
	Dinero valorDelBarrio;

	public Barrio(double valor) {
		this.valorDelBarrio = new Dinero(valor);
	}

	public void comprado() {
		this.tieneDuenio = true;
	}
	
	public boolean estaComprado() {
		return this.tieneDuenio;
	}
	
	public double getValor() {
		return this.valorDelBarrio.getValor();
	}


}
