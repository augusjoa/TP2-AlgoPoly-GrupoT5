package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;

public abstract class Compania implements Adquirible,Visitable {

	private Jugador duenio = null;
	protected Dinero costoDeLaCompania;
	protected int vecesQueCobra;
	protected int vecesQueCobraDoble;
	private Compania otraCompania;
	
	
	public boolean tieneDuenioDoble(){
		Jugador duenioDeLaCompania = duenio;
		return  duenioDeLaCompania.esDuenio(this)  && duenioDeLaCompania.esDuenio(otraCompania);
	}
	
	public void cobrarAlquiler(int precio,Jugador unJugador){
		Dinero valorASustraerDoble= new Dinero(precio*unJugador.getNumeroDelDado());
		unJugador.sustraerDinero(valorASustraerDoble);
		duenio.agregarDinero(valorASustraerDoble);
	
	}
	
	public void setOtraCompania(Compania unaCompania){
		otraCompania = unaCompania;
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
	public void esVisitadoPorJugador(Jugador unJugador) {
		
		if(tieneDuenioDoble()){
			cobrarAlquiler(vecesQueCobraDoble,unJugador);
		}
		
		else if(!unJugador.esDuenio(this)){
			cobrarAlquiler(vecesQueCobra,unJugador);
		}
	}
	
	@Override
	public void comprar(Jugador unJugador){
		unJugador.getDinero().sustraerDinero(costoDeLaCompania);
		setDuenio(unJugador);
	}
	
}
