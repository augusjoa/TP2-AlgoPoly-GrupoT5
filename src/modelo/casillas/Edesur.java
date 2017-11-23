package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;

public class Edesur implements Visitable,Adquirible {

	private Jugador duenio = null;
	private Dinero costoDeLaCompania;
	private Aysa aysa;
	
	public Edesur(){
		costoDeLaCompania= new Dinero(35000);
	}
	
	@Override
	public Jugador getDuenio() {
		return duenio;
	}

	@Override
	public Dinero getPrecio() {
		return costoDeLaCompania;
	}

	@Override
	public void setDuenio(Jugador unJugador) {
		duenio=unJugador;
		
	}

	@Override
	public Jugador esVisitadoPorJugador(Jugador unJugador) {
		
		if(tieneDuenioDoble()){
			Dinero valorASustraerDoble= new Dinero(1000*unJugador.getNumeroDelDado());
			unJugador.sustraerDinero(valorASustraerDoble);
			duenio.agregarDinero(valorASustraerDoble);
		}
		
		else if(!unJugador.esDuenio(this)){
			Dinero valorASustraer= new Dinero(500*unJugador.getNumeroDelDado());
			unJugador.sustraerDinero(valorASustraer);
			duenio.agregarDinero(valorASustraer);
		}
		return null;
	}
	
	public void conoceAAysa(Aysa unAysa){
		aysa=unAysa;
	}
	
	public boolean tieneDuenioDoble(){
		Jugador duenioDeLaCompania = duenio;
		return  duenioDeLaCompania.esDuenio(this)  && duenioDeLaCompania.esDuenio(aysa);
	}

}
