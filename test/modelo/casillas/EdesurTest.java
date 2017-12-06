package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
import modelo.Jugador;

public class EdesurTest {
	@Test
	public void unJugadorEsDuenioDobleSiAdquiereEdesurYAysa(){
		
		Jugador jugador = new Jugador(0);
		Compania aysa = new Aysa();
		Compania edesur = new Edesur();
		
		aysa.comprar(jugador);
		edesur.comprar(jugador);
		
		edesur.setOtraCompania(aysa);
		
		Assert.assertTrue(edesur.tieneDuenioDoble());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnEdesur(){
		Jugador jugadorDuenio = new Jugador(0);
		Compania edesur = new Edesur();
		edesur.comprar(jugadorDuenio);
		
		Jugador jugador = new Jugador(1);
		Dinero dineroInicial = new Dinero(jugador.getDinero());
		jugador.tirarDados();
		edesur.esVisitadoPorJugador(jugador);
		
		
		dineroInicial.sustraerDinero(jugador.getDinero());
		Assert.assertEquals(500*jugador.getNumeroDelDado(), dineroInicial.getValor());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnEdesurConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador(0);
		Compania aysa = new Aysa();
		Compania edesur = new Edesur();
		edesur.setOtraCompania(aysa);		
		aysa.comprar(jugadorDuenio);
		edesur.comprar(jugadorDuenio);
		
		Jugador jugador = new Jugador(1);
		Dinero dineroInicial = new Dinero(jugador.getDinero());
		jugador.tirarDados();
		edesur.esVisitadoPorJugador(jugador);
		
		
		dineroInicial.sustraerDinero(jugador.getDinero());
		Assert.assertEquals(1000*jugador.getNumeroDelDado(), dineroInicial.getValor());
	}
}