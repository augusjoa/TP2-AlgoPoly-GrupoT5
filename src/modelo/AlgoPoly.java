package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import modelo.excepciones.HayGanador;

public class AlgoPoly {
	
	public static final int cantidadDeJugadores= 3;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private Iterator<Jugador> iterador = null;
	private Jugador jugadorActual;
	private Tablero tablero;
	private boolean iniciada=false;
	
	public AlgoPoly() {
		
		tablero = Tablero.TableroUnico();
		
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
	public boolean jugadorPerdio(){
		return jugadorActual.perdio();
	}

	public void borrarJugador(){
		jugadores.remove(jugadorActual);
	}
	
	public void iniciarPartida() throws HayGanador{
		if(iniciada==false){
			posicionarJugadoresInicial();
			iniciada=true;
		}
		try{
			avanzarTurno();
		}
		catch(HayGanador e){
			throw e;
		}
	}
	
	public void avanzarTurno() throws HayGanador{
		if(hayGanador()) throw new HayGanador(ganador());
		
		jugadorActual=siguienteJugador();
		//jugadorActual.pasarTurno() pone en false los "movimientos";
		if(jugadorPerdio())	borrarJugador();
		
	}

	public boolean hayGanador(){
		return cantidadDeJugadoresActivos()==1;
	}
	
	public Jugador ganador(){
		return jugadores.get(cantidadDeJugadoresActivos());
	}
		
	public Jugador siguienteJugador(){
		if(iterador == null || !iterador.hasNext() ) iterador = jugadores.iterator();
		return iterador.next();
	}
	
	public void posicionarJugadoresInicial(){
		for(Jugador jugador: jugadores){
			jugador.setCasillaActual(tablero.getCasillero(0));
		}
	}

	public int cantidadDeJugadoresActivos() {
		return jugadores.size();
	}
	
	public Jugador getJugadorActual() {
		return jugadorActual;
	}
}
