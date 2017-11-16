package modelo.casillas;

public class Barrio {

	private boolean tieneDueño = false;
	private double valorDeBarrio;

	public Barrio(double valor) {
		this.valorDeBarrio = valor;
	}

	public void comprado() {
		this.tieneDueño = true;
	}
	
	public boolean estaComprado() {
		return this.tieneDueño;
	}
	
	public double getValor() {
		return this.valorDeBarrio;
	}


}
