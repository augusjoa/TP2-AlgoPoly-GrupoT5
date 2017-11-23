package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

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
		
		Jugador jugador = new Jugador();
		int dineroInicial = jugador.getDinero();
		jugador.tirarDados();
		tren.esVisitadoPorJugador(jugador);
		
		
		
		Assert.assertEquals(450*jugador.getNumeroDelDado(), dineroInicial-jugador.getDinero());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnTrenConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador();
		Subte subte = new Subte();
		Tren tren = new Tren();
		tren.conoceASubte(subte);
		
		jugadorDuenio.comprar(subte);
		jugadorDuenio.comprar(tren);
		
		Jugador jugador = new Jugador();
		int dineroInicial = jugador.getDinero();
		jugador.tirarDados();
		tren.esVisitadoPorJugador(jugador);
		
		
		
		Assert.assertEquals(800*jugador.getNumeroDelDado(), dineroInicial-jugador.getDinero());
	}
}
