package modelo;

import modelo.casillas.Carcel;

public class Partida {
	
	Jugador jugador1;
	Jugador jugador2;
	Jugador jugador3;
	Jugador jugadorActual;
	Carcel carcel;
	
	public Partida(Jugador jugador1, Jugador jugador2, Jugador jugador3,Carcel carcel){
		this.jugador1= jugador1;
		this.jugador2= jugador2;
		this.jugador3= jugador3;
		
		this.carcel= carcel;
		
		this.jugadorActual= jugador1;
	}
	
	public void avanzarTurno(){
		cambiarJugadorActual();
		jugadorActual.pasarTurno();
	}

	private void cambiarJugadorActual() {
		if(jugadorActual== jugador1) jugadorActual= jugador2;
		else if(jugadorActual== jugador2) jugadorActual= jugador3;
		else if(jugadorActual== jugador3) jugadorActual= jugador1;
	}
	
	public void corroborarPosicion(){
		if(carcel.jugadorEstaEnCarcel(jugadorActual)){
			carcel.retenerJugador(jugadorActual);
		}
		
	}
	
	//funcion de Comienzo de partida
	//se fija donde esta el personajes la posicion -> se fija si se encuentra en X casillero
	//si no puede moverse (esta en carcel) -> retiene
	//mueve
	//se fija donde cae (aplica parametros)
	//pasa turno
}
