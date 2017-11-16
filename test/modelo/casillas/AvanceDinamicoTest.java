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
	

}
