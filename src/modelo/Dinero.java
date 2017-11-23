package modelo;

import modelo.interfaces.Adquirible;

public class Dinero {
	private static final int porcentajeRetencionDeVenta = 15;
	private int valor;

	public Dinero(int valor) {
		this.valor = valor;
	}
	
	protected int getValor() { //Solo para las pruebas se debe utilizar
		return this.valor;
	}

	public void agregarDinero(Dinero unDinero) {
		valor += unDinero.valor;
	}

	public boolean sustraerDinero(Dinero unDinero) {
		if(valor < unDinero.valor) return false;
		valor -= unDinero.valor;
		return true;
	}

	public boolean comprar(Adquirible unAdquirible) {
		return sustraerDinero(unAdquirible.getPrecio());
	}

	public Dinero vender(Adquirible unAdquirible) {
		valor += (int) ((unAdquirible.getPrecio().valor * ( 100 - porcentajeRetencionDeVenta )) / 100 );
		return this;
	}
	
}
