package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.excepciones.DineroInsuficiente;
import modelo.excepciones.JugadorInvalido;
import modelo.excepciones.TieneDuenio;
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
	
	@Override
	public boolean tieneDuenio(){
		return jugadorDuenio != null;
	}
	
	@Override
	public String getNombre(){
		return nombre;
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
	public void comprar(Jugador unJugador) throws TieneDuenio,DineroInsuficiente{
		if(!tieneDuenio()){
			unJugador.sustraerDinero(valorDelBarrio);
			unJugador.comprar(this);
			setDuenio(unJugador);
		}
		else throw new TieneDuenio();
	}
	
	@Override
	public void vender(Jugador unJugador) {
		if(unJugador==jugadorDuenio){
			Dinero costoConRetencion = valorDelBarrio;
			costoConRetencion.aplicarImpuesto(porcentajeRetencionDeVenta);
			unJugador.agregarDinero(costoConRetencion);
			destruirEdificios();
			unJugador.vender(this);
			jugadorDuenio = null;
		}
		
	}
		
}
