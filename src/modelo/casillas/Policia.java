package modelo.casillas;

import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Policia implements Visitable{

	private Carcel carcel;
	
	public Policia(Carcel unaCarcel){
		carcel = unaCarcel;
	}

	@Override
	public void esVisitadoPorJugador(Jugador jugador) {
		//this.elQueSabeMover.mover(jugador, carcel)
	}


	
	
}
