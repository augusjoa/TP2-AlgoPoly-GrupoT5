package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.AlgoPoly;
import vista.SectorDado;


public class TirarDadosOnAction implements EventHandler<ActionEvent> {

	AlgoPoly unAlgoPoly;
	SectorDado unSectorDados;
	Button btnMoverse;
	Button btnPasarTurno;
	
	public TirarDadosOnAction(AlgoPoly unAlgoPoly, SectorDado textoDados, Button btnMoverse, Button btnPasarTurno) {
		this.unAlgoPoly = unAlgoPoly;
		this.unSectorDados = textoDados;
		this.btnMoverse = btnMoverse;
		this.btnPasarTurno = btnPasarTurno;
	}

	@Override
	public void handle(ActionEvent event) {
		unAlgoPoly.getJugadorActual().tirarDados();
		
		if(unAlgoPoly.getJugadorActual().tiradaInvalida()) {
			System.out.println("tirada doble");
		}else {
			unSectorDados.getBotonTirarDado().setDisable(true);
			btnPasarTurno.setDisable(false);
			btnMoverse.setDisable(false);
			unSectorDados.getTextoDados().setText(""+unAlgoPoly.getJugadorActual().getNumeroDelDado());
			System.out.println(unAlgoPoly.getJugadorActual().getNumeroDelDado());
		}


	}
	

}