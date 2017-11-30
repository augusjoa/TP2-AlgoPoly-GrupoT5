package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
		nombre.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		
		Label descripcion = new Label("Descripción: \n Difrute la estadía gratuita!");
		descripcion.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		
		panelInfo.getChildren().addAll(nombre, descripcion);
		return panelInfo;
	}
}
