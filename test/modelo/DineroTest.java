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
		Assert.assertEquals(100000, dinero._getValor());
	}
	
	@Test
	public void testAgregarDinero() {
		Dinero dinero = new Dinero(100000);
		Dinero dinero2 = new Dinero(20000);
		dinero.agregarDinero(dinero2);
		Assert.assertEquals(120000, dinero._getValor());
	}
	
	@Test
	public void testSustraerDinero() {
		Dinero dinero = new Dinero(100000);
		Dinero dinero2 = new Dinero(20000);
		dinero.sustraerDinero(dinero2);
		Assert.assertEquals(80000, dinero._getValor());
	}
	
	@Test
	public void testDineroEsMenorAlComprarAdquiribleConFondosSuficientes() {
		Dinero unDinero = new Dinero(100000);
		Dinero dineroCasa = new Dinero(20000);
		
		unDinero.sustraerDinero(dineroCasa);
		Assert.assertEquals(80000, unDinero._getValor());
	}

	
	@Test(expected=DineroInsuficiente.class)
	public void testNoSePuedeComprarUnAdquiribleConFondosInsuficientes() {
		Dinero unDinero = new Dinero(50000);
		Dinero dineroCasa = new Dinero(70000);
		
		unDinero.sustraerDinero(dineroCasa);
	}

}
