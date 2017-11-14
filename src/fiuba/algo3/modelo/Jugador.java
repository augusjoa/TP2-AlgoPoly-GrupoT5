package fiuba.algo3.modelo;

public class Jugador {
	
	private Dinero dinero;
	public Posicion posicion = new Posicion(0);
	public boolean accionDeMovimiento=true;
	
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
		return accionDeMovimiento;
	}
	
	public void setAccionDeMovimiento(boolean accion) {
		accionDeMovimiento=accion;		
	}
	
	public void moverse(int numeroDelDado){
		if(this.puedeMoverse()){
			//tablero.moverPersonaje(numeroDelDado);
			int posAnterior= this.posicion.getPosX();
			this.posicion.setPosX(posAnterior+numeroDelDado);
			accionDeMovimiento=false;
		}
	}

	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(int x,int y){
		
	}
}
