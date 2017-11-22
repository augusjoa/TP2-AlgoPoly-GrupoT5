package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class AlgoPoly {
	
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private Iterator<Jugador> iterador = null;
	private int cantidadDeJugadores=3;
	
	public AlgoPoly() {
		
		for(int i=0;i<cantidadDeJugadores;i++) {
			jugadores.add(new Jugador());
		}
	}
	
//	public Jugador jugadorInicialRandom(){
//		Random random = new Random();
//		int numRandom = random.nextInt(3);
//		
//		if(numRandom==0) return jugador1;
//		else if(numRandom==1) return jugador2;
//		return jugador3;
//	}
//	
//	public void iniciarPartida(){
//		jugadorActual=iterador.next();
//	}
//	
	public Jugador siguienteJugador(){
		if(iterador == null || !iterador.hasNext() ) iterador = jugadores.iterator();
		return iterador.next();
	}
//
//	private void cambiarJugadorActual() {
//		if(!iterador.hasNext()) iterador = jugadores.iterator();
//		jugadorActual= iterador.next();
//	}

	public int cantidadDeJugadoresActivos() {
		return jugadores.size();
	}
	
	
}
