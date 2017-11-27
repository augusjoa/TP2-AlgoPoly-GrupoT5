package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
import modelo.Jugador;

public class AysaTest {
	
	@Test
	public void unJugadorEsDuenioDobleSiAdquiereAysaYEdesur(){
		
		Jugador jugador = new Jugador(null);
		Compania aysa = new Aysa();
		Compania edesur = new Edesur();
		
		jugador.comprar(aysa);
		jugador.comprar(edesur);
		
		aysa.setOtraCompania(edesur);
		
		Assert.assertTrue(aysa.tieneDuenioDoble());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnAysa(){
		
		Jugador jugadorDuenio = new Jugador(null);
		Compania aysa = new Aysa();
		jugadorDuenio.comprar(aysa);
		
		Jugador jugador = new Jugador(null);
		Dinero dineroInicial = new Dinero(jugador.getDinero());
		jugador.tirarDados();
		aysa.esVisitadoPorJugador(jugador);
		
		
		dineroInicial.sustraerDinero(jugador.getDinero());
		Assert.assertEquals(300*jugador.getNumeroDelDado(), dineroInicial._getValor());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnAysaConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador(null);
		Compania aysa = new Aysa();
		Compania edesur = new Edesur();
		aysa.setOtraCompania(edesur);		
		
		jugadorDuenio.comprar(aysa);
		jugadorDuenio.comprar(edesur);
		
		Jugador jugador = new Jugador(null);
		Dinero dineroInicial = new Dinero(jugador.getDinero());
		jugador.tirarDados();
		aysa.esVisitadoPorJugador(jugador);
		
		
		dineroInicial.sustraerDinero(jugador.getDinero());
		Assert.assertEquals(500*jugador.getNumeroDelDado(), dineroInicial._getValor());
	}
}
