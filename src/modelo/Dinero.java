package modelo;

public class Dinero {
	
	private double valor;

	public Dinero(double valor) {
		this.valor = valor;
	}
	
	public double getDinero() {
		return this.valor;
	}

	public void agregarDinero(double valor) {
		this.valor += valor;
		
	}

	public void sustraerDinero(double valor) {
		this.valor -= valor;
		
	}
	
}
