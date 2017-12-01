package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import vista.eventos.PasarTurnoOnAction;
import vista.eventos.TirarDadosOnAction;

public class SectorDado extends VBox {

	private Button btnTirarDados;
	private Button btnpasarTurno;
	private Label textoDados;
	
	public SectorDado(Juego juego, PanelJugador panelJugador){

		btnTirarDados = new Button("Tirar Dados");
		btnTirarDados.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		
		textoDados = new Label("");
		textoDados.setFont(Font.font("Consolas", FontWeight.BOLD, 25));
		
		btnpasarTurno = crearBotonPasarTurno();
		
		btnTirarDados.setOnAction(new TirarDadosOnAction(juego, panelJugador, btnpasarTurno, btnTirarDados, textoDados ));
		btnpasarTurno.setOnAction(new PasarTurnoOnAction(juego, this, btnpasarTurno , panelJugador));
		

		this.getChildren().addAll(btnTirarDados, textoDados, btnpasarTurno);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setPrefWidth(150);
	}
	
	public Button getBotonTirarDado(){
		return btnTirarDados;
	}
	
	public Label getTextoDados(){
		return textoDados;
	}
	
	private Button crearBotonPasarTurno() {
		Button btnPasarTurno = new Button("Pasar Turno");
		btnPasarTurno.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		btnPasarTurno.setDisable(true);
		btnPasarTurno.setAlignment(Pos.TOP_CENTER);
		return btnPasarTurno;
	}
}
