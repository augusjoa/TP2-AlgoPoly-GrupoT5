package casillas;

import modelo.Jugador;

public class RetrocesoDinamico {

	public Jugador avanzar(Jugador unJugador, int numeroDelDado) {
		
		if(numeroDelDado < 11) {
			unJugador.moverse((int) (unJugador.getDinero() / numeroDelDado));
			return unJugador;
		}
		
		unJugador.moverse(numeroDelDado - 2);
		
		return unJugador;
	}

}
