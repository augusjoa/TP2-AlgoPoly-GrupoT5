package vista;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.AlgoPoly;

public class VistaLateralDerecha extends VBox {

	private BarraMenu barraMenu;
	private AlgoPoly partida;
	
	public VistaLateralDerecha(Stage stage, Juego juego){
		partida=juego.partida();
		barraMenu = new BarraMenu(stage, juego);
		this.getChildren().add(barraMenu);
	}
	
	public BarraMenu getBarraMenu(){
		return barraMenu;
	}
}
