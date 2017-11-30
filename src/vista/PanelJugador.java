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
import vista.eventos.PasarTurnoOnAction;
import vista.eventos.TirarDadosOnAction;

public class PanelJugador extends HBox{

	Label dineroDelJugador;
	Label turnoDelJugador;
	AlgoPoly partida;
	SectorDado sectorDado;
	
	public PanelJugador(AlgoPoly partida,Juego juego) {
		this.partida=partida;
		Label textoDados = new Label("");
		textoDados.setFont(Font.font("Consolas", FontWeight.BOLD, 25));
		
		turnoDelJugador = crearLabelTurnoDelJugador();
		
		dineroDelJugador = crearDineroDelJugador();
		
		Separator primerSeparador = crearSeparador();
		
		Separator segundoSeparador = crearSeparador();
		
		Button botonPasarTurno = crearBotonPasarTurno();
		
		Button btnTirarDados = new Button("Tirar Dados");
		btnTirarDados.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		
		sectorDado = new SectorDado(btnTirarDados, textoDados);
		
		btnTirarDados.setOnAction(new TirarDadosOnAction(juego, sectorDado, botonPasarTurno ));
		botonPasarTurno.setOnAction(new PasarTurnoOnAction(juego, sectorDado, botonPasarTurno , turnoDelJugador, dineroDelJugador));
		
		this.setSpacing(10);
//		this.setStyle( "-fx-background-color: lightgrey;");
		this.setPadding(new Insets(15));
		this.getChildren().addAll(sectorDado, primerSeparador, botonPasarTurno,turnoDelJugador, segundoSeparador, dineroDelJugador);

		
	}
	public void update(){
		updateDineroJugador();
		updateJugador();
		updateDados();
	}
	
	public void updateJugador(){
		int n =partida.getJugadorActual().getNumeroDelJugador();
		turnoDelJugador.setText("Turno del Jugador: " + Integer.toString(n));
	}
	public void updateDineroJugador(){
		int dinero = partida.getJugadorActual().getDinero().getValor();
		dineroDelJugador.setText("Dinero: " + Integer.toString(dinero));
	}
	public void updateDados(){
		sectorDado.getTextoDados().setText("");
	}

	private Separator crearSeparador() {
		Separator unSeparador = new Separator(Orientation.VERTICAL);
		unSeparador.setStyle("-fx-background-color: black;");
		return unSeparador;
	}

	private Button crearBotonPasarTurno() {
		Button btnPasarTurno = new Button("Pasar Turno");
		btnPasarTurno.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		btnPasarTurno.setDisable(true);
		btnPasarTurno.setAlignment(Pos.BOTTOM_CENTER);
		return btnPasarTurno;
	}

	private Label crearDineroDelJugador() {
		int dinero = partida.getJugadorActual().getDinero().getValor();
		Label dineroJugador = new Label("Dinero: " + Integer.toString(dinero));
		dineroJugador.setFont(Font.font("Consolas", FontWeight.BOLD, 25));
		dineroJugador.setAlignment(Pos.TOP_LEFT);
		
		return dineroJugador;
	}

	private Label crearLabelTurnoDelJugador() {
		
		int n =partida.getJugadorActual().getNumeroDelJugador();
		Label turnoDelJugador = new Label("Turno del Jugador: " + Integer.toString(n));
		turnoDelJugador.setFont(Font.font("Consolas", FontWeight.BOLD, 25));
		turnoDelJugador.setAlignment(Pos.TOP_RIGHT);
		
		return turnoDelJugador;
	}
	

}
