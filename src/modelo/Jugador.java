package modelo;

import java.util.Collection;
import java.util.HashSet;

import modelo.interfaces.Adquirible;



public class Jugador {
	
	private Dinero dinero = new Dinero(100000);
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
		this.jugadorPuedeMover = false;
	}
	
	public void pasarTurno(){
		jugadorPuedeMover = true;
	}


	public int getCantidadDePropiedades() {
		return adquisiciones.size();
	}

	public boolean comprar(Adquirible unComprable) {
		
		if(dinero.comprar(unComprable)) {
			adquisiciones.add(unComprable);
			return true;
		}
		return false;
	}

	public boolean esDuenio(Adquirible unComprable) {
		return adquisiciones.contains(unComprable);
	}
	

}
