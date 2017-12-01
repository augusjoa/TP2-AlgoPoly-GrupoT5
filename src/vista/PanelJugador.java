package vista;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import modelo.AlgoPoly;

public class PanelJugador extends HBox{

	private SectorDado sectorDado;
	private SectorProps sectorProps;
	private SectorEconom sectorEconom;

	
	public PanelJugador(AlgoPoly partida,Juego juego) {
		sectorEconom = new SectorEconom(juego);
		sectorDado = new SectorDado(juego, this);
		sectorProps = new SectorProps(partida);

		
		
		this.setSpacing(10);
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
	
	public Button getBotonVenta(){
		return sectorEconom.getBotonVenta();
	}

}
