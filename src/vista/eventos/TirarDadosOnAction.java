package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;
import vista.SectorDado;


public class TirarDadosOnAction implements EventHandler<ActionEvent> {

	AlgoPoly unAlgoPoly;
	SectorDado unSectorDados;
	Button unBoton;
	
	public TirarDadosOnAction(AlgoPoly unAlgoPoly, SectorDado textoDados, Button unBoton) {
		this.unAlgoPoly = unAlgoPoly;
		this.unSectorDados = textoDados;
		this.unBoton = unBoton;
	}

	@Override
	public void handle(ActionEvent event) {
		unAlgoPoly.getJugadorActual().tirarDados();
		if(unAlgoPoly.getJugadorActual().tiradaInvalida()) {
			System.out.println("tirada doble");
		}else {
			unSectorDados.getBotonTirarDado().setDisable(true);
			unBoton.setDisable(false);
			unSectorDados.getTextoDados().setText(""+unAlgoPoly.getJugadorActual().getNumeroDelDado());
			System.out.println(unAlgoPoly.getJugadorActual().getNumeroDelDado());
		}
		
	}
	

}