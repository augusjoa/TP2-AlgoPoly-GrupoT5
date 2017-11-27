package modelo;

import java.util.Collection;
import java.util.HashSet;

import modelo.casillas.Barrio;
import modelo.casillas.BarrioDoble;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;



public class Jugador {
	
	
	private Dinero dinero = new Dinero(100000);
	private boolean detenido = false;	
	private Collection <Adquirible> adquisiciones = new HashSet<Adquirible>();
	private DobleDado dado = new DobleDado();
	private Visitable casillaActual;
	protected Tablero tablero = Tablero.TableroUnico();
	//private AdquiriblesDeJugador adquisiciones2 = new AdquiriblesDeJugador();
	
	//public Jugador(Tablero unTablero){
	//	tablero= unTablero;
	//}
	
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

	public void vender(Adquirible unAdquirible) {
		unAdquirible.vender(this);
		adquisiciones.remove(unAdquirible);
	}
	
	public boolean esDuenio(Adquirible unAdquirible) {
		return adquisiciones.contains(unAdquirible);
	}

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

	public void moverse(Tablero unTablero) {
		casillaActual = unTablero.avanzarCasillas(casillaActual, getNumeroDelDado());
		casillaActual.esVisitadoPorJugador(this);
	}
	
	public void setCasillaActual(Visitable unVisitable){
		casillaActual=unVisitable;
		
	}
	
	public void agregarCasa(Barrio unBarrio) {
		unBarrio.agregarCasa(this);
	}
	
	public void agregarHotel(BarrioDoble unBarrio) {
		unBarrio.agregarHotel(this);
	}
}