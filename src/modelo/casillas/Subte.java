package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;

public class Subte implements Visitable,Adquirible {

	private Dinero costoDeLaCompania;
	private Jugador duenio = null;
	private Tren tren;
	
	public Subte(){
		costoDeLaCompania = new Dinero(40000);
	}
	
	public void conoceATren(Tren unTren){
		tren=unTren;
	}
	
	public boolean tieneDuenioDoble(){
		Jugador duenioDeLaCompania = duenio;
		return  duenioDeLaCompania.esDuenio(this)  && duenioDeLaCompania.esDuenio(tren);
	}
	
	@Override
	public Jugador esVisitadoPorJugador(Jugador unJugador) {
		
		if(tieneDuenioDoble()){
			Dinero valorASustraerDoble= new Dinero(1100*unJugador.getNumeroDelDado());
			unJugador.sustraerDinero(valorASustraerDoble);
			duenio.agregarDinero(valorASustraerDoble);
		}
		
		else if(!unJugador.esDuenio(this)){
			Dinero valorASustraer= new Dinero(600*unJugador.getNumeroDelDado());
			unJugador.sustraerDinero(valorASustraer);
			duenio.agregarDinero(valorASustraer);
		}
		return null;
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

}
