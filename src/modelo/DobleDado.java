package modelo;

import java.util.Random;

public class DobleDado {
	private int primerDado = 0;
	private int segundoDado = 0;
	Random rand = new Random();
	
	public int tirarDados() {
		primerDado = 1 + rand.nextInt(6);
		segundoDado = 1 + rand.nextInt(6);
		return primerDado + segundoDado;
	}
	
	public boolean dadosSonIguales() {
		return this.primerDado == this.segundoDado;
	}
	
	public int getDobleDado(){
		return primerDado + segundoDado;
	}
	

}
