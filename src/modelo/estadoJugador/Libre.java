package modelo.estadoJugador;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casillas.Carcel;
import modelo.excepciones.NoEstaEncarcelado;
import modelo.interfaces.Visitable;

public class Libre implements EstadoJugador {

	@Override
	public void moverse(Jugador jugador, int cantidad, Visitable unVisitable) {
		if (cantidad == 0) return;
		Tablero tablero = Tablero.TableroUnico();
		jugador.setCasillaActual(tablero.avanzarCasillas(unVisitable, cantidad));
	}

	@Override
	public void actualizarEstado(Jugador jugador) {
	}

	@Override
	public void pagarFianza(Jugador jugador, Carcel unaCarcel) throws NoEstaEncarcelado {
		throw new NoEstaEncarcelado();
	}

	

}
