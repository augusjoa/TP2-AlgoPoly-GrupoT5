package fiuba.algo3.modelo;

public class AvanceDinamico {

	public Jugador avanzar(Jugador unJugador, int numeroDelDado) {
		
		if(numeroDelDado > 6) {
			unJugador.moverse((int) (unJugador.getDinero() / numeroDelDado));
			return unJugador;
		}
		
		unJugador.moverse(numeroDelDado - 2);
		
		return unJugador;
	}

}
