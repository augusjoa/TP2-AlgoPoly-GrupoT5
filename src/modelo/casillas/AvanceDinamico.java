package modelo.casillas;

import modelo.Jugador;


public class AvanceDinamico {

	public void avanzarAlJugador(Jugador unJugador, int sumaDeLosDados) {
		
		if(sumaDeLosDados > 10) {
			unJugador.moverse(sumaDeLosDados - unJugador.getCantidadDePropiedades());
		}
		else if(sumaDeLosDados > 6) {
			unJugador.moverse((int) ( unJugador.getDinero() % sumaDeLosDados));
		}		
		else unJugador.moverse(sumaDeLosDados - 2);
	}

}
