package modelo.casillas;

import org.junit.Test;

import modelo.casillas.Carcel;
import modelo.Dinero;
import modelo.Jugador;

import org.junit.Assert;

public class CarcelTest {
	
	@Test
	public void testJugadorRetenidoNoPuedeMoverse(){
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
	
	
	@Test
	public void testJugadorRetenidoPorCuatroTurnosPuedeMoverse(){
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.quedarLibre(jugador);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test
	public void testJugadorRetenidoPorDosTurnosYPagaFianza(){
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test
	public void testJugadorRetenidoPorTresTurnosYPagaFianza(){
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test
	public void testJugadorRetenidoPorDosTurnosConFondosInsuficientesNoPuedeMoverse(){
		Jugador jugador = new Jugador();
		Dinero unDinero = new Dinero(60000);
		jugador.sustraerDinero(unDinero);
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
	
	@Test
	public void testJugadorRetenidoPorTresTurnosConFondosInsuficientesNoPuedeMoverse(){
		Dinero unDinero = new Dinero(60000);
		Jugador jugador = new Jugador();
		jugador.sustraerDinero(unDinero);
				
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
		
	}
}
	
	