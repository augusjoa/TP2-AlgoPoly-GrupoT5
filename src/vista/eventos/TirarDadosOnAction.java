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
	Button bntMoverse;
	
	public TirarDadosOnAction(AlgoPoly unAlgoPoly, SectorDado textoDados, Button bntMoverse) {
		this.unAlgoPoly = unAlgoPoly;
		this.unSectorDados = textoDados;
		this.bntMoverse = bntMoverse;
	}

	@Override
	public void handle(ActionEvent event) {
		unAlgoPoly.getJugadorActual().tirarDados();
		unSectorDados.getBotonTirarDado().setDisable(true);
		unSectorDados.getTextoDados().setText(""+unAlgoPoly.getJugadorActual().getNumeroDelDado());
		System.out.println(unAlgoPoly.getJugadorActual().getNumeroDelDado());
		bntMoverse.setDisable(false);
	}

}