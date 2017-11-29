package modelo.casillas;

import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;

public class Tren extends Compania{

	private String nombre= "Tren";
	
	public Tren(){
		costoDeLaCompania = new Dinero(38000);
		vecesQueCobra=450;
		vecesQueCobraDoble=800;
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}
	

}
