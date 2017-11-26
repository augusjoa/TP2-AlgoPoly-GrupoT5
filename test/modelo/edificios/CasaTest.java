package modelo.edificios;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.casillas.Barrio;
import modelo.casillas.BarrioSimple;

public class CasaTest {
	@Test
	public void testAlComprarLaCasaElJugadorEsPropietario() {
		Barrio unaCasa = new BarrioSimple(1000,0, 0 , 0);
		Jugador unJugador = new Jugador();
		
		unJugador.comprar(unaCasa);
		
		Assert.assertEquals(unJugador, unaCasa.getDuenio());
	}
}
