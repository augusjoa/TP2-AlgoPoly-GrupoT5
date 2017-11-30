package modelo.casillas;

import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Policia implements Visitable{

	private String nombre= "Policia (envia a carcel)";
	
	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		unJugador.irPreso();
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}
	
}
