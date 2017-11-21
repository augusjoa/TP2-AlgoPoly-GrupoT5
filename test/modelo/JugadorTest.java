package modelo;
import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;

public class JugadorTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void testcrearJugador() {
		Jugador jugador = new Jugador();
		Assert.assertNotNull(jugador);
	}
	
	@Test
	public void testObtenerDinero() {
		Jugador jugador = new Jugador();
		Assert.assertEquals(100000, jugador.getDinero(),DELTA);
	}
	
	@Test
	public void testagregarDinero() {
		Jugador jugador = new Jugador();
		Dinero unDinero = new Dinero(20000);
		jugador.agregarDinero(unDinero);
		Assert.assertEquals(120000, jugador.getDinero(),DELTA);
	}
	
	@Test
	public void testsustraerDinero() {
		Jugador jugador = new Jugador();
		Dinero unDinero = new Dinero(20000);
		jugador.sustraerDinero(unDinero);
		Assert.assertEquals(80000, jugador.getDinero(),DELTA);
	}
}
