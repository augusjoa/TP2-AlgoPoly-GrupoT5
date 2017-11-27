package modelo.casillas;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillas.AvanceDinamico;
import modelo.DobleDado;
import modelo.Jugador;
import modelo.Tablero;

public class AvanceDinamicoTest {
	
	@Test
	public void testCaerEnLaCasillaCon6oMenos(){
		Jugador unJugador = new Jugador();
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		int numeroDelDado = 2;
		Assert.assertEquals(numeroDelDado - 2, unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 3;
		Assert.assertEquals(numeroDelDado - 2, unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 4;
		Assert.assertEquals(numeroDelDado - 2, unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 5;
		Assert.assertEquals(numeroDelDado - 2, unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 6;
		Assert.assertEquals(numeroDelDado - 2, unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
	}
	
	
	@Test
	public void testCaerEnLaCasillaCon7Hasta10(){
		Jugador unJugador = new Jugador();
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		
		int numeroDelDado = 7;
		Assert.assertEquals(5 , unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 8;
		Assert.assertEquals(0 , unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 9;
		Assert.assertEquals(1 , unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 10;
		Assert.assertEquals(0 , unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
	}
	
	@Test
	public void testCaerEnLaCasillaCon11oMas() {
		Jugador unJugador = new Jugador();
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		BarrioSimple unBarrio = new BarrioSimple(20000, 5000, 2000, 3000, "testBarr");
		unJugador.comprar(unBarrio);
		
		int numeroDelDado = 11;
		Assert.assertEquals(10 , unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
		numeroDelDado = 12;
		Assert.assertEquals(11 , unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
	}
	
//	@Test 
//	public void testCaerEnLaCasillaCon11oMasYTenerMasCantidadDePropiedades() {
//		Jugador unJugador = new Jugador();
//		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
//		BarrioSimple unBarrio = new BarrioSimple(2000, 5000, 2000, 3000, "testBarr");
//		BarrioSimple unBarrio2 = new BarrioSimple(2000, 5000, 2000, 3000, "testBarr2");
//		BarrioSimple unBarrio3 = new BarrioSimple(2000, 5000, 2000, 3000, "testBarr3");
//		BarrioSimple unBarrio4 = new BarrioSimple(2000, 5000, 2000, 3000, "testBarr4");
//		BarrioSimple unBarrio5 = new BarrioSimple(2000, 5000, 2000, 3000, "testBarr5");
//		BarrioSimple unBarrio6 = new BarrioSimple(2000, 5000, 2000, 3000, "testBarr6");
//		BarrioSimple unBarrio7 = new BarrioSimple(2000, 5000, 2000, 3000, "testBarr7");
//		
//		unJugador.comprar(unBarrio);
//		unJugador.comprar(unBarrio2);
//		unJugador.comprar(unBarrio3);
//		unJugador.comprar(unBarrio4);
//		unJugador.comprar(unBarrio5);
//		unJugador.comprar(unBarrio6);
//		unJugador.comprar(unBarrio7);
//		//estas casas deberian contar como propiedades, pero no lo estan haciendo.
//		unJugador.agregarCasa(unBarrio);
//		unJugador.agregarCasa(unBarrio2);
//		unJugador.agregarCasa(unBarrio3);
//		unJugador.agregarCasa(unBarrio4);
//		unJugador.agregarCasa(unBarrio5);
//		unJugador.agregarCasa(unBarrio6);
//		unJugador.agregarCasa(unBarrio7);
//		
//		
//		int numeroDelDado = 11;
//		Assert.assertEquals(-3 , unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
//		numeroDelDado = 12;
//		Assert.assertEquals(-2 , unAvanceDinamico.getCantidadDePasos(unJugador, numeroDelDado));
//	}
	

}
