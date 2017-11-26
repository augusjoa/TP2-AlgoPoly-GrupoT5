package modelo.casillas;

import java.util.Hashtable;

import modelo.Dinero;
import modelo.Jugador;
import modelo.excepciones.AccionInvalidaError;

public class BarrioSimple extends Barrio {
	private int cantidadDeCasas = 0;
	private Dinero precioCasa;
    private Hashtable<Integer, Dinero> alquileres = new Hashtable<Integer, Dinero>();


	public BarrioSimple(int precioDelBarrio, int unprecioCasa, int alquilersincasa, int alquilerconcasa, String unNombre) {
		
		super(precioDelBarrio, unNombre);
		this.precioCasa = new Dinero(unprecioCasa);
		this.alquileres.put(0, new Dinero (alquilersincasa));
		this.alquileres.put(1, new Dinero (alquilerconcasa));
	}
	
	
	public int getCantidadDeEdificios() {
		return this.cantidadDeCasas;
	}
	
	public void agregarCasa(Jugador unJugador) {
		this.verificarJugador(unJugador);
		this.verificarLimiteDeCasas();
		this.getDuenio().sustraerDinero(this.precioCasa);
		this.cantidadDeCasas ++;
	}

	private void verificarLimiteDeCasas() {
		if(this.cantidadDeCasas != 0) {
			throw new AccionInvalidaError("Ya se construyo una casa");
		}
	}
	
	private void destruirEdificios() {
		this.cantidadDeCasas = 0;
	}



	@Override
	public void cobrarAlquilerA(Jugador unJugador) {
		Dinero alquiler = this.alquileres.get(cantidadDeCasas);
		unJugador.sustraerDinero(alquiler);
		this.getDuenio().agregarDinero(alquiler);
	}


	@Override
	public void comprar(Jugador unJugador) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void vender(Jugador unJugador) {
		// TODO Auto-generated method stub
		
	}
	

}
