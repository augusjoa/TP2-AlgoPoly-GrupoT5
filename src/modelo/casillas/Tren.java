package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;

public class Tren extends Compania{

	
	public Tren(){
		costoDeLaCompania = new Dinero(38000);
		vecesQueCobra=450;
		vecesQueCobraDoble=800;
	}
	

}
