package modelo.casillas;

import modelo.Jugador;
import modelo.interfaces.Visitable;


public class AvanceDinamico implements Visitable{

	public int avanzarAlJugador(Jugador unJugador, int numeroDelDado) {
		if(numeroDelDado > 10) {
			return (numeroDelDado - unJugador.getCantidadDePropiedades());
		}
		else if(numeroDelDado > 6) {
			return ( unJugador.getDinero().getValor() % numeroDelDado);//refactor
		}		
		else return(numeroDelDado - 2);
	}
	
	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		int cantidadDeCasillas = avanzarAlJugador(unJugador,unJugador.getNumeroDelDado());
		//unJugador.moverse(cantidadDeCasillas);
	}
}
