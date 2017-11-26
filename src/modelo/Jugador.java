package modelo;

import java.util.Collection;
import java.util.HashSet;

import modelo.casillas.Barrio;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;



public class Jugador {
	
	//private String nombre;
	private Dinero dinero = new Dinero(100000);
	private boolean detenido = false;	
	private Collection <Adquirible> adquisiciones = new HashSet<Adquirible>();
	private DobleDado dado = new DobleDado();
	private Visitable CasillaActual;
	
	private AdquiriblesDeJugador adquisiciones2 = new AdquiriblesDeJugador();
	
	
	public Dinero getDinero() {
		return dinero;
	}
	
	public void agregarDinero(Dinero unDinero) {
		dinero.agregarDinero(unDinero);
	}
	
	public void sustraerDinero(Dinero unDinero) {
		dinero.sustraerDinero(unDinero);
	}


	public int getCantidadDePropiedades() {
		return adquisiciones.size();
	}

	public void comprar(Adquirible unAdquirible) {
		
		unAdquirible.comprar(this);
		adquisiciones.add(unAdquirible);		
	}

	public boolean esDuenio(Adquirible unAdquirible) {
		return adquisiciones.contains(unAdquirible);
	}

	//public boolean vender(Adquirible unAdquirible) {
		//if(!adquisiciones.contains(unAdquirible)) return false; //o ver de agregar excepciones	
		//dinero.vender(unAdquirible);
		//adquisiciones.remove(unAdquirible);
		//unAdquirible.setDuenio(null);
		//return true;
	//}

	public int tirarDados() {
		return dado.tirarDados();
	}
	public int getNumeroDelDado(){
		return dado.getDobleDado();
	}

	public void jugadorDetenido() {
		detenido=true;
	}
	
	public void jugadorLiberado(){
		detenido=false;
	}

	public boolean puedeMoverse() {
		return !detenido;
	}

	//public void moverse(int cantidadDeCasillas) {
		//this.elQueSabeMover.mover(this, cantidadDeCasillas)
	//}

}