package modelo.casillas;

import modelo.Dinero;

public class Edesur extends Compania {
	
	private String nombre = "Edesur";
	
	public Edesur(){
		costoDeLaCompania= new Dinero(35000);
		vecesQueCobra=500;
		vecesQueCobraDoble=1000;
	}

	@Override
	public String getNombre(){
		return nombre;
	}
	
}
