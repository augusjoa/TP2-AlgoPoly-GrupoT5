package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
import modelo.Jugador;

public class EdesurTest {
	@Test
	public void unJugadorEsDuenioDobleSiAdquiereEdesurYAysa(){
		
		Jugador jugador = new Jugador();
		Aysa aysa = new Aysa();
		Edesur edesur = new Edesur();
		
		jugador.comprar(aysa);
		jugador.comprar(edesur);
		
		edesur.conoceAAysa(aysa);
		
		Assert.assertTrue(edesur.tieneDuenioDoble());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnEdesur(){
		Jugador jugadorDuenio = new Jugador();
		Edesur edesur = new Edesur();
		jugadorDuenio.comprar(edesur);
		
		Jugador jugador = new Jugador();
		Dinero dineroInicial = new Dinero(jugador.getDinero());
		jugador.tirarDados();
		edesur.esVisitadoPorJugador(jugador);
		
		
		dineroInicial.sustraerDinero(jugador.getDinero());
		Assert.assertEquals(500*jugador.getNumeroDelDado(), dineroInicial._getValor());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnEdesurConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador();
		Aysa aysa = new Aysa();
		Edesur edesur = new Edesur();
		edesur.conoceAAysa(aysa);		
		
		jugadorDuenio.comprar(aysa);
		jugadorDuenio.comprar(edesur);
		
		Jugador jugador = new Jugador();
		Dinero dineroInicial = new Dinero(jugador.getDinero());
		jugador.tirarDados();
		edesur.esVisitadoPorJugador(jugador);
		
		
		dineroInicial.sustraerDinero(jugador.getDinero());
		Assert.assertEquals(1000*jugador.getNumeroDelDado(), dineroInicial._getValor());
	}
}