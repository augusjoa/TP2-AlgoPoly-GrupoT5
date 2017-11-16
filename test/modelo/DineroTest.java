package modelo;

import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;

public class DineroTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void testcrearDinero() {
		Dinero dinero = new Dinero(100000);
		Assert.assertNotNull(dinero);
	}
	
	@Test
	public void testgetDinero() {
		Dinero dinero = new Dinero(100000);
		Assert.assertEquals(100000, dinero.getValor(), DELTA);
	}
	
	@Test
	public void testagregarDinero() {
		Dinero dinero = new Dinero(100000);
		dinero.agregarValor(20000);
		Assert.assertEquals(120000, dinero.getValor(), DELTA);
	}
	
	@Test
	public void testsustraerDinero() {
		Dinero dinero = new Dinero(100000);
		dinero.sustraerValor(20000);
		Assert.assertEquals(80000, dinero.getValor(),DELTA);
	}

}
