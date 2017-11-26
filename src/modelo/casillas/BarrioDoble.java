package modelo.casillas;

import java.util.Hashtable;

import modelo.Dinero;
import modelo.Jugador;

public class BarrioDoble extends Barrio {
	private int cantidadDeCasas = 0;
	private int cantidadDeHoteles = 0;
	private Dinero precioCasa;
	private Dinero precioHotel;
    private Hashtable<Integer, Dinero> alquileres = new Hashtable<Integer, Dinero>();
    private BarrioDoble otrazona; 

	public BarrioDoble(int precioDelBarrio, int unprecioCasa, int unprecioHotel, int alquilersincasa, int alquilerconcasa, int alquilerconDosCasas, int alquilerconHotel) {
		super(precioDelBarrio);
		this.precioCasa = new Dinero(unprecioCasa);
		this.precioHotel = new Dinero(unprecioHotel);
		this.alquileres.put(0,new Dinero (alquilersincasa));
		this.alquileres.put(1, new Dinero (alquilerconcasa));
		this.alquileres.put(2, new Dinero(alquilerconDosCasas));
		this.alquileres.put(3, new Dinero(alquilerconHotel));
	}
	
	public boolean agregarCasa() {
		if(this.getDuenio().esDuenio(otrazona) && this.cantidadDeCasas < 2) {
			this.getDuenio().sustraerDinero(this.precioCasa);
			this.cantidadDeCasas ++;
			return true;
		}
		return false;
	}
	
	public boolean agregarHotel() {
		if(this.cantidadDeCasas == 2) {
			this.getDuenio().sustraerDinero(this.precioHotel);
			this.cantidadDeHoteles++;
			return true;
		}
		return false;
	}
	
	public void setOtraZona(BarrioDoble unaZona) {
		//Lo vas a usar al contruir el tablero
		this.otrazona = unaZona;
	}

	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		if(unJugador != this.getDuenio() && (this.getDuenio() != null)){
			unJugador.sustraerDinero(this.alquileres.get(cantidadDeCasas + cantidadDeHoteles));
		}
	}
	public int getCantidadDeEdificios() {
		return this.cantidadDeCasas + this.cantidadDeHoteles;
	}

}
