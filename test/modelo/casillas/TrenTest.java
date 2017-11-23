package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
import modelo.Jugador;

public class TrenTest {

	@Test
	public void unJugadorEsDuenioDobleSiAdquiereTrenYSubte(){
		
		Jugador jugador = new Jugador();
		Subte subte = new Subte();
		Tren tren = new Tren();
		
		jugador.comprar(subte);
		jugador.comprar(tren);
		
		subte.conoceATren(tren);
		
		Assert.assertTrue(subte.tieneDuenioDoble());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnTren(){
		Jugador jugadorDuenio = new Jugador();
		Tren tren = new Tren();
		jugadorDuenio.comprar(tren);
		
		Jugador jugadorNoDuenio = new Jugador();
		Dinero dineroInicial = new Dinero(jugadorNoDuenio.getDinero());
		jugadorNoDuenio.tirarDados();
		tren.esVisitadoPorJugador(jugadorNoDuenio);
		
		
		dineroInicial.sustraerDinero(jugadorNoDuenio.getDinero());
		Assert.assertEquals(450*jugadorNoDuenio.getNumeroDelDado(), dineroInicial._getValor());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnTrenConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador();
		Subte subte = new Subte();
		Tren tren = new Tren();
		tren.conoceASubte(subte);
		
		jugadorDuenio.comprar(subte);
		jugadorDuenio.comprar(tren);
		
		Jugador jugadorNoDuenio = new Jugador();
		Dinero dineroInicial = new Dinero(jugadorNoDuenio.getDinero());
		jugadorNoDuenio.tirarDados();
		tren.esVisitadoPorJugador(jugadorNoDuenio);
		
		
		dineroInicial.sustraerDinero(jugadorNoDuenio.getDinero());
		Assert.assertEquals(800*jugadorNoDuenio.getNumeroDelDado(), dineroInicial._getValor());
	}
}
