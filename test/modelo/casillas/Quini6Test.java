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
<<<<<<< HEAD
		Jugador unJugador = new Jugador(null);
=======
		Jugador unJugador = new Jugador();
		Dinero dineroFinal = new Dinero (DINEROINICIAL + 50000);
>>>>>>> f1bef4b7c00659efe7b7bfdd9e63ee706f919e53
		quini6.esVisitadoPorJugador(unJugador);
		Assert.assertEquals(dineroFinal, unJugador.getDinero());
	}
	
	@Test
	public void testJugadorVisitaQuini6DosVeces() {
		Quini6 quini6 = new Quini6();
<<<<<<< HEAD
		Jugador jugador = new Jugador(null);
=======
		Jugador jugador = new Jugador();
		Dinero dineroFinal = new Dinero (DINEROINICIAL + 50000 + 30000);
>>>>>>> f1bef4b7c00659efe7b7bfdd9e63ee706f919e53
		quini6.esVisitadoPorJugador(jugador);
		quini6.esVisitadoPorJugador(jugador);
		Assert.assertEquals(dineroFinal, jugador.getDinero());
	}
	
	@Test
	public void testJugadorVisitaQuini6TresVeces() {
		Quini6 quini6 = new Quini6();
<<<<<<< HEAD
		Jugador jugador = new Jugador(null);
=======
		Jugador jugador = new Jugador();
		Dinero dineroFinal = new Dinero (DINEROINICIAL + 50000 + 30000 + 0);
>>>>>>> f1bef4b7c00659efe7b7bfdd9e63ee706f919e53
		quini6.esVisitadoPorJugador(jugador);
		quini6.esVisitadoPorJugador(jugador);
		quini6.esVisitadoPorJugador(jugador);
		Assert.assertEquals(dineroFinal, jugador.getDinero());
	}
	
}
