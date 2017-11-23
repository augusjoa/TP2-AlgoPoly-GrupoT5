package modelo;


import java.util.ArrayList;
import java.util.ListIterator;
import modelo.casillas.Carcel;
import modelo.casillas.Quini6;
import modelo.interfaces.Visitable;


public class Tablero {
	private int cantidad_nodos;
	private ArrayList <Visitable> casilleros = new ArrayList<Visitable>();
	private ListIterator<Visitable> iterador = null;
	


	
	
	public Tablero() {
//		Visitable salidaCas = new Salida();
		Visitable quini6Cas = new Quini6();
//		Visitable barrio1Cas = new Barrio(20000);
//		Visitable empresa1Cas = new Empresa(35000);
//		Visitable barrio2Cas = new Barrio(25000);
		Visitable carcelCas = new Carcel();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
//		Visitable quini6Cas = new Quini6();
		
		casilleros.add(carcelCas);
		casilleros.add(quini6Cas);
	}
	
	
	public int cantidadDeCasillas() {
		
		return casilleros.size();
	}


	public Visitable siguienteCasilla() {
		if(iterador == null || !iterador.hasNext() ) iterador = casilleros.listIterator();
		return iterador.next();
	}

}
