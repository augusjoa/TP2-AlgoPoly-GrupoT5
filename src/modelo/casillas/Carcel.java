package modelo.casillas;

import java.util.Hashtable;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Carcel implements Visitable{
	private Hashtable<Jugador, Integer> jugadoresEnCarcel = new Hashtable<Jugador, Integer>();
	private Dinero valorDeLaFianza = new Dinero(45000);
	
	public boolean jugadorEstaEnCarcel(Jugador jugador){
		return this.jugadoresEnCarcel.containsKey(jugador);
	}
	
	public boolean incrementarTurno(Jugador jugador){
		if(jugadorEstaEnCarcel(jugador)) {
			int num = jugadoresEnCarcel.get(jugador);
			jugadoresEnCarcel.replace(jugador, num+1);
			return true;
		}
		return false;
	}
	
	public void retenerJugador(Jugador jugador){
		jugadoresEnCarcel.put(jugador, 1);
		jugador.jugadorDetenido();	
	}
	
	public boolean pagarFianza(Jugador jugador){
		//if(jugadoresEnCarcel.get(jugador) == 2 || jugadoresEnCarcel.get(jugador) == 3){
			if(jugador.getDinero().sustraerDinero(valorDeLaFianza)){
				liberarJugador(jugador);
				return true;
			}
			return false;
		//}
	}
	
	public void liberarJugador(Jugador jugador){
		jugadoresEnCarcel.remove(jugador);
		jugador.pasarTurno();

	}

	@Override
	public Jugador esVisitadoPorJugador(Jugador jugador) {
		if(!jugadoresEnCarcel.containsKey(jugador))	retenerJugador(jugador);
		
		if(jugadoresEnCarcel.get(jugador) == 4) liberarJugador(jugador);
		
		incrementarTurno(jugador);
		
		
		return null;
	}
	
}
