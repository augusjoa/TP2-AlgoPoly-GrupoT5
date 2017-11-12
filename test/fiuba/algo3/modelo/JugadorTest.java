package fiuba.algo3.modelo;
import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void testcrearJugador() {
		Jugador jugador = new Jugador(100000);
		Assert.assertNotNull(jugador);
	}
	
	@Test
	public void testObtenerDinero() {
		Jugador jugador = new Jugador(100000);
		Assert.assertEquals(100000, jugador.getDinero(),DELTA);
	}
	
	@Test
	public void testagregarDinero() {
		Jugador jugador = new Jugador(100000);
		jugador.agregarDinero(20000);
		Assert.assertEquals(120000, jugador.getDinero(),DELTA);
	}
	
	@Test
	public void testsustraerDinero() {
		Jugador jugador = new Jugador(100000);
		jugador.sustraerDinero(20000);
		Assert.assertEquals(80000, jugador.getDinero(),DELTA);
	}
}
