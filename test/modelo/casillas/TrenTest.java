package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
import modelo.Jugador;

public class TrenTest {

	@Test
	public void unJugadorEsDuenioDobleSiAdquiereTrenYSubte(){
		
		Jugador jugador = new Jugador(0);
		Compania subte = new Subte();
		Compania tren = new Tren();
		
		subte.comprar(jugador);
		tren.comprar(jugador);
		
		subte.setOtraCompania(tren);
		
		Assert.assertTrue(subte.tieneDuenioDoble());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnTren(){
		Jugador jugadorDuenio = new Jugador(0);
		Compania tren = new Tren();
		tren.comprar(jugadorDuenio);
		
		Jugador jugadorNoDuenio = new Jugador(1);
		Dinero dineroInicial = new Dinero(jugadorNoDuenio.getDinero());
		jugadorNoDuenio.tirarDados();
		tren.esVisitadoPorJugador(jugadorNoDuenio);
		
		
		dineroInicial.sustraerDinero(jugadorNoDuenio.getDinero());
		Assert.assertEquals(450*jugadorNoDuenio.getNumeroDelDado(), dineroInicial.getValor());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnTrenConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador(0);
		Compania subte = new Subte();
		Compania tren = new Tren();
		tren.setOtraCompania(subte);
		
		subte.comprar(jugadorDuenio);
		tren.comprar(jugadorDuenio);
		
		Jugador jugadorNoDuenio = new Jugador(1);
		Dinero dineroInicial = new Dinero(jugadorNoDuenio.getDinero());
		jugadorNoDuenio.tirarDados();
		tren.esVisitadoPorJugador(jugadorNoDuenio);
		
		
		dineroInicial.sustraerDinero(jugadorNoDuenio.getDinero());
		Assert.assertEquals(800*jugadorNoDuenio.getNumeroDelDado(), dineroInicial.getValor());
	}
}
