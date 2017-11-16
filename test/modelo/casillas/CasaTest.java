package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;

public class CasaTest {
	@Test
	public void testAlComprarLaCasaElJugadorEsPropietario() {
		Barrio unaCasa = new Barrio(1000);
		Jugador unJugador = new Jugador(100000);
		
		unJugador.comprar(unaCasa);
		
		Assert.assertTrue(unJugador.esDuenio(unaCasa));
	}
}
