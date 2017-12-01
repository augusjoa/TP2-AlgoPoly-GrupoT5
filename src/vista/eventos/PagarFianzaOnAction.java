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
import modelo.excepciones.DineroInsuficiente;
import modelo.excepciones.JugadorNoPuedePagarFianza;
import modelo.interfaces.Visitable;
import vista.Juego;

public class PagarFianzaOnAction implements EventHandler<ActionEvent> {

	Juego juego;
	AlgoPoly partida;
	Button botonPagarFianza;
	
	public PagarFianzaOnAction(Juego juego, Button botonPagarFianza){
		this.juego=juego;
		this.partida=juego.partida();
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
					//juego.updateDinero();
		    		juego.updateVistaSuperior();
					botonPagarFianza.setDisable(true);
		
				} catch(JugadorNoPuedePagarFianza excp){
					crearAlertaInformation(casillaActual.getNombre(),"Espere, todavia no puede pagar la finaza.");
				}
				catch(DineroInsuficiente excDin){
					crearAlertaInformation(casillaActual.getNombre(),"No puede pagar la fianza, dinero insuficiente");
				}
			}
		}
	}
		
		public void crearAlertaInformation(String titulo,String texto){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(titulo);
			alert.setHeaderText("");
			alert.setContentText(texto);
			Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			stage.setOnCloseRequest(e->e.consume());
			stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
			stage.showAndWait();
		}
	

}
