package modelo.casillas;

import java.util.Hashtable;

import modelo.Dinero;
import modelo.Jugador;

public class Quini6 {
	private Hashtable<Jugador, Integer> jugadores = new Hashtable<Jugador, Integer>();
	Dinero primerPremio = new Dinero(50000);
	Dinero segundoPremio = new Dinero(30000);
	
	public void obtenerPremio(Jugador jugador){
		if(!this.jugadores.containsKey(jugador)){
			jugador.agregarDinero(primerPremio.getValor());
			this.jugadores.put(jugador, 1);
		}
		else if(jugadores.get(jugador)==1){
			jugador.agregarDinero(segundoPremio.getValor());
			this.jugadores.replace(jugador, 2);
		}
	}
}
