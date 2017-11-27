package modelo.casillas;

import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Policia implements Visitable{

	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		unJugador.irPreso();
	}
	
}
