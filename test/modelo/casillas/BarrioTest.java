package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillas.Barrio;
import modelo.Jugador;

public class BarrioTest {
	
	@Test
	public void testElBarrioTieneDuenioAlSerCompradoPorUnJugador() {
		Barrio unBarrio = new Barrio(1000);
		Jugador unJugador = new Jugador();
		
		unJugador.comprar(unBarrio);
		
		Assert.assertEquals(unJugador, unBarrio.getDuenio());
	}
	
	@Test
	public void testElBarrioNoTieneDuenioAlSerVendido() {
		Barrio unBarrio = new Barrio(1000);
		Jugador unJugador = new Jugador();
		unJugador.comprar(unBarrio);
		
		unJugador.vender(unBarrio);
		
		Assert.assertNull(unBarrio.getDuenio());
	}
}
