package casillas;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Posicion;

public class Policia {
	
	Posicion posicion = new Posicion(10);
	
	public void detencionEnLaCarcel(Jugador jugador,Carcel carcel){
		jugador.posicion.setPosX(5);
	}
	
}
