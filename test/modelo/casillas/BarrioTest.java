package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillas.Barrio;
import modelo.excepciones.NoEsDuenioDeLosDosTerrenos;
import modelo.excepciones.BarrioLleno;
import modelo.excepciones.JugadorInvalido;
import modelo.Dinero;
import modelo.Jugador;

public class BarrioTest {
	
	@Test
	public void testElBarrioTieneDuenioAlSerCompradoPorUnJugador() {
		BarrioFactory fabrica = new BarrioFactory();
		Barrio unBarrio = fabrica.crearNeuquen();
		Jugador unJugador = new Jugador();
		
		unJugador.comprar(unBarrio);
		
		Assert.assertEquals(unJugador, unBarrio.getDuenio());
	}
	
	@Test
	public void testElBarrioNoTieneDuenioAlSerVendido() {
		BarrioFactory fabrica = new BarrioFactory();
		Barrio unBarrio = fabrica.crearTucuman();
		Jugador unJugador = new Jugador();
		
		unJugador.comprar(unBarrio);
		unJugador.vender(unBarrio);
		
		Assert.assertNull(unBarrio.getDuenio());
	}
	
	@Test
	public void testBarrioSantaFeEsCompradoPOrJugadorYagregaunaCasa() {
		BarrioFactory fabrica = new BarrioFactory();
		Barrio unBarrio = fabrica.crearSantaFe();
		Jugador unJugador = new Jugador();
		

		unJugador.setCasillaActual(unBarrio);
		
		
		unJugador.comprar(unBarrio);
		unJugador.agregarCasa(unBarrio);
		
		Assert.assertEquals(1, unBarrio.getCantidadDeEdificios());
	}
	
	@Test(expected = BarrioLleno.class)
	public void testBarrioNeuquenEsCompradoYNoPuedeConstruirMasDeUnaCasa() {
		BarrioFactory fabrica = new BarrioFactory();
		Barrio unBarrio = fabrica.crearNeuquen();
		Jugador unJugador = new Jugador();
		
		unJugador.setCasillaActual(unBarrio);
		
		unJugador.comprar(unBarrio);
		unJugador.agregarCasa(unBarrio);
		unJugador.agregarCasa(unBarrio);
	}
	
	@Test
	public void testBarrioBuenosAiresEsCompradoEnSuTotalidadPorJugadorConstruyeHotelEnCadaUno() {
		BarrioFactory fabrica = new BarrioFactory();
		BarrioDoble unBarrio = fabrica.crearBuenosAiresNorte();
		BarrioDoble unBarrio2 = fabrica.crearBuenosAiresSur();
		unBarrio.setOtraZona(unBarrio2);
		unBarrio2.setOtraZona(unBarrio);
		Jugador unJugador = new Jugador();
		Dinero unDinero = new Dinero(100000);
		unJugador.agregarDinero(unDinero);

		unJugador.setCasillaActual(unBarrio);
		
		unJugador.comprar(unBarrio);
		unJugador.comprar(unBarrio2);

		unJugador.agregarCasa(unBarrio);
		unJugador.agregarCasa(unBarrio);
		

		unJugador.setCasillaActual(unBarrio2);
		
		unJugador.agregarCasa(unBarrio2);
		unJugador.agregarCasa(unBarrio2);
		unJugador.agregarHotel(unBarrio2);
		

		unJugador.setCasillaActual(unBarrio);
		
		unJugador.agregarHotel(unBarrio);
		Assert.assertEquals(1, unBarrio.getCantidadDeEdificios());
		Assert.assertEquals(1, unBarrio2.getCantidadDeEdificios());
	}
	
	@Test(expected = NoEsDuenioDeLosDosTerrenos.class)
	public void testBarrioBuenosAiresSoloSeCompraSurNoPuedeConstruirCasas() {
		BarrioFactory fabrica = new BarrioFactory();
		BarrioDoble unBarrio = fabrica.crearBuenosAiresNorte();
		BarrioDoble unBarrio2 = fabrica.crearBuenosAiresSur();
		unBarrio.setOtraZona(unBarrio2);
		unBarrio2.setOtraZona(unBarrio);
		Jugador unJugador = new Jugador();
		Dinero unDinero = new Dinero(100000);
		unJugador.agregarDinero(unDinero);

		unJugador.setCasillaActual(unBarrio);
		
		unJugador.comprar(unBarrio);
		unJugador.agregarCasa(unBarrio);
	}

	@Test(expected = BarrioLleno.class)
	public void testBarrioBuenosAiresJugadorConstruyeHotelEnCadaUnoNoSePuedeContruirUnaCasa() {
		BarrioFactory fabrica = new BarrioFactory();
		BarrioDoble unBarrio = fabrica.crearBuenosAiresNorte();
		BarrioDoble unBarrio2 = fabrica.crearBuenosAiresSur();
		unBarrio.setOtraZona(unBarrio2);
		unBarrio2.setOtraZona(unBarrio);
		Jugador unJugador = new Jugador();
		Dinero unDinero = new Dinero(100000);
		unJugador.agregarDinero(unDinero);

		unJugador.setCasillaActual(unBarrio);
		
		unJugador.comprar(unBarrio);
		unJugador.comprar(unBarrio2);

		unJugador.agregarCasa(unBarrio);
		unJugador.agregarCasa(unBarrio);
		unJugador.agregarCasa(unBarrio2);
		unJugador.agregarCasa(unBarrio2);
		unJugador.agregarHotel(unBarrio2);
		unJugador.agregarHotel(unBarrio);
		unJugador.agregarCasa(unBarrio2);
	}
	
	@Test(expected = JugadorInvalido.class)
	public void testBarrioSantaFeJugadorIntentaConstruirCasaEnUnBarrioQueNoEsSuyo() {
		BarrioFactory fabrica = new BarrioFactory();
		Barrio unBarrio = fabrica.crearSantaFe();
		Jugador unJugador = new Jugador();
		Jugador unJugador2 = new Jugador();

		unJugador.setCasillaActual(unBarrio);
		
		unJugador2.comprar(unBarrio);
		unJugador.agregarCasa(unBarrio);	
	}
	
	@Test(expected = BarrioLleno.class)
	public void testBarrioBuenosAiresJugadorConstruyeHotelEnCadaUnoNoSePuedeContruirUnHotel() {
		BarrioFactory fabrica = new BarrioFactory();
		BarrioDoble unBarrio = fabrica.crearBuenosAiresNorte();
		BarrioDoble unBarrio2 = fabrica.crearBuenosAiresSur();
		unBarrio.setOtraZona(unBarrio2);
		unBarrio2.setOtraZona(unBarrio);
		Jugador unJugador = new Jugador();
		Dinero unDinero = new Dinero(100000);
		unJugador.agregarDinero(unDinero);

		unJugador.setCasillaActual(unBarrio);
		
		unJugador.comprar(unBarrio);
		unJugador.comprar(unBarrio2);

		unJugador.agregarCasa(unBarrio);
		unJugador.agregarCasa(unBarrio);
		unJugador.agregarCasa(unBarrio2);
		unJugador.agregarCasa(unBarrio2);
		unJugador.agregarHotel(unBarrio2);
		unJugador.agregarHotel(unBarrio);
		unJugador.agregarCasa(unBarrio2);
	}
	
}
