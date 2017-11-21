package modelo.casillas;

import java.util.Hashtable;

import modelo.Dinero;
import modelo.Jugador;
import modelo.Posicion;
import modelo.interfaces.Visitable;

public class Carcel implements Visitable{
	private Hashtable<Jugador, Integer> jugadoresEnCarcel = new Hashtable<Jugador, Integer>();
	private Dinero valorDeLaFianza = new Dinero(45000);
	private Posicion posicion = new Posicion(5);
	
	public boolean jugadorEstaEnCarcel(Jugador jugador){
		return this.jugadoresEnCarcel.containsKey(jugador);
	}
	
	public void retenerJugador(Jugador jugador){
		if(jugadoresEnCarcel.containsKey(jugador)) {
			int num = jugadoresEnCarcel.get(jugador);
			jugadoresEnCarcel.replace(jugador, num+1);
			
		}
		if(!jugadoresEnCarcel.containsKey(jugador)){
			jugadoresEnCarcel.put(jugador, 1);
			jugador.jugadorDetenido();	
		}
	}
	
	public void pagarFianza(Jugador jugador){
		if(jugadoresEnCarcel.get(jugador) == 2 || jugadoresEnCarcel.get(jugador) == 3){
			if(jugador.getDinero()>valorDeLaFianza.getValor()){
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

	public int getPos() {
		return posicion.getPosX();
	}

	@Override
	public Jugador esVisitadoPorJugador(Jugador unJugador) {
		// TODO Auto-generated method stub
		return null;
	}
}
