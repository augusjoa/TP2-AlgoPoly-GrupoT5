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
		if(duenio == null) return false;
		return  duenio.esDuenio(this)  && duenio.esDuenio(otraCompania);
	}
	
	public boolean tieneDuenio(){
		return duenio!=null;
	}
	
	public void cobrarAlquiler(int precio,Jugador unJugador){
		Dinero valorASustraerDoble = new Dinero(precio * unJugador.getNumeroDelDado());
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
		duenio = unJugador;
	}
	
	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		
		if(tieneDuenio() && tieneDuenioDoble()){
			cobrarAlquiler(vecesQueCobraDoble,unJugador);
		}
		
		else if(!unJugador.esDuenio(this) && tieneDuenio()){
			cobrarAlquiler(vecesQueCobra,unJugador);
		}
	}
	
	@Override
	public void comprar(Jugador unJugador){
		if(!tieneDuenio()){
			unJugador.sustraerDinero(costoDeLaCompania);
			setDuenio(unJugador);
		}
		//catch jugador perdio?
	}
	
	@Override
	public void vender(Jugador unJugador){
		if(unJugador.esDuenio(this)){
			Dinero costoConRetencion = new Dinero(costoDeLaCompania);
			costoConRetencion.aplicarImpuesto(porcentajeRetencionDeVenta);
			unJugador.agregarDinero(costoConRetencion);
			duenio=null;
		}	
	}
	
}
