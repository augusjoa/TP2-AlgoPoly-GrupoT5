package modelo;
import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;

public class JugadorTest {
	private static final int DINEROINICIAL = 100000;
	
	@Test
	public void testCrearJugador() {
		Jugador jugador = new Jugador(null);
		Assert.assertNotNull(jugador);
	}
	
	@Test
	public void testObtenerDinero() {
<<<<<<< HEAD
		Jugador jugador = new Jugador(null);
		Assert.assertEquals(100000, jugador.getDinero());
=======
		Jugador jugador = new Jugador();
		
		Assert.assertNotNull(jugador.getDinero());
>>>>>>> f1bef4b7c00659efe7b7bfdd9e63ee706f919e53
	}
	
	@Test
	public void testAgregarDinero() {
<<<<<<< HEAD
		Jugador jugador = new Jugador(null);
		Dinero unDinero = new Dinero(20000);
		jugador.agregarDinero(unDinero);
		Assert.assertEquals(120000, jugador.getDinero());
=======
		Jugador jugador = new Jugador();
		int valorAgregado = 20000;
		Dinero dineroFinal = new Dinero(DINEROINICIAL + valorAgregado);
		jugador.agregarDinero(new Dinero(valorAgregado));
		Assert.assertEquals(dineroFinal, jugador.getDinero());
>>>>>>> f1bef4b7c00659efe7b7bfdd9e63ee706f919e53
	}
	
	@Test
	public void testSustraerDinero() {
<<<<<<< HEAD
		Jugador jugador = new Jugador(null);
		Dinero unDinero = new Dinero(20000);
		jugador.sustraerDinero(unDinero);
		Assert.assertEquals(80000, jugador.getDinero());
=======
		Jugador jugador = new Jugador();
		int valorSustraido = 20000;
		Dinero dineroFinal = new Dinero(DINEROINICIAL - valorSustraido);
		jugador.sustraerDinero(new Dinero(valorSustraido));
		Assert.assertEquals(dineroFinal, jugador.getDinero());
>>>>>>> f1bef4b7c00659efe7b7bfdd9e63ee706f919e53
	}
	

}
