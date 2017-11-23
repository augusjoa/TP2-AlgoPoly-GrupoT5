package modelo;

import org.junit.Assert;
import org.junit.Test;

import modelo.interfaces.Visitable;

public class TableroTest {
	@Test
	public void testAlCrearTableroTieneCasillas() {
		Tablero unTablero = new Tablero();
		
		Assert.assertNotEquals(0, unTablero.cantidadDeCasillas());
	}
	
	@Test
	public void testLasCasillasSonCiclicas() {
		Tablero unTablero = new Tablero();
		
		int cantidadDeCasillas = unTablero.cantidadDeCasillas();
		
		Visitable primeraCasilla;
		
		Visitable siguienteALaUltima;
		
		primeraCasilla = unTablero.siguienteCasilla();
		for(int i=1; i < cantidadDeCasillas; i++) {
			unTablero.siguienteCasilla();
		}
		siguienteALaUltima = unTablero.siguienteCasilla();
		
		Assert.assertEquals(primeraCasilla, siguienteALaUltima);
	}
}
