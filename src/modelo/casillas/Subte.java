package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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

	@Override
	public VBox loadPanelInfo(VBox panelInfo) {
		
		Label nombre = new Label("Nombre: " + this.nombre);
		
		
		panelInfo.getChildren().add(nombre);
		return panelInfo;
	}
}
