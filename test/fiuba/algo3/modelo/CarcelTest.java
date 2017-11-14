package fiuba.algo3.modelo;

import org.junit.Test;

import casillas.Carcel;

import org.junit.Assert;

public class CarcelTest {
	
	@Test
	public void testJugadorRetenidoNoPuedeMoverse(){
		Jugador jugador = new Jugador(100000);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
	
	
	@Test
	public void testJugadorRetenidoPorCuatroTurnosPuedeMoverse(){
		Jugador jugador = new Jugador(100000);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test
	public void testJugadorRetenidoPorDosTurnosYPagaFianza(){
		Jugador jugador = new Jugador(100000);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test
	public void testJugadorRetenidoPorTresTurnosYPagaFianza(){
		Jugador jugador = new Jugador(100000);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test
	public void testJugadorRetenidoPorDosTurnosConFondosInsuficientesNoPuedeMoverse(){
		Jugador jugador = new Jugador(23999);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
	
	@Test
	public void testJugadorRetenidoPorTresTurnosConFondosInsuficientesNoPuedeMoverse(){
		Jugador jugador = new Jugador(23999);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
	
	
}
