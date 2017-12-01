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
		
		
		Button botonPagarFianza = new Button("Pagar Fianza");
		botonPagarFianza.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		botonPagarFianza.setAlignment(Pos.TOP_CENTER);
		botonPagarFianza.setDisable(true);
		botonPagarFianza.setOnAction(new PagarFianzaOnAction(juego, sectorDado.getBotonTirarDado(),botonPagarFianza));
		
		Button botonCompra = new Button("Comprar");
		botonCompra.setDisable(true);
		botonCompra.setOnAction(new ComprarAdquiribleOnAction(juego,botonCompra));
		
		
		btnTirarDados.setOnAction(new TirarDadosOnAction(juego, sectorDado, botonPasarTurno, botonPagarFianza,botonCompra ));
		botonPasarTurno.setOnAction(new PasarTurnoOnAction(juego, sectorDado, botonPasarTurno , turnoDelJugador, dineroDelJugador, botonPagarFianza,botonCompra));
		
		
		this.setSpacing(10);
//		this.setStyle( "-fx-background-color: lightgrey;");
		this.setPadding(new Insets(15));
		
		this.getChildren().addAll(sectorDado, primerSeparador, botonPasarTurno,turnoDelJugador, segundoSeparador, dineroDelJugador, botonPagarFianza,botonCompra);


		
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
		btnPasarTurno.setAlignment(Pos.TOP_CENTER);
		return btnPasarTurno;
	}

	private Label crearDineroDelJugador() {
		int dinero = partida.getJugadorActual().getDinero().getValor();
		Label dineroJugador = new Label("Dinero: " + Integer.toString(dinero));
		dineroJugador.setFont(Font.font("Consolas", FontWeight.BOLD, 25));
		dineroJugador.setAlignment(Pos.BASELINE_CENTER);
		
		return dineroJugador;
	}

	private Label crearLabelTurnoDelJugador() {
		
		int n =partida.getJugadorActual().getNumeroDelJugador();
		Label turnoDelJugador = new Label("Turno del Jugador: " + Integer.toString(n));
		turnoDelJugador.setFont(Font.font("Consolas", FontWeight.BOLD, 25));
		turnoDelJugador.setAlignment(Pos.CENTER);
		
		return turnoDelJugador;
	}
	

}
