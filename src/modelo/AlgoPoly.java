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
	//cambiar a una circular
	Iterator<Jugador> iterador = jugadores.iterator();
	
	public void inicioDeJugadoresRandom(){
	}
	
	public Jugador jugadorInicialRandom(){
		Random random = new Random();
		int numRandom = random.nextInt(3);
		
		if(numRandom==0) return this.jugador1;
		else if(numRandom==1) return this.jugador2;
		return this.jugador3;
	}
	
	public void iniciarPartida(){
		jugadorActual=iterador.next();
	}
	
	public void avanzarTurno(){
		cambiarJugadorActual();
		jugadorActual.pasarTurno();
	}

	private void cambiarJugadorActual() {
		//la lista siempre va atener un siguiente
		if(!iterador.hasNext()) iterador = jugadores.iterator();
		jugadorActual= iterador.next();
	}
	
	
}
