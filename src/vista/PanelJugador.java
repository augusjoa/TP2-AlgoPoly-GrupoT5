package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.AlgoPoly;
import vista.eventos.TirarDadosOnAction;

public class PanelJugador extends HBox{

	public PanelJugador(AlgoPoly partida) {
		Label textoDados = new Label("");
		textoDados.setFont(Font.font("Consolas", FontWeight.BOLD, 25));
		Button btnTirarDados = new Button("Tirar Dados");
		btnTirarDados.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		VBox sectorDado = new VBox();
		sectorDado.setAlignment(Pos.CENTER);
		sectorDado.setSpacing(10);
		sectorDado.getChildren().addAll(btnTirarDados, textoDados);
		btnTirarDados.setOnAction(new TirarDadosOnAction(partida, textoDados));
		
		this.setSpacing(10);
		this.setStyle( "-fx-background-color: lightgrey;");
		this.setPadding(new Insets(15));
		this.getChildren().add(sectorDado);
	}
	

}
