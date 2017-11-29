package modelo.casillas;

import modelo.Dinero;

public class Aysa extends Compania {
	
	private String nombre = "Aysa";
	
	public Aysa(){
		costoDeLaCompania= new Dinero(30000);
		vecesQueCobra=300;
		vecesQueCobraDoble=500;
	}

	@Override
	public String getNombre(){
		return nombre;
	}
	
}
