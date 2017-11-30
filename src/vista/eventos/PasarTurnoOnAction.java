package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modelo.AlgoPoly;
import vista.Juego;
import vista.SectorDado;

public class PasarTurnoOnAction implements EventHandler<ActionEvent> {

	AlgoPoly partida;
	Juego juego;
	SectorDado sectorDado;
	Button btnMoverse;
	Label numeroJugador;
	Button btnPasarTurno;
	
	public PasarTurnoOnAction(Juego juego, SectorDado sectorDado, Button btnPasarTurno,  Label numeroJugador) {
		this.juego= juego;
		this.partida = juego.partida();
		this.sectorDado = sectorDado;
		this.numeroJugador = numeroJugador;
		this.btnPasarTurno = btnPasarTurno;
		this.juego=juego;
	}

	@Override
	public void handle(ActionEvent event) {
		partida.avanzarTurno();
		partida.getJugadorActual().iniciarTurno();
		if(partida.getJugadorActual().puedeMoverse()) {
			sectorDado.getBotonTirarDado().setDisable(false);
			btnPasarTurno.setDisable(true);
		}
		else if(!partida.getJugadorActual().puedeMoverse()){
			juego.update();
			System.out.println("no puede moverse y updeteo la imagen");
		}
		actualizarLabelTurno();
		sectorDado.getTextoDados().setText("");
		
	}
	
	private void actualizarLabelTurno(){
		int n= partida.getJugadorActual().getNumeroDelJugador();
		System.out.println("prox jug: "+n);
		numeroJugador.setText("Turno del Jugador: "+ Integer.toString(n));

	}

}
