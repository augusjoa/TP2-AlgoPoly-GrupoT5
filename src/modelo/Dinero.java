package modelo;

import modelo.interfaces.Adquirible;

public class Dinero {
	
	private int valor;

	public Dinero(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}

	public Dinero agregarDinero(Dinero unDinero) {
		valor += unDinero.getValor();
		return this;
	}

	public boolean sustraerDinero(Dinero unDinero) {
		if(valor < unDinero.getValor()) {
			return false;
		}
		valor -= unDinero.getValor();
		return true;
	}

	public boolean comprar(Adquirible unComprable) {
		if(this.valor > unComprable.getPrecio()) {
			this.valor -= unComprable.getPrecio();
			return true;
		}
		return false;
	}
	
}
