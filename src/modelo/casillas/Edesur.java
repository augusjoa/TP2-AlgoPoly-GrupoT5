package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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
	
	@Override
	public VBox loadPanelInfo(VBox panelInfo) {
		
		Label nombre = new Label("Nombre: " + this.nombre);
		
		
		panelInfo.getChildren().add(nombre);
		return panelInfo;
	}
}
