package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillas.AvanceDinamico;
import modelo.Jugador;

public class AvanceDinamicoTest {
	
	@Test
	public void testCaerEnLaCasillaCon6oMenos(){
		Jugador unJugador = new Jugador(100000);		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		int posicionInicial = unJugador.getPosicion();
		
		unAvanceDinamico.avanzar(unJugador, 5);	//El 5 puede ser reemplazado por un objeto tipo dado que devuelva el numero sacado.
		
		Assert.assertEquals(posicionInicial + 3, unJugador.getPosicion());
	}
	
	
	@Test
	public void testCaerEnLaCasillaCon7Hasta10(){
		Jugador unJugador = new Jugador(9*25+8);		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		int posicionInicial = unJugador.getPosicion();
		
		unAvanceDinamico.avanzar(unJugador, 9);
		
		Assert.assertEquals(posicionInicial + 25, unJugador.getPosicion());
	}
	
	@Test
	public void testCaerEnLaCasillaCon11oMas() {
		Jugador unJugador = new Jugador(100000);
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		int posicionInicial = unJugador.getPosicion();
		Barrio unBarrio = new Barrio(1000);
				
		unJugador.comprar(unBarrio);
		unAvanceDinamico.avanzar(unJugador, 11);
		
		Assert.assertEquals(posicionInicial + 10, unJugador.getPosicion());
		
		
	}
	
	@Test 
	public void testCaerEnLaCasillaCon11oMasYTenerMasCantidadDePropiedades() {
		Jugador unJugador = new Jugador(100000);		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		int posicionInicial = unJugador.getPosicion();
		Barrio unBarrio = new Barrio(1000);
		Barrio unBarrio1 = new Barrio(1000);
		Barrio unBarrio2 = new Barrio(1000);
		Barrio unBarrio3 = new Barrio(1000);
		Barrio unBarrio4 = new Barrio(1000);
		Barrio unBarrio5 = new Barrio(1000);
		Barrio unBarrio6 = new Barrio(1000);
		Barrio unBarrio7 = new Barrio(1000);
		Barrio unBarrio8 = new Barrio(1000);
		Barrio unBarrio9 = new Barrio(1000);
		Barrio unBarrio10 = new Barrio(1000);
		Barrio unBarrio11 = new Barrio(1000);
		
		unJugador.comprar(unBarrio);
		unJugador.comprar(unBarrio1);
		unJugador.comprar(unBarrio2);
		unJugador.comprar(unBarrio3);
		unJugador.comprar(unBarrio4);
		unJugador.comprar(unBarrio5);
		unJugador.comprar(unBarrio6);
		unJugador.comprar(unBarrio7);
		unJugador.comprar(unBarrio8);
		unJugador.comprar(unBarrio9);
		unJugador.comprar(unBarrio10);
		unJugador.comprar(unBarrio11);
		unAvanceDinamico.avanzar(unJugador, 11);
	
		Assert.assertEquals(posicionInicial - 1, unJugador.getPosicion());
	}
	

}
