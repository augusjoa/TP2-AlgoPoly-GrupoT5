package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.AlgoPoly;

public class VistaLateralDerecha extends VBox {

	private VBox panelInfo;
	
	public VistaLateralDerecha(Juego juego, AlgoPoly unaPartida){
		this.setStyle( "-fx-background-color: lightgrey;");
		Label textoArranque = new Label("Bienvenido!");
		textoArranque.setFont(Font.font("Consolas", FontWeight.BOLD, 25));
		textoArranque.setAlignment(Pos.BASELINE_CENTER);
		
		Label indicaTurnoInicial = new Label("Es el turno de: Jugador "+ unaPartida.getJugadorActual().getNumeroDelJugador());
		indicaTurnoInicial.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		indicaTurnoInicial.setAlignment(Pos.BASELINE_CENTER);
		
		panelInfo = new VBox();
		panelInfo.setPrefWidth(300);
		panelInfo.resize(USE_PREF_SIZE, USE_COMPUTED_SIZE);
		panelInfo.setSpacing(10);
		panelInfo.setPadding(new Insets(10));
		panelInfo.setStyle( "-fx-background-color: lightblue;");
		panelInfo.getChildren().addAll(textoArranque,indicaTurnoInicial);
		this.getChildren().add(panelInfo);
		this.setSpacing(5);
		panelInfo.requestLayout();

	}

	public VBox getPanelInfo() {
		return panelInfo;
	}
	
}
