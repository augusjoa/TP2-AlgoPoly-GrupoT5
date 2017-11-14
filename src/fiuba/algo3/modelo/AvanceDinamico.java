package fiuba.algo3.modelo;

public class AvanceDinamico {

	public Jugador avanzar(Jugador unJugador, int numeroDelDado) {
		
		unJugador.moverse(numeroDelDado - 2);
		
		return unJugador;
	}

}
