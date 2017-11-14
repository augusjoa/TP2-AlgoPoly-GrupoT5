package fiuba.algo3.modelo;

import java.util.Hashtable;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Posicion;

public class Carcel {
	public Hashtable<Jugador, Integer> jugadoresEnCarcel = new Hashtable<Jugador, Integer>();
	double valorDeLaFianza= 45000;
	Posicion posicion = new Posicion(5);
	
	//public bool jugadorEstaEnCarcel(Jugador jugador){
		//return this.jugadoresEnCarcel.containsKey(jugador)
		//}
	//}
	
	public void retenerJugador(Jugador jugador){
		if(this.jugadoresEnCarcel.containsKey(jugador)) {
			int num = jugadoresEnCarcel.get(jugador);
			jugadoresEnCarcel.replace(jugador, num+1);
			
		}
		if(!this.jugadoresEnCarcel.containsKey(jugador)){
			this.jugadoresEnCarcel.put(jugador, 1);
			jugador.setAccionDeMovimiento(false);
			
		}
		//else if(jugadoresEnCarcel.get(jugador) == 2 && jugadoresEnCarcel.get(jugador) == 3){
		//	this.pagarFianza(jugador);
		//}
		else if(jugadoresEnCarcel.get(jugador) == 4){
			jugador.setAccionDeMovimiento(true);
			jugadoresEnCarcel.remove(jugador);
		}
	}
	
	public void pagarFianza(Jugador jugador){
		if(jugador.getDinero()>valorDeLaFianza){
			jugador.sustraerDinero(valorDeLaFianza);
			jugadoresEnCarcel.remove(jugador);
			jugador.setAccionDeMovimiento(true);
		}
	}
}
