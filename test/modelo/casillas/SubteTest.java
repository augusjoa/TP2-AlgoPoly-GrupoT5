package modelo.casillas;


import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
import modelo.Jugador;

public class SubteTest {
	private static final int DINEROINICIAL = 100000;
	
	@Test
	public void unJugadorEsDuenioDobleSiAdquiereSubteYTren(){
		
		Jugador jugador = new Jugador(0);
		Compania subte = new Subte();
		Compania tren = new Tren();
		
		subte.comprar(jugador);
		tren.comprar(jugador);
		
		subte.setOtraCompania(tren);
		
		Assert.assertTrue(subte.tieneDuenioDoble());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnSubte(){
		Jugador jugadorDuenio = new Jugador(0);
		Compania subte = new Subte();
		subte.comprar(jugadorDuenio);
		
		Jugador jugadorNoDuenio = new Jugador(1);
		jugadorNoDuenio.tirarDados();
		Dinero dineroFinal = new Dinero(DINEROINICIAL - jugadorNoDuenio.getNumeroDelDado() * 600);
		subte.esVisitadoPorJugador(jugadorNoDuenio);
		
		Assert.assertEquals(dineroFinal, jugadorNoDuenio.getDinero());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnSubteConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador(0);
		Compania subte = new Subte();
		Compania tren = new Tren();
		subte.setOtraCompania(tren);
		
		
		subte.comprar(jugadorDuenio);
		tren.comprar(jugadorDuenio);
		
		Jugador jugadorNoDuenio = new Jugador(1);
		jugadorNoDuenio.tirarDados();
		Dinero dineroFinal = new Dinero(DINEROINICIAL - jugadorNoDuenio.getNumeroDelDado() * 1100);
		subte.esVisitadoPorJugador(jugadorNoDuenio);
		
		Assert.assertEquals(dineroFinal, jugadorNoDuenio.getDinero());
	}
}
