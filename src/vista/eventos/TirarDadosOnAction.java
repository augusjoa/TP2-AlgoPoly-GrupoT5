package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import modelo.AlgoPoly;


public class TirarDadosOnAction implements EventHandler<ActionEvent> {

	AlgoPoly unAlgoPoly;
	Label unTextoDados;
	
	public TirarDadosOnAction(AlgoPoly unAlgoPoly, Label textoDados) {
		this.unAlgoPoly = unAlgoPoly;
		this.unTextoDados = textoDados;
	}

	@Override
	public void handle(ActionEvent event) {
		unAlgoPoly.getJugadorActual().tirarDados();
		
		unTextoDados.setText(""+unAlgoPoly.getJugadorActual().getNumeroDelDado());
		System.out.println(unAlgoPoly.getJugadorActual().getNumeroDelDado());
		
	}

}