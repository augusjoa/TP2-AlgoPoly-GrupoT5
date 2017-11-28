package vista;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.AlgoPoly;

public class VistaLateralDerecha extends VBox {

	private BarraMenu barraMenu;
	
	public VistaLateralDerecha(Stage stage, Juego juego, AlgoPoly unaPartida){
		barraMenu = new BarraMenu(stage, juego);
		this.getChildren().add(barraMenu);
	}
	
	public BarraMenu getBarraMenu(){
		return barraMenu;
	}
}
