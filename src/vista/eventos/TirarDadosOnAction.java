package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.AlgoPoly;
import vista.Juego;
import vista.SectorDado;


public class TirarDadosOnAction implements EventHandler<ActionEvent> {

	AlgoPoly unAlgoPoly;
	SectorDado unSectorDados;
	Button botonPasarTurno;
	Juego unJuego;
	Button botonPagarFianza;
	Button botonCompra;
	Button botonVenta;
	
	public TirarDadosOnAction(Juego unJuego, SectorDado textoDados, Button botonPasarTurno, Button botonPagarFianza, Button botonCompra, Button botonVenta) {
		this.unJuego = unJuego;
		this.unAlgoPoly = unJuego.partida();
		this.unSectorDados = textoDados;
		this.botonPasarTurno = botonPasarTurno;
		this.botonPagarFianza=botonPagarFianza;
		this.botonCompra=botonCompra;
		this.botonVenta=botonVenta;
	}

	@Override
	public void handle(ActionEvent event) {
		unSectorDados.getTextoDados().setTextFill(Color.BLACK);
		unSectorDados.getTextoDados().setFont(Font.font("Consolas", FontWeight.BOLD, 20));
		unAlgoPoly.getJugadorActual().tirarDados();
		
		if(unAlgoPoly.getJugadorActual().tiradaInvalida()) {
			unSectorDados.getTextoDados().setFont(Font.font("Consolas", FontWeight.BOLD, 15));
			unSectorDados.getTextoDados().setText("Dados Iguales!");
			unSectorDados.getTextoDados().setTextFill(Color.RED);

		}else {
			unSectorDados.getBotonTirarDado().setDisable(true);
			botonPasarTurno.setDisable(false);
			unSectorDados.getTextoDados().setText(""+unAlgoPoly.getJugadorActual().getNumeroDelDado());
			new MoverseOnAction(unAlgoPoly, unJuego, botonPagarFianza,botonCompra,botonVenta).handle(null);
		}
		
	}
	

}