package modelo;
import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;

public class JugadorTest {

	
	@Test
	public void testCrearJugador() {
		Jugador jugador = new Jugador(null);
		Assert.assertNotNull(jugador);
	}
	
	@Test
	public void testObtenerDinero() {
		Jugador jugador = new Jugador(null);
		Assert.assertEquals(100000, jugador.getDinero());
	}
	
	@Test
	public void testAgregarDinero() {
		Jugador jugador = new Jugador(null);
		Dinero unDinero = new Dinero(20000);
		jugador.agregarDinero(unDinero);
		Assert.assertEquals(120000, jugador.getDinero());
	}
	
	@Test
	public void testSustraerDinero() {
		Jugador jugador = new Jugador(null);
		Dinero unDinero = new Dinero(20000);
		jugador.sustraerDinero(unDinero);
		Assert.assertEquals(80000, jugador.getDinero());
	}
	

}
