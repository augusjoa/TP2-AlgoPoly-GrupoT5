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
	Button btnPasarTurno;
	Juego unJuego;
	
	public TirarDadosOnAction(Juego unJuego, SectorDado textoDados, Button btnPasarTurno) {
		this.unAlgoPoly = unJuego.partida();
		this.unSectorDados = textoDados;
		this.btnPasarTurno = btnPasarTurno;
		this.unJuego = unJuego;
	}

	@Override
	public void handle(ActionEvent event) {
		unSectorDados.getTextoDados().setTextFill(Color.BLACK);
		unSectorDados.getTextoDados().setFont(Font.font("Consolas", FontWeight.BOLD, 20));
		unAlgoPoly.getJugadorActual().tirarDados();
		
		System.out.print("Jugador: " + unAlgoPoly.getJugadorActual().getNumeroDelJugador() + "sacó un: ");
		System.out.print(unAlgoPoly.getJugadorActual().getNumeroDelDado() + " --> ");
		
		if(unAlgoPoly.getJugadorActual().tiradaInvalida()) {
			unSectorDados.getTextoDados().setFont(Font.font("Consolas", FontWeight.BOLD, 15));
			unSectorDados.getTextoDados().setText("Dados Iguales!");
			unSectorDados.getTextoDados().setTextFill(Color.RED);
			
			System.out.print("No avanza\n");

		}else {
			unSectorDados.getBotonTirarDado().setDisable(true);
			btnPasarTurno.setDisable(false);
			unSectorDados.getTextoDados().setText(""+unAlgoPoly.getJugadorActual().getNumeroDelDado());
			System.out.print("está en: " + unAlgoPoly.getJugadorActual().getCasillaActual().getNombre());
			new MoverseOnAction(unAlgoPoly, unJuego).handle(null);
			System.out.print(", y llegó a: " + unAlgoPoly.getJugadorActual().getCasillaActual().getNombre() + "\n");
		}


	}
	

}