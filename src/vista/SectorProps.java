package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.AlgoPoly;

public class SectorProps extends VBox {
	private Label turnoDelJugador;
	private Label propiedadesDelJugador;
	private Label dineroDelJugador;
	private AlgoPoly partida;
	
	public SectorProps(AlgoPoly partida) {
		this.partida = partida;
		turnoDelJugador = crearLabelTurnoDelJugador();
		propiedadesDelJugador = crearLabelPropiedadesDelJugador();
		dineroDelJugador = crearLabelDineroDelJugador();
		
		
		
		this.getChildren().addAll(turnoDelJugador, propiedadesDelJugador, dineroDelJugador);
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setPrefWidth(350);
	}
	
	public void updateJugador(){
		int n =partida.getJugadorActual().getNumeroDelJugador();
		turnoDelJugador.setText("Turno del Jugador: " + Integer.toString(n));
	}
	public void updateDineroJugador(){
		int dinero = partida.getJugadorActual().getDinero().getValor();
		dineroDelJugador.setText("Dinero: " + Integer.toString(dinero));
	}
	public void updatePropiedadesJugador(){
		int n = partida.getJugadorActual().getCantidadDePropiedades();
		propiedadesDelJugador.setText("Propiedades: " + Integer.toString(n));
	}

	public void update() {
		updateDineroJugador();
		updateJugador();
		updatePropiedadesJugador();
	}
	
	private Label crearLabelPropiedadesDelJugador() {
		int props = partida.getJugadorActual().getCantidadDePropiedades();
		Label txtProps = new Label("Propiedades: "+ props);
		txtProps.setFont(Font.font("Consolas", FontWeight.BOLD, 25));
		txtProps.setAlignment(Pos.CENTER);
		return txtProps;
	}
	
	private Label crearLabelDineroDelJugador() {
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
