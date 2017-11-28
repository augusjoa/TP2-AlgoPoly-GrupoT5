package modelo.estadoJugador;
import modelo.Jugador;
import modelo.casillas.Carcel;
import modelo.interfaces.Visitable;

public interface EstadoJugador {
	
	public void moverse(Jugador jugador, int cantidad, Visitable unVisitable);
	abstract public void actualizarEstado(Jugador jugador);
	abstract public void pagarFianza(Jugador jugador, Carcel unaCarcel);

	
	
	

}
