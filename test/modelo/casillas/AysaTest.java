package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
import modelo.Jugador;

public class AysaTest {
	
	@Test
	public void unJugadorEsDuenioDobleSiAdquiereAysaYEdesur(){
		
		Jugador jugador = new Jugador(0);
		Compania aysa = new Aysa();
		Compania edesur = new Edesur();
		aysa.comprar(jugador);
		edesur.comprar(jugador);
		
		aysa.setOtraCompania(edesur);
		
		Assert.assertTrue(aysa.tieneDuenioDoble());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnAysa(){
		
		Jugador jugadorDuenio = new Jugador(0);
		Compania aysa = new Aysa();
		aysa.comprar(jugadorDuenio);		
		Jugador jugador = new Jugador(1);
		Dinero dineroInicial = new Dinero(jugador.getDinero());
		jugador.tirarDados();
		aysa.esVisitadoPorJugador(jugador);
		
		
		dineroInicial.sustraerDinero(jugador.getDinero());
		Assert.assertEquals(300*jugador.getNumeroDelDado(), dineroInicial.getValor());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnAysaConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador(0);
		Compania aysa = new Aysa();
		Compania edesur = new Edesur();
		aysa.setOtraCompania(edesur);		
		
		aysa.comprar(jugadorDuenio);
		edesur.comprar(jugadorDuenio);
		
		Jugador jugador = new Jugador(1);
		Dinero dineroInicial = new Dinero(jugador.getDinero());
		jugador.tirarDados();
		aysa.esVisitadoPorJugador(jugador);
		
		
		dineroInicial.sustraerDinero(jugador.getDinero());
		Assert.assertEquals(500*jugador.getNumeroDelDado(), dineroInicial.getValor());
	}
}
