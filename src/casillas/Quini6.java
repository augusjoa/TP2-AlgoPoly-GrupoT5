package casillas;

import java.util.Hashtable;

import fiuba.algo3.modelo.Jugador;

public class Quini6 {
	private Hashtable<Jugador, Integer> jugadores = new Hashtable<Jugador, Integer>();
	private double primerPremio = 50000;
	private double segundoPremio = 30000;
	
	public void obtenerPremio(Jugador jugador){
		if(!this.jugadores.containsKey(jugador)){
			jugador.agregarDinero(primerPremio);
			this.jugadores.put(jugador, 1);
		}
		else if(jugadores.get(jugador)==1){
			jugador.agregarDinero(segundoPremio);
			this.jugadores.replace(jugador, 2);
		}
	}
}