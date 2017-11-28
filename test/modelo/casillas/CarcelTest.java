package modelo.casillas;

/*import org.junit.Test;

import modelo.casillas.Carcel;
import modelo.excepciones.DineroInsuficiente;
import modelo.Dinero;
import modelo.Jugador;

import org.junit.Assert;*/

public class CarcelTest {
	
	/*//@Test
	public void testJugadorRetenidoNoPuedeMoverse(){
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
	
	
	//@Test
	public void testJugadorRetenidoPorCuatroTurnosPuedeMoverse(){
		Jugador jugador = new Jugador();
		
		//AlgoPoly algoPoly = new AlgoPoly()
		
		Carcel carcel = new Carcel();
		
		//algoPoly.addEscuchadorTurnos(carcel);
		
		carcel.esVisitadoPorJugador(jugador);

		//algoPoly.pasarTurno()
		//algoPoly.pasarTurno()
		//algoPoly.pasarTurno()
		//algoPoly.pasarTurno()
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	//@Test
	public void testJugadorRetenidoPorDosTurnosYPagaFianza(){
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		carcel.esVisitadoPorJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	//@Test
	public void testJugadorRetenidoPorTresTurnosYPagaFianza(){
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		carcel.esVisitadoPorJugador(jugador);
		carcel.esVisitadoPorJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test(expected=DineroInsuficiente.class)
	public void testJugadorRetenidoPorDosTurnosConFondosInsuficientesNoPuedePagarFianza(){
		Jugador jugador = new Jugador();
		Dinero unDinero = new Dinero(60000);
		jugador.sustraerDinero(unDinero);
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		carcel.esVisitadoPorJugador(jugador);
		carcel.pagarFianza(jugador);
		
		//Assert.assertEquals(false, jugador.puedeMoverse());
	}
	
	//@Test
	public void testJugadorRetenidoPorTresTurnosConFondosInsuficientesNoPuedeMoverse(){
		Dinero unDinero = new Dinero(60000);
		Jugador jugador = new Jugador();
		jugador.sustraerDinero(unDinero);
				
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		carcel.esVisitadoPorJugador(jugador);
		carcel.esVisitadoPorJugador(jugador);
		carcel.pagarFianza(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
		
	}*/
}
	
	