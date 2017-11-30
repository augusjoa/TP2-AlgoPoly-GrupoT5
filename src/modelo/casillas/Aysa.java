package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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
	
	@Override
	public VBox loadPanelInfo(VBox panelInfo) {
		
		Label nombre = new Label("Nombre: " + this.nombre);
		
		
		panelInfo.getChildren().add(nombre);
		return panelInfo;
	}
	
}
