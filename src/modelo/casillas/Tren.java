package modelo.casillas;

import modelo.Dinero;

public class Tren extends Compania {

	
	public Tren(){
		costoDeLaCompania = new Dinero(38000);
		vecesQueCobra=450;
		vecesQueCobraDoble=800;
		nombre= "Tren";
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}
	
}
