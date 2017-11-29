package modelo.casillas;

import modelo.Jugador;
import modelo.interfaces.Visitable;


public class AvanceDinamico implements Visitable{

	private String nombre = "Avance Dinamico";
	
	public int getCantidadDePasos(Jugador unJugador, int tiradaDeDados) {
		int casillasAMover = 0;
		if (tiradaDeDados < 7) {
			casillasAMover = (tiradaDeDados - 2);
		}
		else if(tiradaDeDados < 11) {
			casillasAMover = ( unJugador.getDinero().getValor() % tiradaDeDados);
		}		
		else casillasAMover = (tiradaDeDados - unJugador.getCantidadDePropiedades());
		return casillasAMover;
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
