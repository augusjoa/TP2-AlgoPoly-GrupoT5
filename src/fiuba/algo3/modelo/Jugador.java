package fiuba.algo3.modelo;

public class Jugador {
	
	private Dinero dinero;
	public Posicion posicion = new Posicion(0);
	public boolean jugadorPuedeMover=true;
	
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
		//agregar exp para que no quede valor negativo
		this.dinero.sustraerDinero(valor);
	}

	public boolean puedeMoverse(){
		return jugadorPuedeMover;
	}
	
	public void jugadorDetenido() {
		jugadorPuedeMover=false;		
	}
	
	public void moverse(int numeroDelDado){
		int posAnterior= this.posicion.getPosX();
		this.posicion.setPosX(posAnterior+numeroDelDado);
		this.jugadorPuedeMover=false;
	}
	
	public void pasarTurno(){
		jugadorPuedeMover=true;
	}

	public Posicion getPosicion() {
		return posicion;
	}
	

}
