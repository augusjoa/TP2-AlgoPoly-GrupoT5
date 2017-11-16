package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillas.Barrio;
import modelo.Jugador;

public class BarrioTest {
	//private static final double DELTA = 1e-15;
	
	@Test
	public void testAlComprarElBarrioElJugadorEsPropietario() {
		Barrio unBarrio = new Barrio(1000);
		Jugador unJugador = new Jugador(100000);
		
		unJugador.comprarBarrio(unBarrio);
		
		Assert.assertTrue(unBarrio.estaComprado());
	}
	
}
