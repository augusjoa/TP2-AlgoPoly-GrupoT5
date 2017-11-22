package modelo;

import java.util.Random;

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
	

}


