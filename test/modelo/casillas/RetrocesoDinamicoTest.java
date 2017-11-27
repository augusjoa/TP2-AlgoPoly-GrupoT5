package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillas.RetrocesoDinamico;
import modelo.Jugador;

public class RetrocesoDinamicoTest {
	@Test
	public void testCaerEnLaCasillaCon7Hasta10(){
		Jugador unJugador = new Jugador();
		RetrocesoDinamico unRetrocesoDinamico = new RetrocesoDinamico();
		
		int numeroDelDado = 7;
		Assert.assertEquals(-5, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 8;
		Assert.assertEquals(-0, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 9;
		Assert.assertEquals(-1, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 10;
		Assert.assertEquals(-0, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
	}
	
	@Test
	public void testCaerEnLaCasillaCon11oMas(){
		Jugador unJugador = new Jugador();
		RetrocesoDinamico unRetrocesoDinamico = new RetrocesoDinamico();
		
		int numeroDelDado = 11;
		Assert.assertEquals(-(numeroDelDado - 2), unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 12;
		Assert.assertEquals(-(numeroDelDado - 2), unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		
	}
	
	@Test 
	public void testCaerEnLaCasillaCon6oMenos() {
		Jugador unJugador = new Jugador();
		RetrocesoDinamico unRetrocesoDinamico = new RetrocesoDinamico();
		BarrioSimple unBarrio = new BarrioSimple(20000, 5000, 2000, 3000, "testBarr");
		unJugador.comprar(unBarrio);
		
		int numeroDelDado = 2;
		Assert.assertEquals(-1, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 3;
		Assert.assertEquals(-2, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 4;
		Assert.assertEquals(-3, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 5;
		Assert.assertEquals(-4, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 6;
		Assert.assertEquals(-5, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
	}
	
//	@Test 
//	public void testCaerEnLaCasillaCon6oMenosYTenerMasDe6Propiedades() {
//		Jugador unJugador = new Jugador();
//		RetrocesoDinamico unRetrocesoDinamico = new RetrocesoDinamico();
//		
//		BarrioSimple unBarrio = new BarrioSimple(2000, 5000, 2000, 3000, "testBarr");
//		BarrioSimple unBarrio2 = new BarrioSimple(2000, 5000, 2000, 3000, "testBarr2");
//		BarrioSimple unBarrio3 = new BarrioSimple(2000, 5000, 2000, 3000, "testBarr3");
//		BarrioSimple unBarrio4 = new BarrioSimple(2000, 5000, 2000, 3000, "testBarr3");
//		
//		unJugador.comprar(unBarrio);
//		unJugador.comprar(unBarrio2);
//		unJugador.comprar(unBarrio3);
//		unJugador.comprar(unBarrio4);
//		//estas casas deberian contar como propiedades, pero no lo estan haciendo.
//		unJugador.agregarCasa(unBarrio);
//		unJugador.agregarCasa(unBarrio2);
//		unJugador.agregarCasa(unBarrio3);
//		unJugador.agregarCasa(unBarrio4);
//		
//		
//		int numeroDelDado = 2;
//		Assert.assertEquals(6, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
//		numeroDelDado = 3;
//		Assert.assertEquals(5, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
//		numeroDelDado = 4;
//		Assert.assertEquals(4, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
//		numeroDelDado = 5;
//		Assert.assertEquals(3, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
//		numeroDelDado = 6;
//		Assert.assertEquals(2, unRetrocesoDinamico.getCantidadDePasos(unJugador, numeroDelDado));
//	}
}
