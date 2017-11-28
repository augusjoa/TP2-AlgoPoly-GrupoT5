package modelo.casillas;

import java.util.Hashtable;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Carcel implements Visitable{
	private Dinero valorDeLaFianza = new Dinero(45000);
	

	public void pagarFianza(Jugador jugador){
		
			jugador.getDinero().sustraerDinero(valorDeLaFianza);
			jugador.liberar();

	}
	
	@Override
	public void esVisitadoPorJugador(Jugador jugador) {
		jugador.encarcelar();
	}
	
}
