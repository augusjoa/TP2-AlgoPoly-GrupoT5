package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.Dinero;

public class Tren extends Compania {

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
	
	@Override
	public VBox loadPanelInfo(VBox panelInfo) {
		
		Label nombre = new Label("Nombre: " + this.nombre);
		
		
		panelInfo.getChildren().add(nombre);
		return panelInfo;
	}
}
