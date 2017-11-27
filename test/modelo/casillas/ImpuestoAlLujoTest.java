package modelo.casillas;


import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
import modelo.Jugador;

public class ImpuestoAlLujoTest {

	@Test
	public void jugadorCaenEnImpuestoSuDineroSeReduceUn10PorcientoDelTotal(){
		Jugador jugador = new Jugador();
		ImpuestoAlLujo impuestoAlLujo = new ImpuestoAlLujo();
		
		Dinero dineroInicial = jugador.getDinero();
		Dinero valorEsperado = new Dinero(dineroInicial.getValor() - (dineroInicial.getValor() * 10) / 100);
		
		impuestoAlLujo.esVisitadoPorJugador(jugador);
		
		
		Assert.assertEquals(valorEsperado, jugador.getDinero());
	}
	
}
