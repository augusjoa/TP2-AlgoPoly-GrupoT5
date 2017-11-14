package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

import casillas.RetrocesoDinamico;

public class RetrocesoDinamicoTest {
	@Test
	public void testCaerEnLaCasillaCon7Hasta10(){
		Jugador unJugador = new Jugador(9*25+8);		
		RetrocesoDinamico unRetrocesoDinamico = new RetrocesoDinamico();
		int posicionInicial = unJugador.posicion.getPosX();
		
		unRetrocesoDinamico.avanzar(unJugador, 9);
		
		Assert.assertEquals(posicionInicial + 25, unJugador.posicion);
	}
	
	@Test
	public void testCaerEnLaCasillaCon11oMas(){
		Jugador unJugador = new Jugador(100000);		
		RetrocesoDinamico unRetrocesoDinamico = new RetrocesoDinamico();
		int posicionInicial = unJugador.posicion.getPosX();
		
		unRetrocesoDinamico.avanzar(unJugador, 11);
		
		Assert.assertEquals(posicionInicial + 9, unJugador.posicion);
	}
	
	//Codigo duplicado en AvanceDinamico
	//El tercer comportamiento en ambos casos es mas complicado, el Jugador deberia almacenar una 
	//lista de propiedades adquiridas, en contra de lo que dijimos de que lo almacene el barrio su propietario
}
