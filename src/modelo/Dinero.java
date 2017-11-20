package modelo;

import modelo.interfaces.Adquirible;

public class Dinero {
	
	private double valor;

	public Dinero(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}

	public void agregarValor(double valor) {
		this.valor += valor;
		
	}

	public void sustraerValor(double valor) {
		this.valor -= valor;
		
	}

	public boolean comprar(Adquirible unComprable) {
		if(this.valor > unComprable.getPrecio()) {
			this.valor -= unComprable.getPrecio();
			return true;
		}
		return false;
	}
	
}
