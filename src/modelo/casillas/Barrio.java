package modelo.casillas;

public class Barrio {

	private boolean tieneDueno = false;
	private double valorDeBarrio;

	public Barrio(double valor) {
		this.valorDeBarrio = valor;
	}

	public void comprado() {
		this.tieneDueno = true;
	}
	
	public boolean estaComprado() {
		return this.tieneDueno;
	}
	
	public double getValor() {
		return this.valorDeBarrio;
	}


}
