package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class AlgoPoly {
	
	Jugador jugador1 = new Jugador();
	Jugador jugador2 = new Jugador();
	Jugador jugador3 = new Jugador();
	Jugador jugadorActual;
	//Tablero tablero;
	ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	Iterator<Jugador> iterador = jugadores.iterator();
	
	public Jugador jugadorInicialRandom(){
		Random random = new Random();
		int numRandom = random.nextInt(3);
		
		if(numRandom==0) return jugador1;
		else if(numRandom==1) return jugador2;
		return jugador3;
	}
	
	public void iniciarPartida(){
		jugadorActual=iterador.next();
	}
	
	public void avanzarTurno(){
		cambiarJugadorActual();
		jugadorActual.pasarTurno();
	}

	private void cambiarJugadorActual() {
		if(!iterador.hasNext()) iterador = jugadores.iterator();
		jugadorActual= iterador.next();
	}
	
	
}
