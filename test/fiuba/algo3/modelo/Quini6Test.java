package fiuba.algo3.modelo;
import org.junit.Assert;
import org.junit.Test;


public class Quini6Test {
	private static final double DELTA = 1e-15;
	
	@Test
	public void testCrearQuini6(){
		Quini6 quini6 = new Quini6();
		Assert.assertNotNull(quini6);
	}

	@Test
	public void testJugadorVisitaQuini6unaVez() {
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador(100000);
		quini6.obtenerPremio(jugador);
		Assert.assertEquals(150000, jugador.getDinero(), DELTA);
	}
	
	@Test
	public void testJugadorVisitaQuini6DosVeces() {
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador(100000);
		quini6.obtenerPremio(jugador);
		quini6.obtenerPremio(jugador);
		Assert.assertEquals(180000, jugador.getDinero(), DELTA);
	}
	
	@Test
	public void testJugadorVisitaQuini6TresVeces() {
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador(100000);
		quini6.obtenerPremio(jugador);
		quini6.obtenerPremio(jugador);
		quini6.obtenerPremio(jugador);
		Assert.assertEquals(180000, jugador.getDinero(), DELTA);
	}
	
}
