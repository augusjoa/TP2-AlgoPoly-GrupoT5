package modelo;

import java.util.ArrayList;

import modelo.casillas.Barrio;

public class Jugador {
	
	private ArrayList<Barrio> propiedades = new ArrayList<Barrio>();
	private Dinero dinero;
	public Posicion posicion = new Posicion(0);
	public boolean jugadorPuedeMover=true;
	//public boolean estaEnCarcel=false;
	
	public Jugador(double dineroinicial) {
		this.dinero = new Dinero(dineroinicial);
	}

	public double getDinero() {
		return this.dinero.getValor();
	}
	
	public void comprarBarrio(Barrio barrio) {
		if(this.getDinero() >= barrio.getValor() && !barrio.estaComprado()) {
			this.propiedades.add(barrio);
			barrio.comprado();
			this.sustraerDinero(barrio.getValor());
		}
	}
	
	public void agregarDinero(double valor) {
		this.dinero.agregarValor(valor);
	}
	
	public void sustraerDinero(double valor) {
		//agregar exp para que no quede valor negativo
		this.dinero.sustraerValor(valor);
	}

	public boolean puedeMoverse(){
		return jugadorPuedeMover;
	}
	
	public void jugadorDetenido() {
		jugadorPuedeMover = false;		
	}
	
	public void moverse(int numeroDelDado){
		int posAnterior= this.posicion.getPosX();
		this.posicion.setPosX(posAnterior + numeroDelDado);
		this.jugadorPuedeMover = false;
	}
	
	public void pasarTurno(){
		jugadorPuedeMover = true;
	}

	public int getPosicion() {
		return posicion.getPosX();
	}

	public int getCantidadDePropiedades() {
		return this.propiedades.size();
	}
	

}
