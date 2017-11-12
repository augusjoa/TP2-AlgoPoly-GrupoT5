package fiuba.algo3.modelo;

public class Dinero {
	
	private double dinero;

	public Dinero(double valor) {
		this.dinero = valor;
	}
	
	public double getDinero() {
		return this.dinero;
	}

	public void agregarDinero(double valor) {
		this.dinero += valor;
		
	}

	public void sustraerDinero(double valor) {
		this.dinero -= valor;
		
	}
	
}
