package modelo.casillas;

import org.junit.Test;

import modelo.casillas.Carcel;
import modelo.casillas.Policia;
import modelo.Jugador;

import org.junit.Assert;

public class PoliciaTest {
	
	@Test
	public void testJugadorCaeEnPoliciaQuedaRetenido(){
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		Policia policia = new Policia(carcel);
		
		policia.esVisitadoPorJugador(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
}
