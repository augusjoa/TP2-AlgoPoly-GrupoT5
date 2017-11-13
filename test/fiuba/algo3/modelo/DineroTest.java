package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.modelo.Dinero;

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
		Assert.assertEquals(100000, dinero.getDinero(), DELTA);
	}
	
	@Test
	public void testagregarDinero() {
		Dinero dinero = new Dinero(100000);
		dinero.agregarDinero(20000);
		Assert.assertEquals(120000, dinero.getDinero(), DELTA);
	}
	
	@Test
	public void testsustraerDinero() {
		Dinero dinero = new Dinero(100000);
		dinero.sustraerDinero(20000);
		Assert.assertEquals(80000, dinero.getDinero(),DELTA);
	}

}
