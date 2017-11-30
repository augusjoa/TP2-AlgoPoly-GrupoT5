package modelo.casillas;

import modelo.Dinero;


public class Aysa extends Compania {
	
	public Aysa(){
		costoDeLaCompania= new Dinero(30000);
		vecesQueCobra=300;
		vecesQueCobraDoble=500;
		nombre = "Aysa";
	}

	@Override
	public String getNombre(){
		return nombre;
	}
	
}
