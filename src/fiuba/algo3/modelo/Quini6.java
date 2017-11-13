package fiuba.algo3.modelo;

import java.util.Hashtable;

public class Quini6 {
	private Hashtable<Jugador, Integer> jugadores = new Hashtable<Jugador, Integer>();
	private double primerPremio = 50000;
	private double segundoPremio = 30000;
	
	/*public void visitar(Jugador jugador) {
		if (!this.jugadores.containsKey(jugador)) {
			jugador.agregarDinero(this.getPremio(0));
			this.jugadores.put(jugador, 1);
		}
		else {
			jugador.agregarDinero(this.getPremio(this.jugadores.get(jugador)));
			this.jugadores.replace(jugador, 2);
		}
	}
	
	private double getPremio(int cantidaddeVisitas) {
		if(cantidaddeVisitas == 0) return this.primerPremio;
		if(cantidaddeVisitas == 1) return this.segundoPremio;
		return 0;
	}*/
	
	public void visitar(Jugador jugador){
		if(!this.jugadores.containsKey(jugador)){
			jugador.agregarDinero(primerPremio);
			this.jugadores.put(jugador, 1);
		}
		if(jugadores.get(jugador)==1){
			jugador.agregarDinero(segundoPremio);
			this.jugadores.replace(jugador, 2);
		}
	}
}
