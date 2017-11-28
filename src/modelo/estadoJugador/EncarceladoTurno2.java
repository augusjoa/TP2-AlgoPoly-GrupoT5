package modelo.estadoJugador;

import modelo.Jugador;
import modelo.casillas.Carcel;
import modelo.excepciones.JugadorNoPuedeMoverse;
import modelo.interfaces.Visitable;

public class EncarceladoTurno2 implements EstadoJugador {

	@Override
	public void moverse(Jugador jugador, int cantidad, Visitable unVisitable) {
		throw new JugadorNoPuedeMoverse();		
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		EncarceladoTurno3 estado = new EncarceladoTurno3();
		jugador.cambiarEstado(estado);
	}

	@Override
	public void pagarFianza(Jugador jugador, Carcel unaCarcel) {
		unaCarcel.pagarFianza(jugador);	
	}

}
