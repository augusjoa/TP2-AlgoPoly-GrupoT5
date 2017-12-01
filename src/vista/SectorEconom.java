package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import vista.eventos.PagarFianzaOnAction;

public class SectorEconom extends VBox{
	
	private Button botonPagarFianza;
	private Button botonVender;
	private Button botonComprar;
	private Juego juego;
	private PanelJugador panelJugador;
	
	public SectorEconom(Juego juego) {
		this.juego = juego;
		botonPagarFianza = crearBotonPagarFianza();
		botonVender = crearBotonVender();
		botonComprar = crearBotonComprar();

		this.getChildren().addAll(botonComprar, botonVender, botonPagarFianza);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setPrefWidth(150);
	}
	
	private Button crearBotonComprar() {
		Button botonComprar = new Button("Comprar");
		botonComprar.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		botonComprar.setAlignment(Pos.TOP_CENTER);
		botonComprar.setDisable(true);
		//botonComprar.setOnAction(new ComprarOnAction(juego, sectorDado.getBotonTirarDado(),botonPagarFianza));
		return botonComprar;
	}
	
	private Button crearBotonVender() {
		Button botonVender = new Button("Vender");
		botonVender.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		botonVender.setAlignment(Pos.TOP_CENTER);
		botonVender.setDisable(true);
		//botonVender.setOnAction(new PagarFianzaOnAction(juego, sectorDado.getBotonTirarDado(),botonPagarFianza));
		return botonVender;
	}
	
	private Button crearBotonPagarFianza() {
		Button botonPagarFianza = new Button("Pagar Fianza");
		botonPagarFianza.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		botonPagarFianza.setAlignment(Pos.TOP_CENTER);
		botonPagarFianza.setDisable(true);
		botonPagarFianza.setOnAction(new PagarFianzaOnAction(juego, botonPagarFianza));
		return botonPagarFianza;
	}

	public Button getBotonPagarFianza() {
		return botonPagarFianza;
	}

	public Button getBotonCompra() {
		return botonComprar;
	}
	

}
