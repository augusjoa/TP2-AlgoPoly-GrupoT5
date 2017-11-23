package modelo.casillas;

import modelo.Jugador;
import modelo.interfaces.Visitable;


public class RetrocesoDinamico implements Visitable{

	public void retrocederAlJugador(Jugador unJugador, int numeroDelDado) {
		
		if (numeroDelDado > 6 && numeroDelDado < 11) {
			unJugador.moverse((int) (- unJugador.getDinero() % numeroDelDado));
		}
		
		else if (numeroDelDado < 7) {
			unJugador.moverse(-numeroDelDado + unJugador.getCantidadDePropiedades());
		}
		
		else unJugador.moverse(- numeroDelDado + 2);
		
	}

	@Override
	public Jugador esVisitadoPorJugador(Jugador unJugador) {
		this.retrocederAlJugador(unJugador, unJugador.tirarDados());
		return null;
	}

}
