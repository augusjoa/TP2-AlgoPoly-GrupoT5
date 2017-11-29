package vista;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.AlgoPoly;

public class VistaSuperior extends VBox {

	private BarraMenu barraMenu;
	private PanelJugador unPanelJugador;
	
	public VistaSuperior(Stage stage, Juego juego,AlgoPoly partida){
		barraMenu = new BarraMenu(stage, juego);
		unPanelJugador = new PanelJugador(partida);
		this.getChildren().addAll(barraMenu, unPanelJugador);
	}
	
	public BarraMenu getBarraMenu(){
		return barraMenu;
	}
}
