package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

import casillas.Barrio;

public class BarrioTest {
	//private static final double DELTA = 1e-15;
	
	@Test
	public void testAlComprarElBarrioElJugadorEsPropietario() {
		Barrio unBarrio = new Barrio();
		Jugador unJugador = new Jugador(100000);
		
		unBarrio.setPropietario(unJugador);
		
		Assert.assertEquals(unJugador, unBarrio.getPropietario());
	}
	
}
