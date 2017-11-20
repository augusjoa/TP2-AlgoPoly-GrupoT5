package modelo.casillas;

import modelo.Jugador;

public class RetrocesoDinamico {

	public void retrocederAlJugador(Jugador unJugador, int numeroDelDado) {
		
		if (numeroDelDado > 6 && numeroDelDado < 11) {
			unJugador.moverse((int) (- unJugador.getDinero() % numeroDelDado));
		}
		
		else if (numeroDelDado < 7) {
			unJugador.moverse(-numeroDelDado + unJugador.getCantidadDePropiedades());
		}
		
		else unJugador.moverse(- numeroDelDado + 2);
		
	}

}
