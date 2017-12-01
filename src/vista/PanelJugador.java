package vista;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.AlgoPoly;
import vista.eventos.ComprarAdquiribleOnAction;
import vista.eventos.PagarFianzaOnAction;
import vista.eventos.PasarTurnoOnAction;
import vista.eventos.TirarDadosOnAction;

public class PanelJugador extends HBox{

	private AlgoPoly partida;
	private SectorDado sectorDado;
	private SectorProps sectorProps;
	private SectorEconom sectorEconom;
	private Juego juego;
	
	public PanelJugador(AlgoPoly partida,Juego juego) {
		this.partida = partida;
		this.juego = juego;
		
		sectorEconom = new SectorEconom(juego);
		sectorDado = new SectorDado(juego, this);
		sectorProps = new SectorProps(partida);
		
		
		this.setSpacing(10);
//		this.setStyle( "-fx-background-color: lightgrey;");
		this.setPadding(new Insets(15));
		
		this.getChildren().addAll(sectorDado, crearSeparador(),sectorProps, crearSeparador(), sectorEconom);
	
	}
	
	public void update(){
		sectorProps.update();
		updateDados();
	}
	
	
	public void updateDados(){
		sectorDado.getTextoDados().setText("");
	}

	private Separator crearSeparador() {
		Separator unSeparador = new Separator(Orientation.VERTICAL);
		unSeparador.setStyle("-fx-background-color: black;");
		return unSeparador;
	}

	
	
	public Button getBotonPagarFianza() {
		return sectorEconom.getBotonPagarFianza();
	}

	public SectorDado getSectorDados() {
		return sectorDado;
	}

	public Button getBotonCompra() {
		return sectorEconom.getBotonCompra();
	}

}
