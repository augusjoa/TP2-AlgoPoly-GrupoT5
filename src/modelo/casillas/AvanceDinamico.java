package modelo.casillas;

import modelo.Jugador;

public class AvanceDinamico {

	public void avanzar(Jugador unJugador, int numeroDelDado) {
		
		if(numeroDelDado > 10) {
			unJugador.moverse(numeroDelDado - unJugador.getCantidadDePropiedades());
		}
		else if(numeroDelDado > 6) {
			unJugador.moverse((int) ( unJugador.getDinero() / numeroDelDado));
		}		
		else unJugador.moverse(numeroDelDado - 2);
	}

}
