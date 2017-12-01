package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.AlgoPoly;
import vista.Juego;
import vista.PanelJugador;


public class TirarDadosOnAction implements EventHandler<ActionEvent> {

	AlgoPoly unAlgoPoly;
	Button btnPasarTurno;
	Juego unJuego;
	Button botonPagarFianza;
	Button botonCompra;
	Button botonTirarDados;
	Button botonVenta;
	PanelJugador panelJugador;
	Label textoDados;
	
	public TirarDadosOnAction(Juego unJuego, PanelJugador panelJugador, Button btnPasarTurno, Button btnTirarDados, Label textoDados) {
		this.unAlgoPoly = unJuego.partida();
		this.botonTirarDados = btnTirarDados;
		this.panelJugador = panelJugador;
		this.textoDados = textoDados;
		this.btnPasarTurno = btnPasarTurno;
		this.unJuego = unJuego;
		this.botonPagarFianza=panelJugador.getBotonPagarFianza();
		this.botonCompra=panelJugador.getBotonCompra();
		this.botonVenta=panelJugador.getBotonVenta();

	}

	@Override
	public void handle(ActionEvent event) {
		textoDados.setTextFill(Color.BLACK);
		textoDados.setFont(Font.font("Consolas", FontWeight.BOLD, 20));
		unAlgoPoly.getJugadorActual().tirarDados();

	
		if(unAlgoPoly.getJugadorActual().tiradaInvalida()) {
			textoDados.setFont(Font.font("Consolas", FontWeight.BOLD, 15));
			textoDados.setText("Dados Iguales!");
			textoDados.setTextFill(Color.RED);
		}else {
			botonTirarDados.setDisable(true);
			btnPasarTurno.setDisable(false);
			textoDados.setText(""+unAlgoPoly.getJugadorActual().getNumeroDelDado());
			new MoverseOnAction(unJuego, unAlgoPoly, panelJugador).handle(null);
		}
		
	}
	

}