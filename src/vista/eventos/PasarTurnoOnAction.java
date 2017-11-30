package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.AlgoPoly;
import vista.SectorDado;

public class PasarTurnoOnAction implements EventHandler<ActionEvent> {

	AlgoPoly unAlgoPoly;
	SectorDado sectorDado;
	Button btnMoverse;
	Label numeroJugador;
	
	public PasarTurnoOnAction(AlgoPoly unAlgoPoly, SectorDado sectorDado, Button btnMoverse, Label numeroJugador) {
		this.unAlgoPoly = unAlgoPoly;
		this.sectorDado = sectorDado;
		this.btnMoverse = btnMoverse;
		this.numeroJugador = numeroJugador;
	}

	@Override
	public void handle(ActionEvent event) {
		unAlgoPoly.avanzarTurno();
		sectorDado.getBotonTirarDado().setDisable(false);
		sectorDado.getTextoDados().setText("");
		//System.out.println(unAlgoPoly.getJugadorActual());
		btnMoverse.setDisable(true);
		actualizarLabelTurno();
	}
	
	private void actualizarLabelTurno(){
		int n= unAlgoPoly.getJugadorActual().getNumeroDelJugador();
		System.out.println("prox jug: "+n);
		numeroJugador.setText("Turno del Jugador: "+ Integer.toString(n));
	}

}
