package modelo.casillas;


import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
import modelo.Jugador;

public class SubteTest {

	@Test
	public void unJugadorEsDuenioDobleSiAdquiereSubteYTren(){
		
		Jugador jugador = new Jugador();
		Compania subte = new Subte();
		Compania tren = new Tren();
		
		jugador.comprar(subte);
		jugador.comprar(tren);
		
		subte.setOtraCompania(tren);
		
		Assert.assertTrue(subte.tieneDuenioDoble());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnSubte(){
		Jugador jugadorDuenio = new Jugador();
		Compania subte = new Subte();
		jugadorDuenio.comprar(subte);
		
		Jugador jugadorNoDuenio = new Jugador();
		Dinero dineroInicial = new Dinero(jugadorNoDuenio.getDinero());
		jugadorNoDuenio.tirarDados();
		subte.esVisitadoPorJugador(jugadorNoDuenio);
		
		
		dineroInicial.sustraerDinero(jugadorNoDuenio.getDinero());
		Assert.assertEquals(600*jugadorNoDuenio.getNumeroDelDado(), dineroInicial._getValor());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnSubteConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador();
		Compania subte = new Subte();
		Compania tren = new Tren();
		subte.setOtraCompania(tren);
		
		
		jugadorDuenio.comprar(subte);
		jugadorDuenio.comprar(tren);
		
		Jugador jugadorNoDuenio = new Jugador();
		Dinero dineroInicial = new Dinero(jugadorNoDuenio.getDinero());
		jugadorNoDuenio.tirarDados();
		subte.esVisitadoPorJugador(jugadorNoDuenio);
		
		dineroInicial.sustraerDinero(jugadorNoDuenio.getDinero());
		Assert.assertEquals(1100*jugadorNoDuenio.getNumeroDelDado(), dineroInicial._getValor());
	}
}
