package modelo.casillas;


import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;

public class ImpuestoAlLujoTest {

	@Test
	public void jugadorCaenEnImpuestoSuDineroSeReduceUn10PorcientoDelTotal(){
		Jugador jugador = new Jugador(null);
		ImpuestoAlLujo impuestoAlLujo = new ImpuestoAlLujo();
		
		int dineroActual=jugador.getDinero()._getValor();
		
		impuestoAlLujo.esVisitadoPorJugador(jugador);
		
		int valorEsperado=dineroActual-(dineroActual*10)/100;
		Assert.assertEquals(valorEsperado, jugador.getDinero()._getValor());
	}
	
}
