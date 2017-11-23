package modelo.casillas;

import modelo.DobleDado;
import modelo.Jugador;
import modelo.interfaces.Visitable;


public class AvanceDinamico implements Visitable{

	private void avanzarAlJugador(Jugador unJugador) {
		DobleDado dados = unJugador.getDadosTirados();
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
		this.avanzarAlJugador(unJugador);
		return null;
	}
}
