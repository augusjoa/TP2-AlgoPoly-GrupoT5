package modelo.casillas;

public class Barrio {

	private boolean tieneDue�o = false;
	private double valorDeBarrio;

	public Barrio(double valor) {
		this.valorDeBarrio = valor;
	}

	public void comprado() {
		this.tieneDue�o = true;
	}
	
	public boolean estaComprado() {
		return this.tieneDue�o;
	}
	
	public double getValor() {
		return this.valorDeBarrio;
	}


}
