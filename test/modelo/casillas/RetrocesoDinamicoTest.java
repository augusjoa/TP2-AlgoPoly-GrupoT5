package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillas.RetrocesoDinamico;
import modelo.Jugador;

public class RetrocesoDinamicoTest {
	@Test
	public void testCaerEnLaCasillaCon7Hasta10(){
		Jugador unJugador = new Jugador(9*25+8);	
		RetrocesoDinamico unRetrocesoDinamico = new RetrocesoDinamico();
		int posicionInicial = unJugador.getPosicion();
		
		unRetrocesoDinamico.retrocederAlJugador(unJugador, 9);
		
		Assert.assertEquals(posicionInicial - 8, unJugador.getPosicion());
	}
	
	@Test
	public void testCaerEnLaCasillaCon11oMas(){
		Jugador unJugador = new Jugador(100000);		
		RetrocesoDinamico unRetrocesoDinamico = new RetrocesoDinamico();
		int posicionInicial = unJugador.posicion.getPosX();
		
		unRetrocesoDinamico.retrocederAlJugador(unJugador, 11);
		
		Assert.assertEquals(posicionInicial - 9, unJugador.posicion.getPosX());
	}
	
	@Test 
	public void testCaerEnLaCasillaCon5() {
		Jugador unJugador = new Jugador(100000);		
		RetrocesoDinamico unRetrocesoDinamico = new RetrocesoDinamico();
		int posicionInicial = unJugador.getPosicion();
		Barrio unBarrio = new Barrio(1000);
		
		unJugador.comprar(unBarrio);
		unRetrocesoDinamico.retrocederAlJugador(unJugador, 5);
	
		Assert.assertEquals(posicionInicial - 4, unJugador.getPosicion());
	}
	
	
	
	//Codigo duplicado en AvanceDinamico
	//El tercer comportamiento en ambos casos es mas complicado, el Jugador deberia almacenar una 
	//lista de propiedades adquiridas, en contra de lo que dijimos de que lo almacene el barrio su propietario
}
