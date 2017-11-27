package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.excepciones.JugadorInvalido;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;

public abstract class Barrio implements Adquirible,Visitable{

	protected Dinero valorDelBarrio;
	protected Jugador jugadorDuenio;
	protected String nombre;
	
	public abstract int getCantidadDeEdificios();
	public abstract void cobrarAlquilerA(Jugador unJugador);
	public abstract void agregarCasa(Jugador unJugador);
	public abstract void destruirEdificios();

	
	protected void verificarJugador(Jugador unJugador) throws JugadorInvalido{
		if(jugadorDuenio != unJugador) throw new JugadorInvalido();
	}
	
	public boolean tieneDuenio(){
		return jugadorDuenio != null;
	}
	
	@Override
	public Dinero getPrecio() {
		return valorDelBarrio;
	}

	@Override
	public Jugador getDuenio() {
		return jugadorDuenio;
	}

	@Override
	public void setDuenio(Jugador unJugador) {
		jugadorDuenio = unJugador;
	}
	
	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		if(getDuenio() != unJugador && tieneDuenio()) {
			cobrarAlquilerA(unJugador);
		}
	}
	
	@Override
	public void comprar(Jugador unJugador) {
		if(!tieneDuenio()){
			unJugador.getDinero().sustraerDinero(valorDelBarrio);
			setDuenio(unJugador);
		}
	}
	
	@Override
	public void vender(Jugador unJugador) {
		if(unJugador.esDuenio(this)){
			Dinero costoConRetencion = valorDelBarrio;
			costoConRetencion.aplicarImpuesto(porcentajeRetencionDeVenta);
			unJugador.agregarDinero(costoConRetencion);
			destruirEdificios();
			jugadorDuenio = null;
		}
		
	}
		
}
