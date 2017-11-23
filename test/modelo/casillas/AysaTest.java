package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;

public class AysaTest {
	
	@Test
	public void unJugadorEsDuenioDobleSiAdquiereAysaYEdesur(){
		
		Jugador jugador = new Jugador();
		Aysa aysa = new Aysa();
		Edesur edesur = new Edesur();
		
		jugador.comprar(aysa);
		jugador.comprar(edesur);
		
		aysa.conoceAEdesur(edesur);
		
		Assert.assertTrue(aysa.tieneDuenioDoble());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnAysa(){
		Jugador jugadorDuenio = new Jugador();
		Aysa aysa = new Aysa();
		jugadorDuenio.comprar(aysa);
		
		Jugador jugador = new Jugador();
		int dineroInicial = jugador.getDinero();
		jugador.tirarDados();
		aysa.esVisitadoPorJugador(jugador);
		
		
		
		Assert.assertEquals(300*jugador.getNumeroDelDado(), dineroInicial-jugador.getDinero());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnAysaConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador();
		Aysa aysa = new Aysa();
		Edesur edesur = new Edesur();
		aysa.conoceAEdesur(edesur);		
		
		jugadorDuenio.comprar(aysa);
		jugadorDuenio.comprar(edesur);
		
		Jugador jugador = new Jugador();
		int dineroInicial = jugador.getDinero();
		jugador.tirarDados();
		aysa.esVisitadoPorJugador(jugador);
		
		
		
		Assert.assertEquals(500*jugador.getNumeroDelDado(), dineroInicial-jugador.getDinero());
	}
}
