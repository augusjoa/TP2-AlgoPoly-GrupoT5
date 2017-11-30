package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Salida implements Visitable{

	private String nombre= "Salida";
	
	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {

	}
	
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
