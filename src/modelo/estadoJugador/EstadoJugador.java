package modelo.estadoJugador;
import modelo.Jugador;
import modelo.casillas.Carcel;
import modelo.interfaces.Visitable;

public interface EstadoJugador {
	
	abstract public void moverse(Jugador jugador, int cantidad, Visitable unVisitable);
	abstract public void pagarFianza(Jugador jugador, Carcel unaCarcel);
	abstract public boolean puedeMoverse();
	abstract public int getTurnosRestantes();
	abstract public void restarTurnos(Jugador jugador);
	
	

}
