package modelo.estadoJugador;

import modelo.Jugador;
import modelo.casillas.Carcel;
import modelo.excepciones.DineroInsuficiente;
import modelo.excepciones.JugadorNoPuedeMoverse;
import modelo.excepciones.JugadorNoPuedePagarFianza;
import modelo.interfaces.Visitable;

public class Encarcelado implements EstadoJugador {
	
	private static int TURNOS_PRESO = 4;
	private int turnosRestantes;
	
	public Encarcelado() {
		this.turnosRestantes = TURNOS_PRESO;
	}
	
	@Override
	public void moverse(Jugador jugador, int cantidad, Visitable unVisitable) throws JugadorNoPuedeMoverse {
		//throw new JugadorNoPuedeMoverse();
	}

	@Override
	public void pagarFianza(Jugador jugador, Carcel unaCarcel) throws JugadorNoPuedePagarFianza,DineroInsuficiente {
		if(this.getTurnosRestantes() == 2 || this.getTurnosRestantes() == 1 )
		unaCarcel.cobrarFianza(jugador);
		else{
			throw new JugadorNoPuedePagarFianza();
		}
	}

	@Override
	public boolean puedeMoverse() {
		return false;
	}
	
	@Override
	public int getTurnosRestantes() {
		return this.turnosRestantes;
	}
	
	@Override
	public void restarTurnos(Jugador jugador) {
		this.turnosRestantes--;
		if(this.turnosRestantes == 0) {
			jugador.liberar();
		}
		
	}

}
