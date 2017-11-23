package modelo.casillas;

import java.util.Hashtable;

import modelo.Dinero;
import modelo.Jugador;

public class BarrioSimple extends Barrio {
	private int cantidadDeCasas = 0;
	private Dinero precioCasa;
    private Hashtable<Integer, Dinero> alquileres = new Hashtable<Integer, Dinero>();


	public BarrioSimple(int precioDelBarrio, int unprecioCasa, int alquilersincasa, int alquilerconcasa) {
		
		super(precioDelBarrio);
		this.precioCasa = new Dinero(unprecioCasa);
		this.alquileres.put(0,new Dinero (alquilersincasa));
		this.alquileres.put(1, new Dinero (alquilerconcasa));
	}
	
	@Override
	public Jugador esVisitadoPorJugador(Jugador unJugador) {
		if(unJugador != this.getDuenio() && (this.getDuenio() != null)){
			unJugador.sustraerDinero(this.alquileres.get(cantidadDeCasas));
		}
		return null;
	}
	
	public int getCantidadDeEdificios() {
		return this.cantidadDeCasas;
	}
	
	public boolean agregarCasa() {
		if (this.cantidadDeCasas == 0) {
			this.getDuenio().sustraerDinero(this.precioCasa);
			this.cantidadDeCasas ++;
			return true;
		}
		return false;
	}
	

}
