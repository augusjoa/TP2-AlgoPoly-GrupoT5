package fiuba.algo3.modelo;

public class Jugador {
	
	private Dinero dinero;
	
	public Jugador(double dineroinicial) {
		this.dinero = new Dinero(dineroinicial);
	}

	public double getDinero() {
		return this.dinero.getDinero();
	}
	
	public void agregarDinero(double valor) {
		this.dinero.agregarDinero(valor);
	}
	
	public void sustraerDinero(double valor) {
		this.dinero.sustraerDinero(valor);
	}

}
