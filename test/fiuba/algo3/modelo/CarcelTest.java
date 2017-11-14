package fiuba.algo3.modelo;

import org.junit.Test;
import org.junit.Assert;

public class CarcelTest {
	
	//private static final double DELTA = 1e-15;
	@Test
	public void jugadorRetenidoNoPuedeMoverse(){
		Jugador jugador = new Jugador(100000);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
	
	
	@Test
	public void jugadorRetenidoPorCuatroTurnosPuedeMoverse(){
		Jugador jugador = new Jugador(100000);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test
	public void jugadorRetenidoPorDosTurnosYPagaFianza(){
		Jugador jugador = new Jugador(100000);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test
	public void jugadorRetenidoPorTresTurnosYPagaFianza(){
		Jugador jugador = new Jugador(100000);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test
	public void jugadorRetenidoPorDosTurnosConFondosInsuficientesNoPuedeMoverse(){
		Jugador jugador = new Jugador(23999);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
	
	@Test
	public void jugadorRetenidoPorTresTurnosConFondosInsuficientesNoPuedeMoverse(){
		Jugador jugador = new Jugador(23999);
		
		Carcel carcel = new Carcel();
		
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.retenerJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
	
	
}
