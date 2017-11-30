package modelo;
import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;

public class JugadorTest {
	private static final int DINEROINICIAL = 100000;
	
	@Test
	public void testCrearJugador() {
		Jugador jugador = new Jugador(0);
		Assert.assertNotNull(jugador);
	}
	
	@Test
	public void testObtenerDinero() {

		Jugador jugador = new Jugador(0);	
		Assert.assertNotNull(jugador.getDinero());
	}
	
	@Test
	public void testAgregarDinero() {

		Jugador jugador = new Jugador(0);
		int valorAgregado = 20000;
		Dinero dineroFinal = new Dinero(DINEROINICIAL + valorAgregado);
		jugador.agregarDinero(new Dinero(valorAgregado));
		Assert.assertEquals(dineroFinal, jugador.getDinero());
	}
	
	@Test
	public void testSustraerDinero() {

		Jugador jugador = new Jugador(0);
		int valorSustraido = 20000;
		Dinero dineroFinal = new Dinero(DINEROINICIAL - valorSustraido);
		jugador.sustraerDinero(new Dinero(valorSustraido));
		Assert.assertEquals(dineroFinal, jugador.getDinero());
	}
	

}
