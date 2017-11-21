package modelo.casillas;
import org.junit.Assert;
import org.junit.Test;

import modelo.casillas.Quini6;
import modelo.Jugador;


public class Quini6Test {
	//private static final double DELTA = 1e-15;
	
	@Test
	public void testCrearQuini6(){
		Quini6 quini6 = new Quini6();
		Assert.assertNotNull(quini6);
	}

	@Test
	public void testJugadorVisitaQuini6unaVez() {
		Quini6 quini6 = new Quini6();
		Jugador unJugador = new Jugador();
		quini6.esVisitadoPorJugador(unJugador);
		Assert.assertEquals(150000, unJugador.getDinero());
	}
	
	@Test
	public void testJugadorVisitaQuini6DosVeces() {
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador();
		quini6.esVisitadoPorJugador(jugador);
		quini6.esVisitadoPorJugador(jugador);
		Assert.assertEquals(180000, jugador.getDinero());
	}
	
	@Test
	public void testJugadorVisitaQuini6TresVeces() {
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador();
		quini6.esVisitadoPorJugador(jugador);
		quini6.esVisitadoPorJugador(jugador);
		quini6.esVisitadoPorJugador(jugador);
		Assert.assertEquals(180000, jugador.getDinero());
	}
	
}
