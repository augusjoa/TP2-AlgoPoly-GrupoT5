package modelo;

import java.util.Collection;
import java.util.HashSet;

import modelo.casillas.Barrio;
import modelo.interfaces.Adquirible;



public class Jugador {
	
	private Dinero dinero = new Dinero(100000);
	private Posicion posicion = new Posicion(0);
	private boolean jugadorPuedeMover=true;
	private Collection <Adquirible> adquisiciones = new HashSet<Adquirible>();
	
	public int getDinero() {
		return dinero.getValor();
	}
	
	public void agregarDinero(Dinero unDinero) {
		dinero.agregarDinero(unDinero);
	}
	
	public void sustraerDinero(Dinero unDinero) {
		dinero.sustraerDinero(unDinero);
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
		return adquisiciones.size();
	}

	public boolean comprar(Adquirible unAdquirible) {
		
		if(dinero.comprar(unAdquirible.getPrecio())) {
			adquisiciones.add(unAdquirible);
			unAdquirible.setDuenio(this);
			return true;
		}
		return false;
	}

	public boolean esDuenio(Adquirible unAdquirible) {
		return adquisiciones.contains(unAdquirible);
	}

	public boolean vender(Adquirible unAdquirible) {
		if(!adquisiciones.contains(unAdquirible)) return false; //o ver de agregar excepciones
		
		dinero.vender(unAdquirible.getPrecio());
		adquisiciones.remove(unAdquirible);
		unAdquirible.setDuenio(null);
		return true;
		
	}

}