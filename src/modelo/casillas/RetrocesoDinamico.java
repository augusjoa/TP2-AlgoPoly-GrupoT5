package modelo.casillas;

import modelo.Jugador;
import modelo.interfaces.Visitable;


public class RetrocesoDinamico implements Visitable{

	public int retrocederAlJugador(Jugador unJugador, int numeroDelDado) {
		
		if (numeroDelDado > 6 && numeroDelDado < 11) {
			return (- unJugador.getDinero()._getValor() % numeroDelDado);//refactor
		}
		
		else if (numeroDelDado < 7) {
			return (-numeroDelDado + unJugador.getCantidadDePropiedades());
		}
		
		else return (- numeroDelDado + 2);
		
	}

	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		int cantidadDeCasillas = retrocederAlJugador(unJugador, unJugador.getNumeroDelDado());
		//unJugador.moverse(cantidadDeCasillas);
	}

}
