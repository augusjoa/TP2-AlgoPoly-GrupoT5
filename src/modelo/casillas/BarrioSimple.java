package modelo.casillas;

import java.util.Hashtable;

import modelo.Dinero;
import modelo.Jugador;
import modelo.excepciones.BarrioLleno;

public class BarrioSimple extends Barrio {
	
	private int cantidadDeCasas = 0;
	private Dinero precioCasa;
    private Hashtable<Integer, Dinero> alquileres = new Hashtable<Integer, Dinero>();


	public BarrioSimple(int precioDelBarrio, int unprecioCasa, int alquilersincasa, int alquilerconcasa, String unNombre) {
		
		valorDelBarrio = new Dinero(precioDelBarrio);
		nombre=unNombre;
		precioCasa = new Dinero(unprecioCasa);
		alquileres.put(0, new Dinero (alquilersincasa));
		alquileres.put(1, new Dinero (alquilerconcasa));
	}
	
	
	public int getCantidadDeEdificios() {
		return cantidadDeCasas;
	}
	
	public void agregarCasa(Jugador unJugador) {
		verificarJugador(unJugador);
		verificarLimiteDeCasas();
		jugadorDuenio.getDinero().sustraerDinero(precioCasa);
		valorDelBarrio.agregarDinero(precioCasa);
		cantidadDeCasas ++;
	}

	private void verificarLimiteDeCasas() throws BarrioLleno{
		if(cantidadDeCasas > 0)	throw new BarrioLleno();
	}
	
	public void destruirEdificios() {
		if(cantidadDeCasas!=0){
			valorDelBarrio.sustraerDinero(precioCasa);
			cantidadDeCasas = 0;
		}
	}

	@Override
	public void cobrarAlquilerA(Jugador unJugador) {
		Dinero alquiler = alquileres.get(cantidadDeCasas);
		unJugador.getDinero().sustraerDinero(alquiler);
		jugadorDuenio.getDinero().agregarDinero(alquiler);
	}	

}
