package vista;


import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.AlgoPoly;

public class VistaSuperior extends VBox {

	private BarraMenu barraMenu;
	private PanelJugador unPanelJugador;
	private AlgoPoly partida;
	
	public VistaSuperior(Stage stage, Juego juego){
		partida= juego.partida();
		barraMenu = new BarraMenu(stage, juego);
		unPanelJugador = new PanelJugador(partida,juego);
		this.getChildren().addAll(barraMenu, unPanelJugador);
		this.setStyle( "-fx-background-color: lightgrey;");
		
	}
	
	public BarraMenu getBarraMenu(){
		return barraMenu;
	}
	
	public void update(){
		unPanelJugador.update();
	}
	
}
