package modelo.casillas;

import modelo.Jugador;
import modelo.Posicion;

public class Policia {
	
	Posicion posicion = new Posicion(10);
	
	public void moverALaCarcel(Jugador jugador,Carcel carcel){
		if (jugador.posicion.getPosX()==this.posicion.getPosX()){
			jugador.posicion.setPosX(5);
		}
	}
	
}
