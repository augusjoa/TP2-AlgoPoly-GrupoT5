package modelo.casillas;

import java.util.Hashtable;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Quini6 implements Visitable {
	private Hashtable<Jugador, Integer> jugadores = new Hashtable<Jugador, Integer>();
	private Dinero primerPremio = new Dinero(50000);
	private Dinero segundoPremio = new Dinero(30000);
	private String nombre = "Quini 6";
	
	private void obtenerPremio(Jugador jugador){
		if(!this.jugadores.containsKey(jugador)){
			jugador.agregarDinero(primerPremio);
			jugadores.put(jugador, 1);
		}
		else if(jugadores.get(jugador)==1){
			jugador.agregarDinero(segundoPremio);
			jugadores.replace(jugador, 2);
		}
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}

	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		obtenerPremio(unJugador);
	}
}
