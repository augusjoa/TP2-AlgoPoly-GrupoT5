package modelo.casillas;

import java.util.Hashtable;

import modelo.Dinero;
import modelo.Jugador;
import modelo.Posicion;
import modelo.interfaces.Visitable;

public class Carcel implements Visitable{
	private Hashtable<Jugador, Integer> jugadoresEnCarcel = new Hashtable<Jugador, Integer>();
	private Dinero valorDeLaFianza = new Dinero(45000);
	
	public boolean jugadorEstaEnCarcel(Jugador jugador){
		return this.jugadoresEnCarcel.containsKey(jugador);
	}
	
	public void incrementarTurno(Jugador jugador){
		if(jugadoresEnCarcel.containsKey(jugador)) {
			int num = jugadoresEnCarcel.get(jugador);
			jugadoresEnCarcel.replace(jugador, num+1);
		}
	}
	
	public void retenerJugador(Jugador jugador){
		jugadoresEnCarcel.put(jugador, 1);
		jugador.jugadorDetenido();	
	}
	
	public void pagarFianza(Jugador jugador){
		//if(jugadoresEnCarcel.get(jugador) == 2 || jugadoresEnCarcel.get(jugador) == 3){
			if(jugador.getDinero()>valorDeLaFianza.getValor()){
				jugador.sustraerDinero(valorDeLaFianza);
				liberarJugador(jugador);
			}	
		//}
	}
	
	public void liberarJugador(Jugador jugador){
		jugadoresEnCarcel.remove(jugador);
		jugador.pasarTurno();

	}

	@Override
	public Jugador esVisitadoPorJugador(Jugador jugador) {
		if(!jugadoresEnCarcel.containsKey(jugador))	retenerJugador(jugador);
		
		if(jugadoresEnCarcel.get(jugador) ==4) liberarJugador(jugador);
		
		incrementarTurno(jugador);
		
		return null;
	}
}
