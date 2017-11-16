package modelo;

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
	
}
