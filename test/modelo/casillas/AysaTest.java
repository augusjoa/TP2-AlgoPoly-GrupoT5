package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
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
		Dinero dineroInicial = new Dinero(jugador.getDinero());
		jugador.tirarDados();
		aysa.esVisitadoPorJugador(jugador);
		
		
		dineroInicial.sustraerDinero(jugador.getDinero());
		Assert.assertEquals(300*jugador.getNumeroDelDado(), dineroInicial._getValor());
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
		Dinero dineroInicial = new Dinero(jugador.getDinero());
		jugador.tirarDados();
		aysa.esVisitadoPorJugador(jugador);
		
		
		dineroInicial.sustraerDinero(jugador.getDinero());
		Assert.assertEquals(500*jugador.getNumeroDelDado(), dineroInicial._getValor());
	}
}