package fiuba.algo3.modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Jugador;

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
