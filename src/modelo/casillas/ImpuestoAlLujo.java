package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Visitable;

public class ImpuestoAlLujo implements Visitable {

	private int porcentajeDelImpuesto= 10;
	private String nombre="Impuesto al Lujo";
	
	public void aplicarImpuesto(Jugador jugador){
		Dinero dineroDelJugador= jugador.getDinero();
		dineroDelJugador.aplicarImpuesto(porcentajeDelImpuesto);
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}
	
	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		aplicarImpuesto(unJugador);
	}

}
