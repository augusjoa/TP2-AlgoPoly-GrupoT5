package modelo.casillas;

import org.junit.Test;

import modelo.casillas.Carcel;
import modelo.casillas.Policia;
import modelo.Jugador;

import org.junit.Assert;

public class PoliciaTest {

//	@Test
//	public void testJugadorCaeEnPoliciaSeEncuentraEnLaCarcel(){
//		Jugador jugador = new Jugador();
//		
//		Carcel carcel = new Carcel();
//		
//		Policia policia = new Policia();
//		
//		jugador.moverse(10);
//		
//		policia.moverALaCarcel(jugador, carcel);
//		
//		Assert.assertEquals(5,jugador.getPosicion());
//	}
	
	@Test
	public void testJugadorCaeEnPoliciaQuedaRetenido(){
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		Policia policia = new Policia();
		
		jugador.moverse(10);
		
		policia.moverALaCarcel(jugador, carcel);
		
		carcel.retenerJugador(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
}
