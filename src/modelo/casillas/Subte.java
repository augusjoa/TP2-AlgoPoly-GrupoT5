package modelo.casillas;

import modelo.Dinero;

public class Subte extends Compania {
	
	public Subte(){
		costoDeLaCompania = new Dinero(40000);
		vecesQueCobra=600;
		vecesQueCobraDoble=1100;
		nombre = "Subte";
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}

}
