package modelo.casillas;
import org.junit.Assert;
import org.junit.Test;

import modelo.casillas.Quini6;
import modelo.Dinero;
import modelo.Jugador;


public class Quini6Test {
	private static final int DINEROINICIAL = 100000;
	
	@Test
	public void testCrearQuini6(){
		Quini6 quini6 = new Quini6();
		Assert.assertNotNull(quini6);
	}

	@Test
	public void testJugadorVisitaQuini6unaVez() {
		Quini6 quini6 = new Quini6();
		Jugador unJugador = new Jugador();
		Dinero dineroFinal = new Dinero (DINEROINICIAL + 50000);
		quini6.esVisitadoPorJugador(unJugador);
		Assert.assertEquals(dineroFinal, unJugador.getDinero());
	}
	
	@Test
	public void testJugadorVisitaQuini6DosVeces() {
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador();
		Dinero dineroFinal = new Dinero (DINEROINICIAL + 50000 + 30000);
		quini6.esVisitadoPorJugador(jugador);
		quini6.esVisitadoPorJugador(jugador);
		Assert.assertEquals(dineroFinal, jugador.getDinero());
	}
	
	@Test
	public void testJugadorVisitaQuini6TresVeces() {
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador();
		Dinero dineroFinal = new Dinero (DINEROINICIAL + 50000 + 30000 + 0);
		quini6.esVisitadoPorJugador(jugador);
		quini6.esVisitadoPorJugador(jugador);
		quini6.esVisitadoPorJugador(jugador);
		Assert.assertEquals(dineroFinal, jugador.getDinero());
	}
	
}
