package modelo.casillas;


import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;

public class SubteTest {

	@Test
	public void unJugadorEsDuenioDobleSiAdquiereSubteYTren(){
		
		Jugador jugador = new Jugador();
		Subte subte = new Subte();
		Tren tren = new Tren();
		
		jugador.comprar(subte);
		jugador.comprar(tren);
		
		subte.conoceATren(tren);
		
		Assert.assertTrue(subte.tieneDuenioDoble());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnSubte(){
		Jugador jugadorDuenio = new Jugador();
		Subte subte = new Subte();
		jugadorDuenio.comprar(subte);
		
		Jugador jugador = new Jugador();
		int dineroInicial = jugador.getDinero();
		jugador.tirarDados();
		subte.esVisitadoPorJugador(jugador);
		
		
		
		Assert.assertEquals(600*jugador.getNumeroDelDado(), dineroInicial-jugador.getDinero());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnSubteConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador();
		Subte subte = new Subte();
		Tren tren = new Tren();
		subte.conoceATren(tren);
		
		
		
		jugadorDuenio.comprar(subte);
		jugadorDuenio.comprar(tren);
		
		Jugador jugador = new Jugador();
		int dineroInicial = jugador.getDinero();
		jugador.tirarDados();
		subte.esVisitadoPorJugador(jugador);
		
		
		
		Assert.assertEquals(1100*jugador.getNumeroDelDado(), dineroInicial-jugador.getDinero());
	}
}
