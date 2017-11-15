package casillas;

import org.junit.Assert;
import org.junit.Test;

import casillas.RetrocesoDinamico;
import modelo.Jugador;

public class RetrocesoDinamicoTest {
	@Test
	public void testCaerEnLaCasillaCon7Hasta10(){
		Jugador unJugador = new Jugador(9*25+8);		
		RetrocesoDinamico unRetrocesoDinamico = new RetrocesoDinamico();
		int posicionInicial = unJugador.posicion.getPosX();
		
		unRetrocesoDinamico.avanzar(unJugador, 9);
		
		Assert.assertEquals(posicionInicial + 25, unJugador.posicion.getPosX());
	}
	
	@Test
	public void testCaerEnLaCasillaCon11oMas(){
		Jugador unJugador = new Jugador(100000);		
		RetrocesoDinamico unRetrocesoDinamico = new RetrocesoDinamico();
		int posicionInicial = unJugador.posicion.getPosX();
		
		unRetrocesoDinamico.avanzar(unJugador, 11);
		
		Assert.assertEquals(posicionInicial + 9, unJugador.posicion.getPosX());
	}
	
	//Codigo duplicado en AvanceDinamico
	//El tercer comportamiento en ambos casos es mas complicado, el Jugador deberia almacenar una 
	//lista de propiedades adquiridas, en contra de lo que dijimos de que lo almacene el barrio su propietario
}
