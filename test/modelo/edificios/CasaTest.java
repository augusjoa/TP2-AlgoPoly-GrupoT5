package modelo.edificios;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.casillas.Barrio;

public class CasaTest {
	@Test
	public void testAlComprarLaCasaElJugadorEsPropietario() {
		Barrio unaCasa = new Barrio(1000);
		Jugador unJugador = new Jugador();
		
		unJugador.comprar(unaCasa);
		
		Assert.assertEquals(unJugador, unaCasa.getDuenio());
	}
}
