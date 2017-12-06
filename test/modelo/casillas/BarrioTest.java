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
			Jugador unJugador = new Jugador(0);
			
			unBarrio.comprar(unJugador);
			
			Assert.assertEquals(unJugador, unBarrio.getDuenio());
		}
		
		@Test
		public void testElBarrioNoTieneDuenioAlSerVendido() {
			BarrioFactory fabrica = new BarrioFactory();
			Barrio unBarrio = fabrica.crearTucuman();
			Jugador unJugador = new Jugador(0);
			
			unBarrio.comprar(unJugador);
			unBarrio.vender(unJugador);
			
			Assert.assertNull(unBarrio.getDuenio());
		}
		
		@Test
		public void testBarrioSantaFeEsCompradoPorJugadorYagregaunaCasa() {
			BarrioFactory fabrica = new BarrioFactory();
			Barrio unBarrio = fabrica.crearSantaFe();
			Jugador unJugador = new Jugador(0);
			

			unJugador.setCasillaActual(unBarrio);
			
			
			unBarrio.comprar(unJugador);
			unJugador.agregarCasa(unBarrio);
			
			Assert.assertEquals(1, unBarrio.getCantidadDeEdificios());
		}
		
		@Test(expected = BarrioLleno.class)
		public void testBarrioNeuquenEsCompradoYNoPuedeConstruirMasDeUnaCasa() {
			BarrioFactory fabrica = new BarrioFactory();
			Barrio unBarrio = fabrica.crearNeuquen();
			Jugador unJugador = new Jugador(0);
			
			unJugador.setCasillaActual(unBarrio);
			unBarrio.comprar(unJugador);
			
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
			Jugador unJugador = new Jugador(0);
			Dinero unDinero = new Dinero(100000);
			unJugador.agregarDinero(unDinero);

			unJugador.setCasillaActual(unBarrio);
			
			unBarrio.comprar(unJugador);
			unBarrio2.comprar(unJugador);

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
			Jugador unJugador = new Jugador(0);
			Dinero unDinero = new Dinero(100000);
			unJugador.agregarDinero(unDinero);

			unJugador.setCasillaActual(unBarrio);
			
			unBarrio.comprar(unJugador);
			unJugador.agregarCasa(unBarrio);
		}

		@Test(expected = BarrioLleno.class)
		public void testBarrioBuenosAiresJugadorConstruyeHotelEnCadaUnoNoSePuedeContruirUnaCasa() {
			BarrioFactory fabrica = new BarrioFactory();
			BarrioDoble unBarrio = fabrica.crearBuenosAiresNorte();
			BarrioDoble unBarrio2 = fabrica.crearBuenosAiresSur();
			unBarrio.setOtraZona(unBarrio2);
			unBarrio2.setOtraZona(unBarrio);
			Jugador unJugador = new Jugador(0);
			Dinero unDinero = new Dinero(100000);
			unJugador.agregarDinero(unDinero);

			unJugador.setCasillaActual(unBarrio);
			
			unBarrio.comprar(unJugador);
			unBarrio2.comprar(unJugador);
			
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
			Jugador unJugador = new Jugador(0);
			Jugador unJugador2 = new Jugador(1);

			unJugador.setCasillaActual(unBarrio);
			
			unBarrio.comprar(unJugador2);
			unJugador.agregarCasa(unBarrio);	
		}
		
		@Test(expected = BarrioLleno.class)
		public void testBarrioBuenosAiresJugadorConstruyeHotelEnCadaUnoNoSePuedeContruirUnHotel() {
			BarrioFactory fabrica = new BarrioFactory();
			BarrioDoble unBarrio = fabrica.crearBuenosAiresNorte();
			BarrioDoble unBarrio2 = fabrica.crearBuenosAiresSur();
			unBarrio.setOtraZona(unBarrio2);
			unBarrio2.setOtraZona(unBarrio);
			Jugador unJugador = new Jugador(0);
			Dinero unDinero = new Dinero(100000);
			unJugador.agregarDinero(unDinero);

			unJugador.setCasillaActual(unBarrio);
			
			unBarrio.comprar(unJugador);
			unBarrio2.comprar(unJugador);
			
			unJugador.agregarCasa(unBarrio);
			unJugador.agregarCasa(unBarrio);
			unJugador.agregarCasa(unBarrio2);
			unJugador.agregarCasa(unBarrio2);
			unJugador.agregarHotel(unBarrio2);
			unJugador.agregarHotel(unBarrio);
			unJugador.agregarCasa(unBarrio2);
		}
		
		
		@Test 
		public void testBarrioesVisitadoPorJugadorQueNoEsDuenio(){
			BarrioFactory fabrica = new BarrioFactory();
			Barrio unBarrio = fabrica.crearNeuquen();
			Jugador unJugador = new Jugador(0);
			Jugador unJugador2 = new Jugador(1);
			Dinero dinero = new Dinero(unJugador2.getDinero());
			
			unJugador.setCasillaActual(unBarrio);
			
			unBarrio.comprar(unJugador);
			unBarrio.esVisitadoPorJugador(unJugador2);
			
			dinero.sustraerDinero(unJugador2.getDinero());
			Assert.assertEquals(1800, dinero.getValor());
		}
		

		@Test 
		public void testBarrioConCsaesVisitadoPorJugadorQueNoEsDuenio(){
			BarrioFactory fabrica = new BarrioFactory();
			Barrio unBarrio = fabrica.crearNeuquen();
			Jugador unJugador = new Jugador(0);
			Jugador unJugador2 = new Jugador(1);
			Dinero dinero = new Dinero(unJugador2.getDinero());
			
			unJugador.setCasillaActual(unBarrio);
			
			unBarrio.comprar(unJugador);
			unJugador.agregarCasa(unBarrio);
			unBarrio.esVisitadoPorJugador(unJugador2);
			
			dinero.sustraerDinero(unJugador2.getDinero());
			Assert.assertEquals(3800, dinero.getValor());
		}

		@Test
		public void testBarrioBuenosAiresEsVisitadoPorJugadorqueNoEsDuenio() {
			BarrioFactory fabrica = new BarrioFactory();
			BarrioDoble unBarrio = fabrica.crearBuenosAiresNorte();
			BarrioDoble unBarrio2 = fabrica.crearBuenosAiresSur();
			unBarrio.setOtraZona(unBarrio2);
			unBarrio2.setOtraZona(unBarrio);
			Jugador unJugador = new Jugador(0);
			Jugador unJugador2 = new Jugador(1);
			Dinero dineroDeJugador2 = new Dinero(unJugador2.getDinero());
			Dinero unDinero = new Dinero(100000);
			unJugador.agregarDinero(unDinero);

			unJugador.setCasillaActual(unBarrio);
			
			unBarrio.comprar(unJugador);
			unBarrio2.comprar(unJugador);

			unJugador.agregarCasa(unBarrio);
			unJugador.agregarCasa(unBarrio);
			

			unJugador.setCasillaActual(unBarrio2);
			
			unJugador.agregarCasa(unBarrio2);
			unJugador.agregarCasa(unBarrio2);
			unJugador.agregarHotel(unBarrio2);
			

			unJugador.setCasillaActual(unBarrio);
			
			unJugador.agregarHotel(unBarrio);
			unBarrio.esVisitadoPorJugador(unJugador2);
			
			dineroDeJugador2.sustraerDinero(unJugador2.getDinero());
			Assert.assertEquals(3500, dineroDeJugador2.getValor());
		}
}
