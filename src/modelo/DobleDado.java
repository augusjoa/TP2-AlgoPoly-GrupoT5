package modelo;

import java.util.Random;

public class DobleDado {
	private int primerDado = 0;
	private int segundoDado = 0;
	Random rand = new Random();
	
	public int tirarDados() {
		this.primerDado = 1 + rand.nextInt(6);
		this.segundoDado = 1 + rand.nextInt(6);
		return this.primerDado + this.segundoDado;
	}
	
	public boolean DadosSonIguales() {
		return this.primerDado == this.segundoDado;
	}
	
	public int getDobleDado(){
		return primerDado + segundoDado;
	}
	

}
