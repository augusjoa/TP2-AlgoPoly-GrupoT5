package vista;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaSuperior extends VBox {

	BarraMenu barraMenu;
	
	public VistaSuperior(Juego juego, Stage stage){
		barraMenu = new BarraMenu(stage, juego);
		this.getChildren().add(barraMenu);
	}
	
	public BarraMenu getBarraMenu(){
		return barraMenu;
	}
}
