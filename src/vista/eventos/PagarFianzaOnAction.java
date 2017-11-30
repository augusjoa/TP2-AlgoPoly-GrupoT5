package vista.eventos;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.casillas.Carcel;
import modelo.casillas.Quini6;
import modelo.excepciones.JugadorNoPuedePagarFianza;
import modelo.interfaces.Visitable;
import vista.Juego;

public class PagarFianzaOnAction implements EventHandler<ActionEvent> {

	Juego juego;
	AlgoPoly partida;
	Button botonDado;
	Button botonPagarFianza;
	
	public PagarFianzaOnAction(Juego juego,Button botonDado, Button botonPagarFianza){
		this.juego=juego;
		this.partida=juego.partida();
		this.botonDado=botonDado;
		this.botonPagarFianza=botonPagarFianza;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		Visitable casillaActual=partida.getJugadorActual().getCasillaActual();
		
		if(casillaActual == partida.tablero().getCarcel()){
			botonPagarFianza.setDisable(false);
			Alert alertaPagar = new Alert(AlertType.CONFIRMATION);
			alertaPagar.setTitle(casillaActual.getNombre());
			alertaPagar.setHeaderText("");
			alertaPagar.setContentText("La fianza cuesta: "+((Carcel) casillaActual).getValorDeLaFianza()+"\n¿Quiere pagarla?");
			Stage stagePagar = (Stage) alertaPagar.getDialogPane().getScene().getWindow();
			stagePagar.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
			Optional<ButtonType> result = alertaPagar.showAndWait();
			if (result.get() == ButtonType.OK){
				try{
					partida.getJugadorActual().pagarFianza((Carcel) casillaActual);
					juego.updateDinero();
					botonPagarFianza.setDisable(true);
		
				} catch(JugadorNoPuedePagarFianza excp){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(casillaActual.getNombre());
					alert.setHeaderText("");
					alert.setContentText("Todavia no puede pagar la finaza.");
					Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
					stage.setOnCloseRequest(e->e.consume());
					stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
					stage.showAndWait();
				}
			}			
		}
	}

}
