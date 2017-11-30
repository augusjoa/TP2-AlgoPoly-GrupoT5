package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import modelo.excepciones.HayGanador;

public class AlgoPoly {
	
	public static final int cantidadDeJugadores= 3;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private Iterator<Jugador> iterador = null;
	private Jugador jugadorActual;
	private Tablero tablero;
	private boolean iniciada=false;
	private ArrayList<Integer> turnoDeJugadores = new ArrayList<Integer>();
	
	
	public AlgoPoly() {
		
		tablero = Tablero.TableroUnico();
		
		for(int i=0;i<cantidadDeJugadores;i++) {
			turnoDeJugadores.add(i+1);
		}
		Collections.shuffle(turnoDeJugadores);
		
		for(int i=0;i<cantidadDeJugadores;i++) {
			jugadores.add(new Jugador(turnoDeJugadores.get(i)));
		}
		
	}
	

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
		
		jugadorActual = siguienteJugador();
		jugadorActual.iniciarTurno();
		//
		//jugadorActual.pasarTurno() pone en false los "movimientos";
		if(jugadorPerdio())	borrarJugador();
		
	}
	
	public int getTurnoDeJugador(int i){
		return turnoDeJugadores.get(i);
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
	
	public Tablero tablero(){
		return tablero;
	}
}
