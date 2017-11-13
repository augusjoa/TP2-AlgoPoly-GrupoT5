package fiuba.algo3.modelo;

import java.util.Hashtable;

import fiuba.algo3.modelo.Jugador;

public class Carcel {
	public Hashtable<Jugador, Integer> jugadoresEnCarcel = new Hashtable<Jugador, Integer>();
	
	public void retenerJugador(Jugador jugador){
		if(!this.jugadoresEnCarcel.containsKey(jugador)){
			this.jugadoresEnCarcel.put(jugador, 1);
			jugador.setAccionDeMovimiento(false);
			
		}
		else if(jugadoresEnCarcel.get(jugador)==2 && jugadoresEnCarcel.get(jugador)==3){
			//jugador puede pagar la fianza
			//vacior jugador del dic
		}
		else if(jugadoresEnCarcel.get(jugador)==4){
			jugador.setAccionDeMovimiento(true);
			//vaciar jugador del dic
		}
		//jugador.pasarTurno();
	}
}
