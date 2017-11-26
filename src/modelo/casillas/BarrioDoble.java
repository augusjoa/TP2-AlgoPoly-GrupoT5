package modelo.casillas;

import java.util.Hashtable;

import modelo.Dinero;
import modelo.Jugador;
import modelo.excepciones.AccionInvalidaError;

public class BarrioDoble extends Barrio {
	private static final int LIMITEDECASAS = 2;
	private static final int LIMITEDEHOTEL = 1;
	private int cantidadDeCasas = 0;
	private int cantidadDeHoteles = 0;
	private Dinero precioCasa;
	private Dinero precioHotel;
    private Hashtable<Integer, Dinero> alquileres = new Hashtable<Integer, Dinero>();
    private BarrioDoble otrazona; 

	public BarrioDoble(int precioDelBarrio, int unprecioCasa, int unprecioHotel, int alquilersincasa, int alquilerconcasa, int alquilerconDosCasas, int alquilerconHotel, String unNombre) {
		super(precioDelBarrio, unNombre);
		this.precioCasa = new Dinero(unprecioCasa);
		this.precioHotel = new Dinero(unprecioHotel);
		this.alquileres.put(0,new Dinero (alquilersincasa));
		this.alquileres.put(1, new Dinero (alquilerconcasa));
		this.alquileres.put(2, new Dinero(alquilerconDosCasas));
		this.alquileres.put(3, new Dinero(alquilerconHotel));
	}
	
	public void agregarCasa(Jugador unJugador) {
		this.verificarJugador(unJugador);
		this.verificarConstruccionDeCasas();
		this.getDuenio().sustraerDinero(this.precioCasa);
		this.cantidadDeCasas ++;
	}
	
	private void verificarConstruccionDeCasas() {
		if(this.cantidadDeCasas < LIMITEDECASAS && this.getDuenio().esDuenio(otrazona) && this.cantidadDeHoteles == LIMITEDEHOTEL) {
			throw new AccionInvalidaError("No puede contruir una casa en este Barrio");	
		}
	}
	
	private void verificarOtraZona() {
		if (this.getCantidadDeCasas() != this.otrazona.getCantidadDeCasas()) {
			throw new AccionInvalidaError("No se puede construir hasta que construya todas las casas posibles en la otra zona");
		}
	}

	public void agregarHotel(Jugador unJugador) {
		this.verificarJugador(unJugador);
		this.verificarNumeroDeCasasMaximo();
		this.verificarOtraZona();
		this.getDuenio().sustraerDinero(this.precioHotel);
		this.cantidadDeHoteles ++;
		this.cantidadDeCasas = 0;
	}
	
	private void verificarNumeroDeCasasMaximo() {
		if(this.cantidadDeCasas != LIMITEDECASAS) {
			throw new AccionInvalidaError("No puede construir hoteles hasta contruir el numero maximo de casas");
		}
	}

	public BarrioDoble setOtraZona(BarrioDoble unaZona) {
		//Lo vas a usar al contruir el tablero
		this.otrazona = unaZona;
		return this;
	}
	
	private int getCantidadDeCasas() {
		return this.cantidadDeCasas;
	}
	
	public int getCantidadDeEdificios() {
		return this.cantidadDeCasas + this.cantidadDeHoteles;
	}

	@Override
	public void cobrarAlquilerA(Jugador unJugador) {
		Dinero alquiler = this.alquileres.get(cantidadDeCasas + cantidadDeHoteles);
		unJugador.sustraerDinero(alquiler);
		this.getDuenio().agregarDinero(alquiler);		
	}
	
	private void destuirEdificios() {
		this.cantidadDeCasas = 0;
		this.cantidadDeHoteles = 0;
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
