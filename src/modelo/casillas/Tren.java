package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;

public class Tren implements Visitable,Adquirible{

	private Dinero costoDeLaCompania;
	private Jugador duenio = null;
	private Subte subte;
	
	public Tren(){
		costoDeLaCompania = new Dinero(38000);
	}
	
	public void conoceASubte(Subte unSubte){
		subte=unSubte;
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
		duenio= unJugador;
	}

	public boolean tieneDuenioDoble(){
		Jugador duenioDeLaCompania = duenio;
		return  duenioDeLaCompania.esDuenio(this)  && duenioDeLaCompania.esDuenio(subte);
	}
	
	@Override
	public Jugador esVisitadoPorJugador(Jugador unJugador) {
		
		if(tieneDuenioDoble()){
			Dinero valorASustraerDoble= new Dinero(800*unJugador.getNumeroDelDado());
			unJugador.sustraerDinero(valorASustraerDoble);
			duenio.agregarDinero(valorASustraerDoble);
		}
		
		else if(!unJugador.esDuenio(this)){
			Dinero valorASustraer= new Dinero(450*unJugador.getNumeroDelDado());
			unJugador.sustraerDinero(valorASustraer);
			duenio.agregarDinero(valorASustraer);
		}
		return null;
	}

}
