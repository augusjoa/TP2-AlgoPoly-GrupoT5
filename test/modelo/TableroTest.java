package modelo;

import org.junit.Assert;
import org.junit.Test;

public class TableroTest {
	@Test
	public void testAlCrearTableroTieneCasillas() {
		Tablero unTablero = new Tablero();
		
		Assert.assertNotEquals(0, unTablero.cantidadDeCasillas());
	}
}
