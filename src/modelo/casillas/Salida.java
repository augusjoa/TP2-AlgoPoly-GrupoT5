package modelo.casillas;

import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Salida implements Visitable{

	private String nombre= "Salida";
	
	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {

	}
	
	public String getNombre(){
		return nombre;
	}

}
