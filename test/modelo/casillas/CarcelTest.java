package modelo.casillas;

import org.junit.Test;

import modelo.casillas.Carcel;
import modelo.excepciones.DineroInsuficiente;
import modelo.excepciones.JugadorNoPuedePagarFianza;
import modelo.Dinero;
import modelo.Jugador;

import org.junit.Assert;

public class CarcelTest {
	
	@Test
	public void testJugadorRetenidoNoPuedeMoverse(){
		Jugador jugador = new Jugador(0);
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		
		Assert.assertEquals(false, jugador.puedeMoverse());
	}
	
	@Test
	public void testJugadorDebenPasarCuatroTurnos(){
		Jugador jugador = new Jugador(0);
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		
		Assert.assertEquals(4, jugador.getTurnosRestantes());
	}
	
	
	@Test
	public void testJugadorRetenidoPorCuatroTurnosPuedeMoverse(){
		Jugador jugador = new Jugador(0);
		
		
		Carcel carcel = new Carcel();
		
		
		
		carcel.esVisitadoPorJugador(jugador);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test
	public void testJugadorRetenidoPorDosTurnosYPagaFianza(){
		Jugador jugador = new Jugador(0);
		
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.pagarFianza(carcel);
		
		Assert.assertEquals(true, jugador.puedeMoverse());
		
	}
	
	@Test
	public void testJugadorRetenidoPorTresTurnosYPagaFianza(){
		Jugador jugador = new Jugador(0);
		
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagarFianza(carcel);
		Assert.assertEquals(true, jugador.puedeMoverse());
	}
	
	@Test(expected = DineroInsuficiente.class)
	public void testJugadorRetenidoPorDosTurnosConFondosInsuficientesNoPuedePagarFianza(){
		Jugador jugador = new Jugador(0);
		Dinero unDinero = new Dinero(60000);
		jugador.sustraerDinero(unDinero);
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.pagarFianza(carcel);
	}
	@Test(expected = DineroInsuficiente.class)
	public void testJugadorRetenidoPorTresTurnosConFondosInsuficientesNoPuedeMoverse(){
		Dinero unDinero = new Dinero(60000);
		Jugador jugador = new Jugador(0);
		jugador.sustraerDinero(unDinero);
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.pagarFianza(carcel);
	}
	
	@Test(expected = JugadorNoPuedePagarFianza.class)
	public void testJugadorCaeEnCarcelNoPuedePagarFianza() {
		Jugador jugador = new Jugador(0);
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		jugador.pagarFianza(carcel);
	}
	
	@Test(expected = JugadorNoPuedePagarFianza.class)
	public void testJugadorCaeEnCarcelPasaUnTurnoNoPuedePagarFianza() {
		Jugador jugador = new Jugador(0);
		Carcel carcel = new Carcel();
		
		carcel.esVisitadoPorJugador(jugador);
		jugador.iniciarTurno();
		jugador.pagarFianza(carcel);
	}
}
	
	