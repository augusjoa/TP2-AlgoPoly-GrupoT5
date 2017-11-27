package modelo;

import org.junit.Assert;
import org.junit.Test;

import modelo.Dinero;
import modelo.excepciones.DineroInsuficiente;

public class DineroTest{

	@Test
	public void testcrearDinero() {
		Dinero dinero = new Dinero(100000);
		Assert.assertNotNull(dinero);
	}
	
	@Test
	public void testgetDinero() {
		Dinero dinero = new Dinero(100000);
		Assert.assertEquals(100000, dinero.getValor());
	}
	
	@Test
	public void testAgregarDinero() {
		Dinero dinero = new Dinero(100000);
		Dinero dinero2 = new Dinero(20000);
		Dinero dineroEsperado = new Dinero(100000 + 20000);
		dinero.agregarDinero(dinero2);
		
		Assert.assertEquals(dineroEsperado, dinero);
	}
	
	@Test
	public void testSustraerDineroConFondeosSuficientes() {
		Dinero dinero = new Dinero(100000);
		Dinero dinero2 = new Dinero(20000);
		Dinero dineroEsperado = new Dinero(100000 - 20000);
		dinero.sustraerDinero(dinero2);
		
		Assert.assertEquals(dineroEsperado, dinero);
	}
	//esto en si va en un Test aparte de excepciones, donde estan todas juntas.
	@Test(expected=DineroInsuficiente.class)
	public void testSustraerDineroConFondosInsuficientesLanzaExcepcion() {
		Dinero unDinero = new Dinero(50000);
		Dinero dineroCasa = new Dinero(70000);
		
		unDinero.sustraerDinero(dineroCasa);
	}

}
