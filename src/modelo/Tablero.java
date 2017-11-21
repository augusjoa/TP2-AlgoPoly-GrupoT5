package modelo;

import java.util.AbstractCollection;
import java.util.ArrayList;

import modelo.casillas.Carcel;
import modelo.casillas.Quini6;
import modelo.interfaces.Visitable;


public class Tablero {

	private AbstractCollection <Visitable> casilleros = new ArrayList<Visitable>();

	
	public Tablero() {
		Visitable quini6Cas = new Quini6();
		Visitable carcelCas = new Carcel();
		
		casilleros.add(carcelCas);
		casilleros.add(quini6Cas);
	}
	
	
	public int cantidadDeCasillas() {
		
		return casilleros.size();
	}

}
