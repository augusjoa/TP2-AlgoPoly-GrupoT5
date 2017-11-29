package modelo.casillas;

import modelo.Dinero;

public class Subte extends Compania {
	
	private String nombre = "Subte";
	
	public Subte(){
		costoDeLaCompania = new Dinero(40000);
		vecesQueCobra=600;
		vecesQueCobraDoble=1100;
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}

}
