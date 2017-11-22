package modelo;

import java.util.Random;

import org.junit.Test;

public class Dado {
	private int primerdado = 0;
	private int segundodado = 0;
	Random rand = new Random();
	
	public int tirarDados() {
		this.primerdado = 1 + rand.nextInt(6);
		this.segundodado = 1 + rand.nextInt(6);
		return this.primerdado + this.segundodado;
	}
	
	public boolean DadosSonIguales() {
		return this.primerdado == this.segundodado;
	}
	
//	Esto habria que borrarlo despues
	@Test
	public void testDeDados() {
		int numero = this.tirarDados();
		System.out.print(numero);
	}
}


