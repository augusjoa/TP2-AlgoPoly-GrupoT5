package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Policia implements Visitable{

	private String nombre= "Policia (envia a carcel)";
	
	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		unJugador.irPreso();
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}
	
	@Override
	public VBox loadPanelInfo(VBox panelInfo) {
		
		Label nombre = new Label("Nombre: " + this.nombre);
		nombre.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		nombre.setWrapText(true);
		
		Label info = new Label("El jugador que caiga aquí se dirigirá automáticamente a la carcel.");
		info.setFont(Font.font("Consolas", FontWeight.NORMAL, 14));
		info.setWrapText(true);
		
		
		panelInfo.getChildren().addAll(nombre,info);
		return panelInfo;
	}
	
}
