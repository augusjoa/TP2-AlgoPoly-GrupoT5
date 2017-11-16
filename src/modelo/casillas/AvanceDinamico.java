package modelo.casillas;

import modelo.Jugador;

public class AvanceDinamico {

	public void avanzar(Jugador unJugador, int numeroDelDado) {
		
		if(numeroDelDado > 6 && numeroDelDado < 11) {
			unJugador.moverse((int) ( unJugador.getDinero() / numeroDelDado));
		}
		
		else if(numeroDelDado > 10) {
			unJugador.moverse(numeroDelDado - unJugador.getCantidadDePropiedades());
		}		
		else unJugador.moverse(numeroDelDado - 2);
		
	}

}
