package modelo.casillas;

import modelo.Jugador;
import modelo.Posicion;
import modelo.interfaces.Visitable;

public class Policia implements Visitable{
	
	Posicion posicion = new Posicion(10);
	
	public void moverALaCarcel(Jugador jugador,Carcel carcel){
		jugador.posicion.setPosX(carcel.getPos());
	}

	@Override
	public Jugador esVisitadoPorJugador(Jugador unJugador) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
