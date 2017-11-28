package modelo.estadoJugador;

import modelo.Jugador;
import modelo.casillas.Carcel;
import modelo.excepciones.JugadorNoPuedeMoverse;
import modelo.excepciones.JugadorNoPuedePagarFianza;
import modelo.interfaces.Visitable;

public class Encarcelado implements EstadoJugador {

	@Override
	public void moverse(Jugador jugador, int cantidad, Visitable unVisitable) throws JugadorNoPuedeMoverse {
		throw new JugadorNoPuedeMoverse();
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
		EncarceladoTurno1 estado = new EncarceladoTurno1();
		jugador.cambiarEstado(estado);
	}

	@Override
	public void pagarFianza(Jugador jugador, Carcel unaCarcel) throws JugadorNoPuedePagarFianza {
		throw new JugadorNoPuedePagarFianza();
	}

}
