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
import javafx.scene.text.Text;
import modelo.AlgoPoly;
import vista.eventos.MoverseOnAction;
import vista.eventos.PasarTurnoOnAction;
import vista.eventos.TirarDadosOnAction;

public class PanelJugador extends HBox{

	
	
	public PanelJugador(AlgoPoly partida,Juego juego) {
		Label textoDados = new Label("");
		textoDados.setFont(Font.font("Consolas", FontWeight.BOLD, 25));
		

		int n =partida.getJugadorActual().getNumeroDelJugador();
		Label numeroJugador = new Label("Turno del Jugador: " + Integer.toString(n));
		numeroJugador.setFont(Font.font("Consolas", FontWeight.BOLD, 25));
		numeroJugador.setAlignment(Pos.TOP_RIGHT);
		

		//Button btnMoverse= new Button("Moverse");
		//btnMoverse.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		//btnMoverse.setDisable(true);
		//btnMoverse.setOnAction(new MoverseOnAction(partida,juego));
		
		Separator unSeparador = new Separator(Orientation.VERTICAL);
		unSeparador.setStyle("-fx-background-color: black;");
		
		Button btnPasarTurno = new Button("Pasar Turno");
		btnPasarTurno.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		btnPasarTurno.setDisable(true);
		
		Button btnTirarDados = new Button("Tirar Dados");
		btnTirarDados.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		SectorDado sectorDado = new SectorDado(btnTirarDados, textoDados);
		btnTirarDados.setOnAction(new TirarDadosOnAction(juego, sectorDado, btnPasarTurno));


		btnPasarTurno.setOnAction(new PasarTurnoOnAction(partida, sectorDado, btnPasarTurno, numeroJugador));
		
		this.setSpacing(10);
		this.setStyle( "-fx-background-color: lightgrey;");
		this.setPadding(new Insets(15));
		
		this.getChildren().addAll(sectorDado, unSeparador, btnPasarTurno, numeroJugador);

		
	}
	

}
