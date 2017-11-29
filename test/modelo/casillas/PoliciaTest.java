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
		Policia policia = new Policia();
		
		policia.esVisitadoPorJugador(jugador);
		
		Assert.assertFalse(jugador.puedeMoverse());
	}
}
