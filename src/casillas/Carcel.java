package casillas;

import java.util.Hashtable;

import modelo.Jugador;
import modelo.Posicion;

public class Carcel {
	public Hashtable<Jugador, Integer> jugadoresEnCarcel = new Hashtable<Jugador, Integer>();
	double valorDeLaFianza= 45000;
	Posicion posicion = new Posicion(5);
	
	public boolean jugadorEstaEnCarcel(Jugador jugador){
		return this.jugadoresEnCarcel.containsKey(jugador);
	}
	
	public void retenerJugador(Jugador jugador){
		//if posicion de jugador == pos carcel que haga todo eso?
		if(this.jugadoresEnCarcel.containsKey(jugador)) {
			int num = jugadoresEnCarcel.get(jugador);
			jugadoresEnCarcel.replace(jugador, num+1);
			
		}
		if(!this.jugadoresEnCarcel.containsKey(jugador)){
			this.jugadoresEnCarcel.put(jugador, 1);
			jugador.jugadorDetenido();	
		}
	}
	
	public void pagarFianza(Jugador jugador){
		if(jugadoresEnCarcel.get(jugador) == 2 || jugadoresEnCarcel.get(jugador) == 3){
			if(jugador.getDinero()>valorDeLaFianza){
				jugador.sustraerDinero(valorDeLaFianza);
				liberarJugador(jugador);
			}	
		}
	}
	
	public void quedarLibre(Jugador jugador){
		if(jugadoresEnCarcel.get(jugador) == 4){
			liberarJugador(jugador);
		}
	}
	
	public void liberarJugador(Jugador jugador){
		jugadoresEnCarcel.remove(jugador);
		jugador.pasarTurno();

	}
}
