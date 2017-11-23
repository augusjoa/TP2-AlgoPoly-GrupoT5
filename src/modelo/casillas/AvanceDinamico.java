package modelo.casillas;

import modelo.Jugador;
import modelo.interfaces.Visitable;


public class AvanceDinamico implements Visitable{

	public void avanzarAlJugador(Jugador unJugador, int sumaDeLosDados) {
		
		if(sumaDeLosDados > 10) {
			unJugador.moverse(sumaDeLosDados - unJugador.getCantidadDePropiedades());
		}
		else if(sumaDeLosDados > 6) {
			unJugador.moverse((int) ( unJugador.getDinero() % sumaDeLosDados));
		}		
		else unJugador.moverse(sumaDeLosDados - 2);
	}
	
	@Override
	public Jugador esVisitadoPorJugador(Jugador unJugador) {
		this.avanzarAlJugador(unJugador, unJugador.tirarDados());
		return null;
	}

}
