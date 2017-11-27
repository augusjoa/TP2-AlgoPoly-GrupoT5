package modelo.excepciones;

import modelo.Jugador;

@SuppressWarnings("serial")
public class HayGanador extends RuntimeException{
	
	Jugador jugadorGanador;
	
	public HayGanador(Jugador ganador){
		jugadorGanador = ganador;
	}
	
	public Jugador ganador(){
		return jugadorGanador;
	}
}
