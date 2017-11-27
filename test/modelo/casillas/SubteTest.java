package modelo.casillas;


import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
import modelo.Jugador;

public class SubteTest {
	private static final int DINEROINICIAL = 100000;
	
	@Test
	public void unJugadorEsDuenioDobleSiAdquiereSubteYTren(){
		
		Jugador jugador = new Jugador(null);
		Compania subte = new Subte();
		Compania tren = new Tren();
		
		jugador.comprar(subte);
		jugador.comprar(tren);
		
		subte.setOtraCompania(tren);
		
		Assert.assertTrue(subte.tieneDuenioDoble());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnSubte(){
		Jugador jugadorDuenio = new Jugador(null);
		Compania subte = new Subte();
		jugadorDuenio.comprar(subte);
		
		Jugador jugadorNoDuenio = new Jugador(null);
		jugadorNoDuenio.tirarDados();
		Dinero dineroFinal = new Dinero(DINEROINICIAL - jugadorNoDuenio.getNumeroDelDado() * 600);
		subte.esVisitadoPorJugador(jugadorNoDuenio);
		
		Assert.assertEquals(dineroFinal, jugadorNoDuenio.getDinero());
	}
	
	@Test
	public void unJugadorQueNoEsDuenioCaeEnSubteConDuenioDoble(){
		Jugador jugadorDuenio = new Jugador(null);
		Compania subte = new Subte();
		Compania tren = new Tren();
		subte.setOtraCompania(tren);
		
		
		jugadorDuenio.comprar(subte);
		jugadorDuenio.comprar(tren);
		
		Jugador jugadorNoDuenio = new Jugador(null);
		jugadorNoDuenio.tirarDados();
		Dinero dineroFinal = new Dinero(DINEROINICIAL - jugadorNoDuenio.getNumeroDelDado() * 1100);
		subte.esVisitadoPorJugador(jugadorNoDuenio);
		
		Assert.assertEquals(dineroFinal, jugadorNoDuenio.getDinero());
	}
}
