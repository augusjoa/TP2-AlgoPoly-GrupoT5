package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import modelo.casillas.Carcel;

public class AlgoPoly {
	
	Jugador jugador1;
	Jugador jugador2;
	Jugador jugador3;
	Jugador jugadorActual;
	int dineroInicial = 100000;
	//Tablero tablero;
	ArrayList<Jugador> turnoDelJugador = new ArrayList<>();
	//cambiar a una circular
	Iterator<Jugador> iterador = turnoDelJugador.listIterator();
	
	public AlgoPoly(){
		this.jugador1= new Jugador(dineroInicial);
		this.jugador2= new Jugador(dineroInicial);
		this.jugador3= new Jugador(dineroInicial);
		
		//this.tablero= new Tablero();
	}
	
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
		if(iterador.hasNext())	jugadorActual= iterador.next();
	}
	
	
}
