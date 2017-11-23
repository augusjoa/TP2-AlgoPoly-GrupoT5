package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Visitable;

public class ImpuestoAlLujo implements Visitable {

	private int porcentajeDelImpuesto= 10;
	
	public void aplicarImpuesto(Jugador jugador){
		Dinero dineroDelJugador= jugador.getDinero();
		dineroDelJugador.aplicarImpuesto(porcentajeDelImpuesto);
	}
	
	@Override
	public Jugador esVisitadoPorJugador(Jugador unJugador) {
		aplicarImpuesto(unJugador);
		return null;
	}

}
