package modelo.casillas;

import modelo.Jugador;
import modelo.interfaces.Visitable;


public class RetrocesoDinamico implements Visitable{

	private String nombre = "Retroceso Dinamico";
	
	public int getCantidadDePasos(Jugador unJugador, int numeroDelDado) {
		int casillasAMover = 0;
		if (numeroDelDado < 7) {
			casillasAMover = numeroDelDado - unJugador.getCantidadDePropiedades();
		}
		else if (numeroDelDado < 11) {
			casillasAMover =  unJugador.getDinero().getValor() % numeroDelDado;
		}
		else casillasAMover =  numeroDelDado - 2;
		return -casillasAMover;
	}

	@Override
	public String getNombre(){
		return nombre;
	}

	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		int cantidadDePasos = getCantidadDePasos(unJugador, unJugador.getNumeroDelDado());
		unJugador.moverse(cantidadDePasos);
	}

}
